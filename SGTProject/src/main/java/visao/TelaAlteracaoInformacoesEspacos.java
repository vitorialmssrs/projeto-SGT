package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.EspacosDAO;
import controle.ManutencaoEspacosDAO;
import modelo.EspacoHotel;
import modelo.ManutencaoEspacos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class TelaAlteracaoInformacoesEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDiaA;
	private JTextField textHoraA;
	private JTextField textHoraF;
	private JTextField textResposta;
	private JTextField textField;

	/**
	 * Launch the application.*/
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteracaoInformacoesEspacos frame = new TelaAlteracaoInformacoesEspacos();
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAlteracaoInformacoesEspacos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alteração de informações das dependencias do hotel");
		lblTitulo.setBounds(522, 93, 1229, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JButton btnSair = new JButton("<- |  Sair ");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				FuncionalidadeFuncionario frame = new FuncionalidadeFuncionario();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				
				
			}
		});
	
		btnSair.setBackground(new Color(227, 236, 229));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSair.setForeground(new Color(1, 50, 1));
		btnSair.setBounds(994, 903, 244, 60);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(604, 324, 244, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
				
	
		comboBoxEspaco.setBounds(604, 370, 263, 49);
		contentPane.add(comboBoxEspaco);
		
		textDiaA = new JTextField();
		textDiaA.setBounds(615, 486, 159, 32);
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);
		
		textHoraA = new JTextField();
		textHoraA.setBounds(1106, 482, 159, 32);
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);
		
		textHoraF = new JTextField();
		textHoraF.setBounds(1106, 584, 159, 32);
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dia da abertura ");
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(615, 448, 233, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Horario de abertura");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(1097, 444, 233, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Horario de fechamento");
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(1097, 546, 244, 27);
		contentPane.add(lblNewLabel_5);
		
		textResposta = new JTextField();
		textResposta.setBackground(new Color(255, 255, 255));
		textResposta.setBounds(1106, 378, 159, 32);
		contentPane.add(textResposta);
		textResposta.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(1, 50, 1));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManutencaoEspacos manuEspaco = new ManutencaoEspacos();
				manuEspaco.setTipoManutencao((String) comboBoxOperacao.getSelectedItem());
				manuEspaco.setEspacosHotel((EspacoHotel) comboBoxEspaco.getSelectedItem());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse( textDiaA.getText(), formatter);
				manuEspaco.setDiaManutencao(date);
				
				ManutencaoEspacosDAO manutDAO = ManutencaoEspacosDAO.getInstancia();
				manutDAO.inserirManutencao(manuEspaco);
				
				
			}
		});
		btnCadastrar.setBounds(687, 896, 263, 75);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaManutencaoEspacos.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblNewLabel_6.setBounds(301, 43, 226, 174);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Dia em que o espaço está fechado");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(614, 546, 367, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(614, 584, 159, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Capacidade de pessoas no espaço");
		lblNewLabel_9.setForeground(new Color(1, 50, 1));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(1097, 334, 376, 33);
		contentPane.add(lblNewLabel_9);
		
		
	}
	}
