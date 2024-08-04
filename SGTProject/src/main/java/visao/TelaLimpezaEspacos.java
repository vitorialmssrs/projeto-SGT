package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.EspacosDAO;
import controle.LimpezaDAO;
import modelo.EspacoHotel;
import modelo.Funcionario;
import modelo.LimpezaEspacos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaLimpezaEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDiaA;
	private JTextField textHoraA;
	private JTextField textHoraF;
	private JTextField txtDescricaoLimp;
	private JTextField txtTipoLimp;

	/**
	 * Launch the application.*/
	 
	/**
	 * Create the frame.
	 */
	public TelaLimpezaEspacos(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Preencha as informações para solicitar limpeza");
		lblTitulo.setBounds(404, 134, 1312, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecione o espaço!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(415, 258, 189, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox<EspacoHotel> comboBoxEspaco = new JComboBox<EspacoHotel>();
		
		EspacosDAO eHotel = EspacosDAO.getInstancia();		
		ArrayList<EspacoHotel> espacos = eHotel.listarEspacos();
		for (EspacoHotel espacoHotel : espacos) {
			comboBoxEspaco.addItem(espacoHotel);
		}
		
				
	
		comboBoxEspaco.setBounds(415, 302, 189, 32);
		contentPane.add(comboBoxEspaco);
		
		try {
			MaskFormatter formttDEntrada = new MaskFormatter("##/##/####");
			formttDEntrada.setPlaceholder("");
			textDiaA = new JFormattedTextField(formttDEntrada);
			textDiaA.setToolTipText("Coloque o Dia de Conserto Aqui");
			textDiaA.setBounds(905, 306, 100, 22);
			textDiaA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textDiaA.setColumns(10);
			contentPane.add(textDiaA);
		} catch(Exception e) {
			e.printStackTrace();
			}
		/*
		textDiaA = new JTextField();
		textDiaA.setBounds(905, 306, 100, 22);
		textDiaA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textDiaA);
		textDiaA.setColumns(10);*/
		
		
		 try {
			MaskFormatter formttDEntrada = new MaskFormatter("##:##");
			formttDEntrada.setPlaceholder("");
			textHoraA = new JFormattedTextField(formttDEntrada);
			textHoraA.setToolTipText("Coloque a Hora de Inicio Aqui");
			textHoraA.setBounds(415, 431, 100, 22);
			textHoraA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textHoraA.setColumns(10);
			contentPane.add(textHoraA);
		} catch(Exception e) {
			e.printStackTrace();
			}
		/*	
		textHoraA = new JTextField();
		textHoraA.setBounds(415, 431, 100, 22);
		textHoraA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraA);
		textHoraA.setColumns(10);*/
		
		 try {
				MaskFormatter formttDEntrada = new MaskFormatter("##:##");
				formttDEntrada.setPlaceholder("");
				textHoraA = new JFormattedTextField(formttDEntrada);
				textHoraA.setToolTipText("Coloque a Hora de Inicio Aqui");
				textHoraF.setBounds(905, 430, 100, 22);
				textHoraA.setBorder(new LineBorder(new Color(30, 32, 37), 1));
				textHoraA.setColumns(10);
				contentPane.add(textHoraA);
			} catch(Exception e) {
				e.printStackTrace();
				}
		 /*
		textHoraF = new JTextField();
		textHoraF.setBounds(905, 430, 100, 22);
		textHoraF.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textHoraF);
		textHoraF.setColumns(10);*/
		
		JLabel lblNewLabel_2 = new JLabel("Dia para reservar o espaço para a limpeza\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setBounds(905, 258, 388, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Hora Inicio da Limpeza");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setBounds(415, 378, 203, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora prevista para o termino da limpeza");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setBounds(905, 377, 401, 27);
		contentPane.add(lblNewLabel_5);
		
		txtTipoLimp = new JTextField();
		txtTipoLimp.setBounds(415, 558, 326, 83);
		txtTipoLimp.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(txtTipoLimp);
		txtTipoLimp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Escreva o que precisa ser limpado");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(new Color(1, 50, 1));
		lblNewLabel_8.setBounds(414, 504, 346, 27);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCadastrar = new JButton("Cadastrar limpeza");
		btnCadastrar.setBackground(new Color(1, 50, 1));
		btnCadastrar.setForeground(new Color(252, 251, 244));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimpezaEspacos limpEspaco = new LimpezaEspacos();
				limpEspaco.setEspacos((EspacoHotel) comboBoxEspaco.getSelectedItem());
				
				limpEspaco.setFuncionario(funcionario);
				
	
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				try {
				    LocalDate date = LocalDate.parse(textDiaA.getText(), formatter);
				    limpEspaco.setDia(date);
				} catch (DateTimeParseException e1) {
				    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.");
				   
				}

				DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
				try {
				    LocalTime timeI = LocalTime.parse(textHoraA.getText(), formatterH);
				    limpEspaco.setHoraInicio(timeI);
				} catch (DateTimeParseException e2) {
				    JOptionPane.showMessageDialog(null, "Formato de hora de início inválido. Use o formato HH:mm.");
				    
				}

				try {
				    LocalTime timeF = LocalTime.parse(textHoraF.getText(), formatterH);
				    limpEspaco.setHoraFinal(timeF);
				} catch (DateTimeParseException e3) {
				    JOptionPane.showMessageDialog(null, "Formato de hora final inválido. Use o formato HH:mm.");
				  
				}
		
				limpEspaco.setTipoManutencao(txtDescricaoLimp.getText());
				limpEspaco.setDescricao(txtDescricaoLimp.getText());
				limpEspaco.setTipoManutencao(((EspacoHotel) comboBoxEspaco.getSelectedItem()).getNome());
				
				LimpezaDAO limpDAO = LimpezaDAO.getInstancia();
				int espacoId = limpDAO.inserirLimpeza(limpEspaco);
				
				if(espacoId >0 ) {
					JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "erro");
				}
				
				
			}
		});
		btnCadastrar.setBounds(510, 699, 220, 49);
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
		btnSair_1.setBounds(1139, 709, 176, 39);
		contentPane.add(btnSair_1);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLimpezaEspacos.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblLogo.setBounds(185, 65, 220, 210);
		contentPane.add(lblLogo);
		
		
	}
	}
