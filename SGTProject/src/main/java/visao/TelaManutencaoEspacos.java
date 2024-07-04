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
	private JTextField textDiaA;
	private JTextField textDiaF;
	private JTextField textCapacidade;
	private JTextField textHoraA;
	private JTextField textHoraF;
	private JTextField textField;
	private JTextField textField_1;

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
		lblTitulo.setBounds(362, 65, 1229, 49);
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
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setForeground(new Color(1, 50, 1));
		btnSair.setBounds(1590, 890, 126, 27);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(119, 212, 189, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
				
	
		comboBoxEspaco.setBounds(119, 252, 154, 32);
		contentPane.add(comboBoxEspaco);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione qual operação deseja realizar");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(119, 384, 367, 32);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBoxOperacao = new JComboBox<String>();{
			
			comboBoxOperacao.addItem("");
			comboBoxOperacao.addItem("Alterar informação de funcionamento");
			comboBoxOperacao.addItem("Solicitação de limpeza");
			comboBoxOperacao.addItem("Solicitação de conserto");
			
		}
		comboBoxOperacao.setBounds(119, 477, 201, 32);
		contentPane.add(comboBoxOperacao);
		
		textDiaA = new JTextField();
		textDiaA.setBounds(657, 248, 86, 20);
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);
		
		textDiaF = new JTextField();
		textDiaF.setBounds(657, 314, 86, 20);
		contentPane.add(textDiaF);
		textDiaF.setColumns(10);
		
		textCapacidade = new JTextField();
		textCapacidade.setBounds(657, 365, 86, 20);
		contentPane.add(textCapacidade);
		textCapacidade.setColumns(10);
		
		textHoraA = new JTextField();
		textHoraA.setBounds(657, 414, 86, 20);
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);
		
		textHoraF = new JTextField();
		textHoraF.setBounds(657, 465, 86, 20);
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dia abertura");
		lblNewLabel_2.setBounds(657, 212, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dia fechamento");
		lblNewLabel_3.setBounds(653, 279, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hora abertura");
		lblNewLabel_4.setBounds(657, 389, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("hora fechamento");
		lblNewLabel_5.setBounds(657, 440, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Capacidade");
		lblNewLabel_6.setBounds(667, 345, 76, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Escreva o que precisa ser feito a limpeza");
		lblNewLabel_7.setBounds(891, 212, 231, 27);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(891, 250, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(891, 365, 189, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Escreva o que precisa ser consertado");
		lblNewLabel_8.setBounds(891, 333, 180, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(527, 640, 220, 49);
		contentPane.add(btnCadastrar);
		
		
	}
	}
