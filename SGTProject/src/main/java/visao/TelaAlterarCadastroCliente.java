package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedeDAO;
import modelo.Hospede;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class TelaAlterarCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textSobrenome;
	private JTextField txtSenha;
	private JTextField textTelefone;
	private JTextField textEmail;
	Hospede hosp;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					//sempre antes do set visible para abrir em tela cheia 
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public TelaAlterarCadastroCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAlterarCadastroCliente.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCaroFuncionario = new JLabel("Caro cliente,");
		lblCaroFuncionario.setBounds(781, 183, 466, 61);
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setBackground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblCaroFuncionario);
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações para alterar o cadastro: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(781, 258, 559, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNome_Cliente.setBounds(434, 438, 202, 21);
		contentPane.add(lblNome_Cliente);
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSobrenomeCliente.setBounds(1050, 418, 165, 22);
		contentPane.add(lblSobrenomeCliente);
		
		try {
			MaskFormatter formttDT = new MaskFormatter("##/##/####");
			formttDT.setPlaceholder("");
			textDataNascimento = new JFormattedTextField(formttDT);
			textDataNascimento.setEnabled(false);
			textDataNascimento.setToolTipText("Coloque o CPF Aqui");
			textDataNascimento.setForeground(new Color(1, 50, 1));
			textDataNascimento.setBackground(new Color(252, 251, 244));
			textDataNascimento.setBounds(434, 538, 404, 29);
			//textDataNascimento.setText(String.valueOf(hosp.getDatanascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			textDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataNascimento.setColumns(10);
			contentPane.add(textDataNascimento);
			
		} catch(Exception e) {
			e.printStackTrace();
			}

		/*textDataNascimento = new JTextField();
		textDataNascimento.setForeground(new Color(1, 50, 1));
		textDataNascimento.setBackground(new Color(252, 251, 244));
		textDataNascimento.setBounds(357, 426, 404, 29);
		textDataNascimento.setText(String.valueOf(hosp.getDatanascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		contentPane.add(textDataNascimento);
		textDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataNascimento.setColumns(10);*/

		
		JLabel lblTelefone = new JLabel("* Telefone:");
		lblTelefone.setBackground(new Color(1, 50, 1));
		lblTelefone.setForeground(new Color(1, 50, 1));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTelefone.setBounds(434, 578, 236, 21);
		contentPane.add(lblTelefone);
		
		try {
			MaskFormatter formttNIden = new MaskFormatter("###.###.###-##");
			formttNIden.setPlaceholder("");
			textCPF = new JFormattedTextField(formttNIden);
			textCPF.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					HospedeDAO dao = HospedeDAO.getInstancia();  
					String numIdentificacao =  textCPF.getText().trim(); 
			        numIdentificacao = numIdentificacao.replace(".", "");
			        numIdentificacao = numIdentificacao.replace("-", "");
					Long numId = Long.parseLong(numIdentificacao);  

					
					hosp = dao.buscarHospedePorCpf(numId);
					if(hosp!=null) {  
						textPrimeiroNome.setEnabled(true);
						textDataNascimento.setEnabled(true);
						textTelefone.setEnabled(true);
						textSobrenome.setEnabled(true);
						textEmail.setEnabled(true);
						txtSenha.setEnabled(true);
						
						
						textPrimeiroNome.setText(hosp.getPrimeironome());  
						textSobrenome.setText(hosp.getSobrenome());
						textTelefone.setText(hosp.getTelefone());  
						textDataNascimento.setText(hosp.getDatanascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						textEmail.setText(hosp.getEmail());  
					
					}
					
				}
			});
			textCPF.setToolTipText("Coloque o CPF Aqui");
			textCPF.setForeground(new Color(1, 50, 1));
			textCPF.setBackground(new Color(252, 251, 244));
			textCPF.setBounds(434, 404, 404, 29);
			textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
			textCPF.setColumns(11);
			contentPane.add(textCPF);
			
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		/*textCPF = new JTextField();
		textCPF.setToolTipText("");
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setBounds(357, 292, 404, 29);
		contentPane.add(textCPF);
		textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setText(hosp.getPrimeironome());
		textCPF.setColumns(10);*/
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setEditable(false);
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBounds(434, 466, 404, 29);
		//textPrimeiroNome.setText(hosp.getPrimeironome());
		contentPane.add(textPrimeiroNome);
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		
				
		JLabel lblSenhaCad = new JLabel("* Coloque a senha usada no cadastro: ");
		lblSenhaCad.setBackground(new Color(1, 50, 1));
		lblSenhaCad.setForeground(new Color(1, 50, 1));
		lblSenhaCad.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSenhaCad.setBounds(1050, 556, 425, 21);
		contentPane.add(lblSenhaCad);
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCPFCliente.setBounds(434, 374, 300, 18);
		contentPane.add(lblCPFCliente);
		
		
		textSobrenome = new JTextField();
		textSobrenome.setEnabled(false);
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBounds(1050, 444, 404, 29);
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
		//textPrimeiroNome.setText(hosp.getSobrenome());
		contentPane.add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comando para limpar os campos de textos 
				
				textPrimeiroNome.setText("");
				textSobrenome.setText("");
				textCPF.setText("");
				textDataNascimento.setText("");
				txtSenha.setText("");	
				textEmail.setText("");
				textTelefone.setText("");

			}
		});
		
	

		
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(434, 752, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		JButton btnCadastro_Cliente = new JButton("Alterar Informações");
		btnCadastro_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hospede atualizarHospede = new Hospede();
				HospedeDAO hospededao = HospedeDAO.getInstancia();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				//recebe a o conteudo que esta no Text e joga para a variavel 
				String nome = textPrimeiroNome.getText();
				String sobrenome = textSobrenome.getText();
				String numidentificacao = textCPF.getText();
				String dataNascimento = textDataNascimento.getText();
				String telefone = textTelefone.getText();
				String email = textEmail.getText();
				String senha = txtSenha.getText();
						
				numidentificacao = numidentificacao.replace(".", "");
				numidentificacao = numidentificacao.replace("-", "");
				
				int senhai = Integer.parseInt(senha);
				LocalDate dn = LocalDate.parse(dataNascimento, formatter);
				
				
				atualizarHospede.setPrimeironome(nome);
				atualizarHospede.setSobrenome(sobrenome);
				atualizarHospede.setNumidentificacao(Long.parseLong(numidentificacao));
				atualizarHospede.setDatanascimento(dn);
				atualizarHospede.setTelefone(telefone);
				atualizarHospede.setEmail(email);
				atualizarHospede.setSenha(senhai);
				atualizarHospede.setIdcliente(hosp.getIdcliente());
				
				int confirm = hospededao.atualizarHospedeporIdentificacao(atualizarHospede);
				
				if(confirm == 0) {
					//Alterar mensagens para tela de erro/sucesso
					TelaPopUpErroCliente frame = new TelaPopUpErroCliente();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					//AvisoCheckInHospede frame = new AvisoCheckInHospede();
					//frame.setVisible(true);
							}
				else {
					
					dispose();
					
					FuncionalidadeCliente frame2 = new FuncionalidadeCliente();
					frame2.setUndecorated(true);
					frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame2.setVisible(true);
					
					TelaPopUpSucessoCliente frame = new TelaPopUpSucessoCliente();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
							}
				
				
			}
		});
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBounds(855, 752, 212, 39);
		contentPane.add(btnCadastro_Cliente);
		
		JButton btnSair_tela_cad_Cliente = new JButton("<- | Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FuncionalidadeCliente frame = new FuncionalidadeCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
				
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_tela_cad_Cliente.setBounds(1278, 752, 176, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
		
		JLabel lblInformacaoSenha = new JLabel("Apenas números, com no Máximo 8 caracteres e Sem caracteres especiais.");
		lblInformacaoSenha.setForeground(new Color(255, 0, 0));
		lblInformacaoSenha.setBounds(1050, 579, 518, 13);
		contentPane.add(lblInformacaoSenha);
		
		txtSenha = new JTextField();
		txtSenha.setEnabled(false);
		txtSenha.setForeground(new Color(1, 50, 1));
		txtSenha.setBackground(new Color(252, 251, 244));
		txtSenha.setBounds(1050, 599, 404, 29);
		contentPane.add(txtSenha);
		txtSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAlterarCadastroCliente.class.getResource("/imagens/LogoPI.png")));
		lblNewLabel.setBounds(626, 174, 145, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblDataNascimento_1 = new JLabel("* Data de nascimento:");
		lblDataNascimento_1.setForeground(new Color(1, 50, 1));
		lblDataNascimento_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataNascimento_1.setBackground(new Color(1, 50, 1));
		lblDataNascimento_1.setBounds(434, 506, 236, 21);
		contentPane.add(lblDataNascimento_1);
		
		try {
			MaskFormatter formttDT = new MaskFormatter("(##) #####-####");
			formttDT.setPlaceholder("");
			textTelefone = new JFormattedTextField(formttDT);
			textTelefone.setEnabled(false);
			textTelefone.setToolTipText("Coloque o CPF Aqui");
			textTelefone.setForeground(new Color(1, 50, 1));
			textTelefone.setBackground(new Color(252, 251, 244));
			textTelefone.setBounds(434, 610, 404, 29);
			textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
			//textTelefone.setText(String.valueOf(hosp.getTelefone()));
			textTelefone.setColumns(10);
			contentPane.add(textTelefone);
			
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		/*textTelefone = new JTextField();
		textTelefone.setForeground(new Color(1, 50, 1));
		textTelefone.setColumns(10);
		textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone.setBackground(new Color(252, 251, 244));
		textTelefone.setBounds(357, 498, 404, 29);
		contentPane.add(textTelefone);*/
		
		JLabel lblEmail = new JLabel("* Email: ");
		lblEmail.setForeground(new Color(1, 50, 1));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBackground(new Color(1, 50, 1));
		lblEmail.setBounds(1050, 484, 340, 21);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setForeground(new Color(1, 50, 1));
		textEmail.setColumns(10);
		textEmail.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail.setBackground(new Color(252, 251, 244));
		textEmail.setBounds(1050, 516, 404, 29);
		//textPrimeiroNome.setText(hosp.getEmail());
		contentPane.add(textEmail);
		
	}

	

}
