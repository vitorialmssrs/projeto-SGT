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

public class TelaManutencaoEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDiaM;
	private JTextField textHoraI;
	private JTextField textHoraT;
	private JTextField textResposta;

	/**
	 * Launch the application.*/
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManutencaoEspacos frame = new ManutencaoEspacos();
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
	public TelaManutencaoEspacos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecione qual manutenção você deseja fazer no espaço:");
		lblTitulo.setBounds(442, 96, 1229, 49);
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
		lblNewLabel.setBounds(192, 360, 244, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
				
	
		comboBoxEspaco.setBounds(192, 406, 263, 66);
		contentPane.add(comboBoxEspaco);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione qual operação deseja realizar");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(192, 538, 425, 32);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBoxOperacao = new JComboBox<String>();{
			
			comboBoxOperacao.addItem("");
			comboBoxOperacao.addItem("Alterar informação de funcionamento");
			comboBoxOperacao.addItem("Solicitação de limpeza");
			comboBoxOperacao.addItem("Solicitação de conserto");
			
		}
		comboBoxOperacao.setBounds(192, 609, 263, 66);
		contentPane.add(comboBoxOperacao);
		
		textDiaM = new JTextField();
		textDiaM.setBounds(808, 420, 159, 32);
		contentPane.add(textDiaM);
		textDiaM.setColumns(10);
		
		textHoraI = new JTextField();
		textHoraI.setBounds(808, 503, 159, 32);
		contentPane.add(textHoraI);
		textHoraI.setColumns(10);
		
		textHoraT = new JTextField();
		textHoraT.setBounds(808, 600, 159, 32);
		contentPane.add(textHoraT);
		textHoraT.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dia da manutenção");
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(808, 382, 459, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Hora prevista para ser feita a manutenção");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(797, 465, 453, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora prevista para o termino da manutenção");
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(797, 541, 468, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Escreva qual manutenção precisa ser feita");
		lblNewLabel_7.setForeground(new Color(1, 50, 1));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(1415, 371, 401, 27);
		contentPane.add(lblNewLabel_7);
		
		textResposta = new JTextField();
		textResposta.setBackground(new Color(255, 255, 255));
		textResposta.setBounds(1415, 468, 379, 153);
		contentPane.add(textResposta);
		textResposta.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Limpeza nas dependencias do hotel");
		lblNewLabel_8.setForeground(new Color(2, 115, 2));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(1415, 427, 289, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(1, 50, 1));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManutencaoEspacos manuEspaco = new ManutencaoEspacos();
				manuEspaco.setTipoManutencao((String) comboBoxOperacao.getSelectedItem());
				manuEspaco.setEspacosHotel((EspacoHotel) comboBoxEspaco.getSelectedItem());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse( textDiaM.getText(), formatter);
				manuEspaco.setDiaManutencao(date);
				
				ManutencaoEspacosDAO manutDAO = ManutencaoEspacosDAO.getInstancia();
				manutDAO.inserirManutencao(manuEspaco);
				
				
			}
		});
		btnCadastrar.setBounds(687, 896, 263, 75);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_3 = new JLabel("Conserto nas dependencias do hotel");
		lblNewLabel_3.setForeground(new Color(2, 115, 2));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(1415, 402, 340, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaManutencaoEspacos.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblNewLabel_6.setBounds(221, 46, 226, 174);
		contentPane.add(lblNewLabel_6);
		
		
	}
	}
