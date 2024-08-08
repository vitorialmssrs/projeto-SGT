package visao;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.AlteracaoInformacoesEspacosDAO;
import controle.EspacosDAO;
import modelo.AlteracaoInformacoesEspacos;
import modelo.EspacoHotel;
import modelo.Funcionario;

import java.awt.Color;


import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.time.format.DateTimeParseException;

public class TelaAlteracaoInformacoesEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDiaA;
	private JTextField textHoraA;
	private JTextField textHoraF;
	private JTextField textCapacidade;
	private JTextField textDiaF;
	
	/**
	 * Launch the application.*/
	/**
	 * Create the frame.
	 */
	public TelaAlteracaoInformacoesEspacos(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(641, 423, 244, 27);
		contentPane.add(lblNewLabel);
		
		textDiaA = new JTextField();
		textDiaA.setBounds(642, 585, 159, 32);
		textDiaA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);
		
		textDiaF = new JTextField();
		textDiaF.setBounds(641, 683, 159, 32);
		textDiaF.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textDiaF);
		textDiaF.setColumns(10);
		
		textHoraA = new JTextField();
		textHoraA.setBounds(1123, 585, 159, 32);
		textHoraA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);
		
		textHoraF = new JTextField();
		textHoraF.setBounds(1123, 683, 159, 32);
		textHoraF.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);
		
		textCapacidade = new JTextField();
		textCapacidade.setBackground(new Color(255, 255, 255));
		textCapacidade.setBounds(1123, 467, 159, 32);
		textCapacidade.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textCapacidade);
		textCapacidade.setColumns(10);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		comboBoxEspaco.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				EspacoHotel espaco = (EspacoHotel) comboBoxEspaco.getSelectedItem();
				System.out.print(espaco.getId());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
				
				//Dia Abertura
				LocalDate diaabertura = espaco.getDataAbertura();
				String abertura = diaabertura.format(formatter);
				textDiaA.setText(abertura);
				
				//Dia Fechamento
				LocalDate diafechamento = espaco.getDataFechamento();
				String fechamento = diafechamento.format(formatter);
				textDiaF.setText(fechamento);
				
				//Hora Entrada
				LocalTime horaentrada = espaco.getHorarioAbertura();
				String entrada = horaentrada.format(formattertime);
				textHoraA.setText(entrada);
				
				//Hora Saida
				LocalTime horasaida = espaco.getHorarioFechamento();
				String saida = horasaida.format(formattertime);
				textHoraF.setText(saida);
				
				// Capacidade
                int capacidade = espaco.getCapacidade();
                textCapacidade.setText(String.valueOf(capacidade));
				
			}
		});
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
		comboBoxEspaco.setBounds(641, 469, 263, 49);
		contentPane.add(comboBoxEspaco);
		
		JLabel lblNewLabel_2 = new JLabel("Dia da abertura ");
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(642, 547, 233, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Horario de abertura");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(1114, 547, 233, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Horario de fechamento");
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(1114, 645, 244, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaManutencaoEspacosConserto.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblNewLabel_6.setBounds(285, 178, 226, 174);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Dia em que o espaço está fechado");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(641, 645, 367, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Capacidade de pessoas no espaço");
		lblNewLabel_9.setForeground(new Color(1, 50, 1));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(1114, 423, 376, 33);
		contentPane.add(lblNewLabel_9);
		
		
		JButton btnSalvar = new JButton("Salvar alterações");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
				
		String diaAbertura = textDiaA.getText();
        String diafechamento = textDiaF.getText();
        String horaAB = textHoraA.getText();
        String horaF = textHoraF.getText();
        String capacidade = textCapacidade.getText();

        // Verifica se tem alguma coisa
        if (diaAbertura.isEmpty() || diafechamento.isEmpty() || horaAB.isEmpty() || horaF.isEmpty() || capacidade.isEmpty()) {
            TelaPopUpErroFuncionarioCamposNaoPreenchidos frame = new TelaPopUpErroFuncionarioCamposNaoPreenchidos();
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            frame.setVisible(true);  // Exibir uma mensagem de erro preencha todos os campos
        } else {
            try {
                LocalDate diaAberturaI = LocalDate.parse(diaAbertura, formatterDate);
                LocalDate diafechamentoI = LocalDate.parse(diafechamento, formatterDate);
                LocalTime horaABI = LocalTime.parse(horaAB, formatterTime);
                LocalTime horaFI = LocalTime.parse(horaF, formatterTime);
                int capacidadeI = Integer.parseInt(capacidade);

                AlteracaoInformacoesEspacosDAO altDAO = AlteracaoInformacoesEspacosDAO.getInstancia();

                // Cria um novo obj com os novos valores atualizados
                AlteracaoInformacoesEspacos altEspaco = new AlteracaoInformacoesEspacos();
                EspacoHotel espaco = (EspacoHotel) comboBoxEspaco.getSelectedItem();
                altEspaco.setId_espacos(espaco.getId());
                altEspaco.setFuncionario(funcionario);  // Ajuste conforme necessário
                altEspaco.setDiaAbertura(diaAberturaI);
                altEspaco.setDiaFechamento(diafechamentoI);
                altEspaco.setCapacidade(capacidadeI);
                altEspaco.setHoraAbert(horaABI);
                altEspaco.setHoraFech(horaFI);

                // Exibir mensagem de sucesso ou erro
                boolean sucesso = altDAO.atualizarAlteracao(altEspaco);
                if (sucesso) {
                	TelaPopUpSucessoFuncionario frame = new TelaPopUpSucessoFuncionario();
                	frame.setLocationRelativeTo(null);
                	frame.setUndecorated(true);
                	frame.setVisible(true);
                	//JOptionPane.showMessageDialog(null, "Espaço atualizado com sucesso!");
                } else {
                	TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
                	frame.setLocationRelativeTo(null);
                	frame.setUndecorated(true);
                	frame.setVisible(true);
                	//JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o espaço.");
                }
            } catch (DateTimeParseException ex) {
            	TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
            	frame.setLocationRelativeTo(null);
            	frame.setUndecorated(true);
            	frame.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Formato de data ou hora inválido. Use o formato dd/MM/yyyy para datas e HH:mm para horas.");
                //ex.printStackTrace();
            } catch (NumberFormatException ex) {
            	TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
            	frame.setLocationRelativeTo(null);
            	frame.setUndecorated(true);
            	frame.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Capacidade deve ser um número válido.");
                //ex.printStackTrace();
            }
        }
    }
});
				
		btnSalvar.setForeground(new Color(252, 251, 244));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalvar.setBackground(new Color(66, 142, 66));
		btnSalvar.setBounds(641, 816, 234, 39);
		contentPane.add(btnSalvar);
		
		JButton btnSair_1 = new JButton("<- | Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dispose();
				FuncionalidadeFuncionario funcionalidade = new FuncionalidadeFuncionario(funcionario);
				funcionalidade.setUndecorated(true);
				funcionalidade.setExtendedState(JFrame.MAXIMIZED_BOTH);
				funcionalidade.setUndecorated(true);
				funcionalidade.setVisible(true);
			}
		});
		btnSair_1.setForeground(new Color(252, 251, 244));
		btnSair_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_1.setBackground(new Color(1, 50, 1));
		btnSair_1.setBounds(1123, 816, 176, 39);
		contentPane.add(btnSair_1);
		
		JLabel lblCaroFuncionario = new JLabel("Caro Funcionario,");
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblCaroFuncionario.setBounds(543, 174, 479, 110);
		contentPane.add(lblCaroFuncionario);
		
		JLabel lblTitulo = new JLabel("Preencha com as informações para fazer as alterações das dependencias dos espaços do hotel");
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTitulo.setBounds(543, 274, 1163, 45);
		contentPane.add(lblTitulo);
		
		
	}
	}