package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.EspacosDAO;
import controle.ManutencaoEspacosDAO;
import modelo.EspacoHotel;
import modelo.Funcionario;
import modelo.ManutencaoEspacos;

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
import javax.swing.JTextField;

public class TelaManutencaoEspacosConserto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDiaA;
	private JTextField textHoraA;
	private JTextField textHoraF;
	private JTextField txtDescricao;

	/**
	 * Launch the application.*/
	 
	/**
	 * Create the frame.
	 */
	public TelaManutencaoEspacosConserto(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Preencha as informações para o conserto do espaço desejado");
		lblTitulo.setBounds(362, 65, 1312, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(538, 296, 189, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
				
	
		comboBoxEspaco.setBounds(538, 353, 189, 32);
		contentPane.add(comboBoxEspaco);
		
		textDiaA = new JTextField();
		textDiaA.setBounds(967, 358, 100, 22);
		textDiaA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);
		
		textHoraA = new JTextField();
		textHoraA.setBounds(538, 466, 100, 22);
		textHoraA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);
		
		textHoraF = new JTextField();
		textHoraF.setBounds(967, 466, 100, 22);
		textHoraF.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dia para reservar o espaço para o conserto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setBounds(967, 298, 388, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Hora Inicio para o Conserto");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setBounds(538, 416, 284, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora prevista para o termino do conserto ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setBounds(967, 416, 401, 27);
		contentPane.add(lblNewLabel_5);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(734, 579, 326, 83);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Escreva o que precisa ser consertado");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(new Color(1, 50, 1));
		lblNewLabel_8.setBounds(734, 519, 346, 27);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCadastrar = new JButton("Cadastrar conserto");
		btnCadastrar.setForeground(new Color(1, 50, 1));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManutencaoEspacos manuEspaco = new ManutencaoEspacos();
				manuEspaco.setEspacos((EspacoHotel) comboBoxEspaco.getSelectedItem());
				
				manuEspaco.setFuncionario(funcionario);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse( textDiaA.getText(), formatter);
				manuEspaco.setDiaManutencao(date);
				
				DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime timeI = LocalTime.parse(textHoraA.getText(), formatterH);
				manuEspaco.setHoraInicio(timeI);
				
				DateTimeFormatter formatterI = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime timeF = LocalTime.parse(textHoraF.getText(), formatterH);
				manuEspaco.setHoraFinal(timeF);
		
				manuEspaco.setDescricao(txtDescricao.getText());
				manuEspaco.setTipoManutencao(((EspacoHotel) comboBoxEspaco.getSelectedItem()).getNome());
				
				ManutencaoEspacosDAO manutDAO = ManutencaoEspacosDAO.getInstancia();
				int espacoId = manutDAO.inserirManutencao(manuEspaco);
				
				if(espacoId >0 ) {
					JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
				
			}
		});
		btnCadastrar.setBounds(538, 697, 220, 49);
		contentPane.add(btnCadastrar);
		
		JButton btnSair_1 = new JButton("<- | Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FuncionalidadeFuncionario funcionalidade = new FuncionalidadeFuncionario(funcionario);
				funcionalidade.setExtendedState(JFrame.MAXIMIZED_BOTH);
				funcionalidade.setVisible(true);
				
			}
		});
		btnSair_1.setForeground(new Color(252, 251, 244));
		btnSair_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_1.setBackground(new Color(1, 50, 1));
		btnSair_1.setBounds(1110, 707, 176, 39);
		contentPane.add(btnSair_1);
		
	}
	}
