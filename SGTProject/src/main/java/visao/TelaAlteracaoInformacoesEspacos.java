package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.AlteracaoInformacoesEspacosDAO;
import controle.EspacosDAO;
import modelo.AlteracaoInformacoesEspacos;
import modelo.EspacoHotel;
import modelo.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alteração de informações das dependencias do hotel");
		lblTitulo.setBounds(349, 133, 1064, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(447, 267, 244, 27);
		contentPane.add(lblNewLabel);
		
		textDiaA = new JTextField();
		textDiaA.setBounds(448, 429, 159, 32);
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);
		
		textDiaF = new JTextField();
		textDiaF.setBounds(447, 527, 159, 32);
		contentPane.add(textDiaF);
		textDiaF.setColumns(10);
		
		textHoraA = new JTextField();
		textHoraA.setBounds(949, 425, 159, 32);
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);
		
		textHoraF = new JTextField();
		textHoraF.setBounds(949, 527, 159, 32);
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);
		
		textCapacidade = new JTextField();
		textCapacidade.setBackground(new Color(255, 255, 255));
		textCapacidade.setBounds(949, 327, 159, 32);
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
		
		comboBoxEspaco.setBounds(447, 313, 263, 49);
		contentPane.add(comboBoxEspaco);
	
		JLabel lblNewLabel_2 = new JLabel("Dia da abertura ");
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(448, 391, 233, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Horario de abertura");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(940, 387, 233, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Horario de fechamento");
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(940, 489, 244, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaManutencaoEspacosConserto.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblNewLabel_6.setBounds(113, 79, 226, 174);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Dia em que o espaço está fechado");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(447, 489, 367, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_9 = new JLabel("Capacidade de pessoas no espaço");
		lblNewLabel_9.setForeground(new Color(1, 50, 1));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(940, 283, 376, 33);
		contentPane.add(lblNewLabel_9);
		
		JButton btnSalvar = new JButton("Salvar alterações");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
				
				String diaAbertura = textDiaA.getText();
				String diafechamento = textDiaF.getText();
				String horaAB = textHoraA.getText();
				String horaF = textHoraF.getText();
				String capacidade = textCapacidade.getText();

				
				//Verifica se tem alguma coisa
				if(diaAbertura.isEmpty() || diafechamento.isEmpty() || horaAB.isEmpty() || horaF.isEmpty() || capacidade.isEmpty()) { 
					
					TelaPopUpErroFuncionarioCamposNaoPreenchidos frame = new TelaPopUpErroFuncionarioCamposNaoPreenchidos();
					frame.setVisible(true);	/*exibir uma mensagem de erro preencha todos os campos*/
					
				}else {
					
					diaAbertura = diaAbertura.replace("/", "");
					diaAbertura = diaAbertura.replace("/", "");
					
					diafechamento = diafechamento.replace("/", "");
					diafechamento = diafechamento.replace("/", "");
					
					horaAB = horaAB.replace(":", "");
					horaAB = horaAB.replace(":", "");
					
					horaF = horaF.replace(":", "");
					horaF = horaF.replace(":", "");
					
										
					LocalDate diaAberturaI = LocalDate.parse(diaAbertura, formatter);
					LocalDate diafechamentoI = LocalDate.parse(diafechamento, formatter);
					int capacidadeI = Integer.valueOf(capacidade);
					LocalTime horaABI = LocalTime.parse(horaAB);
					LocalTime horaFI = LocalTime.parse(horaF);
					
					
					AlteracaoInformacoesEspacosDAO altDAO = AlteracaoInformacoesEspacosDAO.getInstancia();
					
					// Cria um novo obj com os novos valores atualizados
					AlteracaoInformacoesEspacos altEspaco = new AlteracaoInformacoesEspacos();
					
					altEspaco.setFuncionario(altEspaco.getFuncionario());
					altEspaco.setDiaAbertura(diaAberturaI);
					altEspaco.setDiaFechamento(diafechamentoI);
					altEspaco.setCapacidade(capacidadeI);
					altEspaco.setHoraAbert(horaABI);
					altEspaco.setHoraFech(horaFI);
	
			        
			        // Exibir mensagem de sucesso ou erro
			        boolean sucesso = altDAO.atualizarAlteracao(altEspaco);
					if (sucesso) {
			        	//TelaPopUpSucessoFuncionario frame = new TelaPopUpSucessoFuncionario();
			        	//frame.setVisible(true); 
			        	JOptionPane.showMessageDialog(null, "Espaço atualizado com sucesso!");
			        	
			            
			        } else {
			        	//TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
			        	//frame.setVisible(true); 
			        	JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o espaço."); 
			        } 
				}	
				}
				
		});
				
				
		btnSalvar.setForeground(new Color(252, 251, 244));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalvar.setBackground(new Color(66, 142, 66));
		btnSalvar.setBounds(447, 660, 234, 39);
		contentPane.add(btnSalvar);
		
		JButton btnSair_1 = new JButton("<- | Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				FuncionalidadeFuncionario funcionalidade = new FuncionalidadeFuncionario(funcionario);
				funcionalidade.setExtendedState(JFrame.MAXIMIZED_BOTH);
				funcionalidade.setVisible(true);
			}
		});
		btnSair_1.setForeground(new Color(252, 251, 244));
		btnSair_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_1.setBackground(new Color(1, 50, 1));
		btnSair_1.setBounds(949, 660, 176, 39);
		contentPane.add(btnSair_1);
		
		
	}
	}