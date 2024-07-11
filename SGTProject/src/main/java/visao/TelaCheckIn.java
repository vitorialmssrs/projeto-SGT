package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedagemDAO;
import controle.HospedeDAO;
import modelo.Hospedagem;
import modelo.Hospede;

import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class TelaCheckIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataEntrada;
	private JTextField textDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textHoraEntrada;
	private JTextField textSobrenome;
	private JTextField txtSenha;
	private JTextField textTelefone;
	private JTextField textEmail;

	/**
	 * Launch the application.
//Removendo o metodo main para poder só rodar pela tela inicial
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckIn frame = new TelaCheckIn();
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
	public TelaCheckIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCheckIn.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCaroFuncionario = new JLabel("Caro cliente,");
		lblCaroFuncionario.setBounds(743, 71, 466, 61);
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setBackground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblCaroFuncionario);
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações para cadastro: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(743, 146, 474, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNome_Cliente.setBounds(360, 263, 202, 21);
		contentPane.add(lblNome_Cliente);
		
		try {
			MaskFormatter formttDEntrada = new MaskFormatter("##/##/####");
			formttDEntrada.setPlaceholder("");
			textDataEntrada = new JFormattedTextField(formttDEntrada);
			textDataEntrada.setToolTipText("Coloque a Data de Entrada do Checkin Aqui");
			textDataEntrada.setForeground(new Color(1, 50, 1));
			textDataEntrada.setBackground(new Color(252, 251, 244));
			textDataEntrada.setBounds(1114, 351, 165, 29);
			textDataEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataEntrada.setColumns(10);
			contentPane.add(textDataEntrada);
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		//textDataEntrada = new JTextField();

		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSobrenomeCliente.setBounds(360, 325, 165, 22);
		contentPane.add(lblSobrenomeCliente);
		
		try {
			MaskFormatter formttDNasc = new MaskFormatter("##/##/####");
			formttDNasc.setPlaceholder("");
			textDataNascimento = new JFormattedTextField(formttDNasc);
			textDataNascimento.setToolTipText("Coloque sua Data de Nascimento Aqui");
			textDataNascimento.setForeground(new Color(1, 50, 1));
			textDataNascimento.setBackground(new Color(252, 251, 244));
			textDataNascimento.setBounds(360, 484, 404, 29);
			textDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataNascimento.setColumns(10);
			contentPane.add(textDataNascimento);
		} catch(Exception e) {
			e.printStackTrace();
			}
		//textDataNascimento = new JTextField();

		JLabel lblTelefone = new JLabel("* Telefone:");
		lblTelefone.setBackground(new Color(1, 50, 1));
		lblTelefone.setForeground(new Color(1, 50, 1));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTelefone.setBounds(360, 524, 236, 21);
		contentPane.add(lblTelefone);
		
		try {
			MaskFormatter formttNIden = new MaskFormatter("###.###.###-##");
			formttNIden.setPlaceholder("");
			textCPF = new JFormattedTextField(formttNIden);
			textCPF.setToolTipText("Coloque o CPF Aqui");
			textCPF.setForeground(new Color(1, 50, 1));
			textCPF.setBackground(new Color(252, 251, 244));
			textCPF.setBounds(360, 417, 404, 29);
			textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
			textCPF.setColumns(11);
			contentPane.add(textCPF);
			
		} catch(Exception e) {
			e.printStackTrace();
			}
		//textCPF = new JTextField();

		JLabel lblDataEntrada = new JLabel("* Data e hora de entrada: ");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setBackground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataEntrada.setBounds(1114, 323, 255, 21);
		contentPane.add(lblDataEntrada);
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setToolTipText("Coloque Seu Primeiro Nome Aqui");
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBounds(360, 291, 404, 29);
		contentPane.add(textPrimeiroNome);
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		
		try {
			MaskFormatter formttHEntr = new MaskFormatter("##:##");
			formttHEntr.setPlaceholder("");
			textHoraEntrada = new JFormattedTextField(formttHEntr);
			textHoraEntrada.setToolTipText("Coloque a Hora de Entrada Aqui");
			textHoraEntrada.setForeground(new Color(1, 50, 1));
			textHoraEntrada.setBackground(new Color(252, 251, 244));
			textHoraEntrada.setBounds(1289, 351, 165, 29);
			textHoraEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
			textHoraEntrada.setColumns(10);
			contentPane.add(textHoraEntrada);
		} catch(Exception e) {
			e.printStackTrace();
			}
		//textHoraEntrada = new JTextField();
				
		JLabel lblSenhaCad = new JLabel("* Crie uma senha para o cadastro: ");
		lblSenhaCad.setBackground(new Color(1, 50, 1));
		lblSenhaCad.setForeground(new Color(1, 50, 1));
		lblSenhaCad.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSenhaCad.setBounds(1114, 463, 340, 21);
		contentPane.add(lblSenhaCad);
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCPFCliente.setBounds(360, 387, 300, 18);
		contentPane.add(lblCPFCliente);
		
		textSobrenome = new JTextField();
		textSobrenome.setToolTipText("Coloque Seu Sobrenome Aqui");
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBounds(360, 351, 404, 29);
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
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
				textDataEntrada.setText("");
				textHoraEntrada.setText("");
				txtSenha.setText("");	
				textTelefone.setText(" ");
				textEmail.setText("");
				

			}
		});
		
	

		
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(588, 638, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		JButton btnCadastro_Cliente = new JButton("Cadastrar");
		btnCadastro_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//recebe a o conteudo que esta no Text e joga para a variavel 
				String nome = textPrimeiroNome.getText();
				String sobrenome = textSobrenome.getText();
				String numidentificacao = textCPF.getText();
				String dataNascimento = textDataNascimento.getText();
				String dataEntrada = textDataEntrada.getText();
				String horaEntrada = textHoraEntrada.getText();
				String telefone = textTelefone.getText();
				String email = textEmail.getText();
				String senha = txtSenha.getText();
				
				
				if(nome.isEmpty()||sobrenome.isEmpty()||numidentificacao.isEmpty()||
dataNascimento.isEmpty()||dataEntrada.isEmpty()||horaEntrada.isEmpty()||telefone.isEmpty()||email.isEmpty()||senha.isEmpty()) {
					TelaPopUpErroCliente frame = new TelaPopUpErroCliente();
					frame.setVisible(true);
				}
				
				numidentificacao = numidentificacao.replace(".", "");
				numidentificacao = numidentificacao.replace("-", "");
				
				int senhai = Integer.parseInt(senha);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");	
				DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
				LocalDate dn = LocalDate.parse(dataNascimento, formatter);
				LocalDate dtEntrada = LocalDate.parse(dataEntrada, formatter);
				LocalTime hrEntrada = LocalTime.parse(horaEntrada,formattertime);

				Long numidentificacaoL = Long.parseLong(numidentificacao);
				
				Hospede hospede = new Hospede();
				
				hospede.setPrimeironome(nome);
				hospede.setSobrenome(sobrenome);
				hospede.setNumidentificacao(numidentificacaoL);
				hospede.setDatanascimento(dn);
				hospede.setTelefone(telefone);
				hospede.setEmail(email);
				hospede.setSenha(senhai);
				
				HospedeDAO dao = new HospedeDAO();

				int id = dao.insertHospede(hospede);
				hospede.setIdcliente(id);
				
				Hospedagem hospedagem = new Hospedagem();
				hospedagem.setDataEntrada(dtEntrada);
				hospedagem.setHoraEntrada(hrEntrada);
				hospedagem.setHospede(hospede);
				HospedagemDAO hospedagemdao = new HospedagemDAO();
				
				hospedagemdao.insertHospedagem(hospedagem);

				dispose();//manter para fechar a tela cadastro
				
				FuncionalidadeCliente frame2 = new FuncionalidadeCliente();
				frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame2.setVisible(true);
				
				TelaPopUpSucessoCliente frame = new TelaPopUpSucessoCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBounds(1042, 638, 176, 39);
		contentPane.add(btnCadastro_Cliente);
		
		JButton btnSair_tela_cad_Cliente = new JButton("<- | Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FuncionalidadeCliente frame = new FuncionalidadeCliente();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_tela_cad_Cliente.setBounds(1549, 863, 176, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
		
		JLabel lblInformacaoSenha = new JLabel("Apenas números, com no Máximo 8 caracteres e Sem caracteres especiais.");
		lblInformacaoSenha.setForeground(new Color(255, 0, 0));
		lblInformacaoSenha.setBounds(1114, 486, 458, 13);
		contentPane.add(lblInformacaoSenha);
		
		txtSenha = new JTextField();
		txtSenha.setToolTipText("Crie sua Senha Aqui");
		txtSenha.setForeground(new Color(1, 50, 1));
		txtSenha.setBackground(new Color(252, 251, 244));
		txtSenha.setBounds(1114, 506, 404, 29);
		contentPane.add(txtSenha);
		txtSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCheckIn.class.getResource("/imagens/LogoPI.png")));
		lblNewLabel.setBounds(588, 62, 145, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblDataNascimento_1 = new JLabel("* Data de nascimento:");
		lblDataNascimento_1.setForeground(new Color(1, 50, 1));
		lblDataNascimento_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataNascimento_1.setBackground(new Color(1, 50, 1));
		lblDataNascimento_1.setBounds(360, 452, 236, 21);
		contentPane.add(lblDataNascimento_1);
		
		try {
			MaskFormatter formttTelef = new MaskFormatter("(##) #####-####");
			formttTelef.setPlaceholder("");
			textTelefone = new JFormattedTextField(formttTelef);
			textTelefone.setToolTipText("Coloque o Número de Telefone Aqui");
			textTelefone.setForeground(new Color(1, 50, 1));
			textTelefone.setColumns(15);
			textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
			textTelefone.setBackground(new Color(252, 251, 244));
			textTelefone.setBounds(360, 556, 404, 29);
			contentPane.add(textTelefone);
		} catch(Exception e) {
			e.printStackTrace();
			}
		//textTelefone = new JTextField();
		
		JLabel lblEmail = new JLabel("* Email: ");
		lblEmail.setForeground(new Color(1, 50, 1));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBackground(new Color(1, 50, 1));
		lblEmail.setBounds(1114, 391, 340, 21);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("Coloque o Email Aqui");
		textEmail.setForeground(new Color(1, 50, 1));
		textEmail.setColumns(10);
		textEmail.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail.setBackground(new Color(252, 251, 244));
		textEmail.setBounds(1114, 423, 404, 29);
		contentPane.add(textEmail);
		
		/*textPrimeiroNome.setText("Otavio");
		textSobrenome.setText("Silva");
		textCPF.setText("12345678945");
		textDataNascimento.setText("20/01/2024");
		textDataEntrada.setText("25/04/2024");
		textHoraEntrada.setText("15:00");
		txtSenha.setText("12345656");	
		textTelefone.setText("(47) 98456-1425");
		textEmail.setText("jvdjhfdj@gmail.com");*/
		
		/*JButton btnExcluirCadastro = new JButton("Excluir");
		btnExcluirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospedagemDAO hospedagemdao = HospedagemDAO.getInstancia();
				Hospedagem hosp = new Hospedagem();
				HospedeDAO hospededao = HospedeDAO.getInstancia();
				
				String numidentificacao = textCPF.getText();
				String senha = txtSenha.getText();
				
				if(!numidentificacao.isEmpty() || !senha.isEmpty()) {
					Long numidentificacaoL = Long.parseLong(numidentificacao);
					int senhai = Integer.parseInt(senha);

					hospedagemdao.removerHospedagem(hosp);
					
					int retorno = hospededao.removerHospede(numidentificacaoL, senhai);
					
					if(retorno != 0) {
						JOptionPane.showMessageDialog(null, "Erro ao Excluir");
					}else{
						JOptionPane.showMessageDialog(null, "Exclussão Sucedida");
					}
				}
			}
		});
		btnExcluirCadastro.setForeground(new Color(252, 251, 244));
		btnExcluirCadastro.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExcluirCadastro.setBackground(new Color(242, 29, 68));
		btnExcluirCadastro.setBounds(1079, 638, 176, 39);
		contentPane.add(btnExcluirCadastro);*/
	}

}
