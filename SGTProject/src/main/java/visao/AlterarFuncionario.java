package visao;

import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
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

import controle.FuncionarioDAO;
import modelo.Funcionario;

;

public class AlterarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeFuncionario;
	private JTextField textNumeroIndentificacao;
	private JTextField textCepFuncionario;
	private JTextField textDataFuncionario;
	private JTextField textNumeroCasaFuncionario;
	private JTextField textLogin;
	private JTextField textSenha;
	private JTextField textTelefone;


	/**
	 * Create the frame.
	 * @param funcionarioLogado 
	 */
	public AlterarFuncionario(Funcionario funcionarioLogado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCaroFuncionario = new JLabel("Caro funcionário,");
		lblCaroFuncionario.setBounds(553, 44, 466, 61);
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setBackground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblCaroFuncionario);

		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Verifique sua informações, caso nescessário altere as informações");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(553, 115, 875, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(
				AlterarFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 1.png")));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(33, 185, 486, 451);
		contentPane.add(lblLogo);

		JLabel lblInformacoes_Funcionario = new JLabel("Informações do Funcionário");
		lblInformacoes_Funcionario.setForeground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setBackground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes_Funcionario.setBounds(553, 245, 466, 31);
		contentPane.add(lblInformacoes_Funcionario);

		JLabel lblNomeFuncionario = new JLabel("Nome Completo:");
		lblNomeFuncionario.setBackground(new Color(1, 50, 1));
		lblNomeFuncionario.setForeground(new Color(1, 50, 1));
		lblNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNomeFuncionario.setBounds(553, 286, 143, 21);
		contentPane.add(lblNomeFuncionario);

		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setForeground(new Color(1, 50, 1));
		textNomeFuncionario.setBackground(new Color(252, 251, 244));
		textNomeFuncionario.setBounds(688, 286, 644, 21);
		textNomeFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textNomeFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textNomeFuncionario.setText(funcionarioLogado.getNomeCompleto());
		contentPane.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);

		JLabel lblNumeroIndentificacao = new JLabel("Numero de Identificação:");
		lblNumeroIndentificacao.setBackground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroIndentificacao.setBounds(553, 327, 200, 21);
		contentPane.add(lblNumeroIndentificacao);

		try {
			MaskFormatter formttDEntrada = new MaskFormatter("###.###.###-##");
			formttDEntrada.setPlaceholder("");
			textNumeroIndentificacao = new JFormattedTextField(formttDEntrada);
			textNumeroIndentificacao.setToolTipText("Coloque o CPF Aqui");
			textNumeroIndentificacao.setForeground(new Color(1, 50, 1));
			textNumeroIndentificacao.setBackground(new Color(252, 251, 244));
			textNumeroIndentificacao.setBounds(763, 330, 602, 21);
			textNumeroIndentificacao.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textNumeroIndentificacao.setText(String.valueOf(funcionarioLogado.getNumIndentificacao()));
			textNumeroIndentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
			textNumeroIndentificacao.setColumns(10);
			contentPane.add(textNumeroIndentificacao);
		} catch(Exception e) {
			e.printStackTrace();
			}
		/*textNumeroIndentificacao = new JTextField();
		textNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		textNumeroIndentificacao.setBackground(new Color(252, 251, 244));
		textNumeroIndentificacao.setBounds(763, 330, 602, 21);
		textNumeroIndentificacao.setText(String.valueOf(funcionarioLogado.getNumIndentificacao()));
		contentPane.add(textNumeroIndentificacao);
		textNumeroIndentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroIndentificacao.setColumns(10);*/

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBackground(new Color(1, 50, 1));
		lblEndereco.setForeground(new Color(1, 50, 1));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(553, 462, 87, 21);
		contentPane.add(lblEndereco);

		JLabel lblCepFuncionario = new JLabel("Cep:");
		lblCepFuncionario.setForeground(new Color(1, 50, 1));
		lblCepFuncionario.setBackground(new Color(1, 50, 1));
		lblCepFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCepFuncionario.setBounds(553, 493, 45, 21);
		contentPane.add(lblCepFuncionario);

		try {
			MaskFormatter formttDEntrada = new MaskFormatter("#####-###");
			formttDEntrada.setPlaceholder("");
			textCepFuncionario = new JFormattedTextField(formttDEntrada);
			textCepFuncionario.setToolTipText("Coloque o CEP da sua Residencia Aqui");
			textCepFuncionario.setForeground(new Color(1, 50, 1));
			textCepFuncionario.setBackground(new Color(252, 251, 244));
			textCepFuncionario.setBounds(600, 493, 129, 21);
			textCepFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textCepFuncionario.setText(String.valueOf(funcionarioLogado.getCep()));
			textCepFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
			textCepFuncionario.setColumns(10);
			contentPane.add(textCepFuncionario);
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		/*textCepFuncionario = new JTextField();
		textCepFuncionario.setForeground(new Color(1, 50, 1));
		textCepFuncionario.setBackground(new Color(252, 251, 244));
		textCepFuncionario.setBounds(600, 493, 129, 21);
		textCepFuncionario.setText(String.valueOf(funcionarioLogado.getCep()));
		contentPane.add(textCepFuncionario);
		textCepFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCepFuncionario.setColumns(10);*/

		JLabel lblDataFuncionario = new JLabel("Data de Nascimento:");
		lblDataFuncionario.setBackground(new Color(1, 50, 1));
		lblDataFuncionario.setForeground(new Color(1, 50, 1));
		lblDataFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataFuncionario.setBounds(553, 370, 176, 21);
		contentPane.add(lblDataFuncionario);

		/*try {
			MaskFormatter formttDEntrada = new MaskFormatter("##/##/####");
			formttDEntrada.setPlaceholder("");
			textDataFuncionario = new JFormattedTextField(formttDEntrada);
			textDataFuncionario.setToolTipText("Coloque a Data de Nascimento Aqui");
			textDataFuncionario.setForeground(new Color(1, 50, 1));
			textDataFuncionario.setBackground(new Color(252, 251, 244));
			textDataFuncionario.setBounds(719, 373, 143, 21);
			textDataFuncionario.setText(String.valueOf(funcionarioLogado.getDataNascismento()));
			textDataFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataFuncionario.setColumns(10);
			contentPane.add(textDataFuncionario);
		} catch(Exception e) {
			e.printStackTrace();
			}*/
		textDataFuncionario = new JTextField();
		textDataFuncionario.setForeground(new Color(1, 50, 1));
		textDataFuncionario.setBackground(new Color(252, 251, 244));
		textDataFuncionario.setBounds(719, 373, 143, 21);
		textDataFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textDataFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textDataFuncionario.setText(String.valueOf(funcionarioLogado.getDataNascismento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		contentPane.add(textDataFuncionario);
		textDataFuncionario.setColumns(10);

		JLabel lblNumeroFuncionario = new JLabel("Número:");
		lblNumeroFuncionario.setForeground(new Color(1, 50, 1));
		lblNumeroFuncionario.setBackground(new Color(1, 50, 1));
		lblNumeroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroFuncionario.setBounds(553, 533, 72, 17);
		contentPane.add(lblNumeroFuncionario);

		textNumeroCasaFuncionario = new JTextField();
		textNumeroCasaFuncionario.setForeground(new Color(1, 50, 1));
		textNumeroCasaFuncionario.setBackground(new Color(252, 251, 244));
		textNumeroCasaFuncionario.setBounds(632, 535, 97, 19);
		textNumeroCasaFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textNumeroCasaFuncionario.setText(String.valueOf(funcionarioLogado.getNumCasa()));
		contentPane.add(textNumeroCasaFuncionario);
		textNumeroCasaFuncionario.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		textNumeroCasaFuncionario.setColumns(10);

		JLabel lblTelefoneFuncionario = new JLabel("Telefone:");
		lblTelefoneFuncionario.setForeground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setBackground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefoneFuncionario.setBounds(553, 414, 97, 21);
		contentPane.add(lblTelefoneFuncionario);

		/*textTelefone = new JTextField();
		textTelefone.setForeground(new Color(1, 50, 1));
		textTelefone.setBackground(new Color(252, 251, 244));
		textTelefone.setBounds(633, 417, 168, 21);
		textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone.setText(String.valueOf(funcionarioLogado.getTelefone()));
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);*/
		
		try {
			MaskFormatter formttDEntrada = new MaskFormatter("(##) #####-####");
			formttDEntrada.setPlaceholder("");
			textTelefone = new JFormattedTextField(formttDEntrada);
			textTelefone.setToolTipText("Coloque o seu Telefone Aqui");
			textTelefone.setForeground(new Color(1, 50, 1));
			textTelefone.setBackground(new Color(252, 251, 244));
			textTelefone.setBounds(633, 417, 168, 21);
			textTelefone.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textTelefone.setText(String.valueOf(funcionarioLogado.getTelefone()));
			textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
			textTelefone.setColumns(10);
			contentPane.add(textTelefone);
		} catch(Exception e) {
			e.printStackTrace();
			}

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comando para limpar os campos

				textNomeFuncionario.setText(" ");
				textNumeroIndentificacao.setText(" ");
				textCepFuncionario.setText(" ");
				textDataFuncionario.setText(" ");
				textNumeroCasaFuncionario.setText(" ");
				textTelefone.setText(" ");
				textLogin.setText(" ");
				textSenha.setText(" ");

			}
		});
		btnLimpar.setForeground(new Color(252, 251, 244));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar.setBackground(new Color(109, 164, 109));
		btnLimpar.setBounds(725, 714, 176, 39);
		contentPane.add(btnLimpar);

		JButton btnSair = new JButton("<- | Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(252, 251, 244));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair.setBounds(1266, 714, 176, 39);
		contentPane.add(btnSair);
		
		JLabel lblInformacoes_Login_Senha = new JLabel("Informações de Login/Senha");
		lblInformacoes_Login_Senha.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes_Login_Senha.setBounds(553, 582, 301, 21);
		contentPane.add(lblInformacoes_Login_Senha);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(553, 623, 60, 21);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSenha.setBounds(553, 660, 72, 21);
		contentPane.add(lblSenha);
		
		textLogin = new JTextField();
		textLogin.setBackground(new Color(255, 255, 245));
		textLogin.setBounds(612, 627, 644, 19);
		textLogin.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textLogin);
		textLogin.setBorder(new LineBorder(new Color(1, 50, 1)));
		textLogin.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBackground(new Color(255, 255, 245));
		textSenha.setBounds(612, 664, 289, 19);
		textSenha.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textSenha);
		textSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Long numIdentificacao = Long.parseLong(textNumeroIndentificacao.getText());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				String numIdentificacao = textNumeroIndentificacao.getText();
				String nomeCompleto = textNomeFuncionario.getText();
				String telefone = textTelefone.getText();
				String cep = textCepFuncionario.getText();
				String numCasa = textNumeroCasaFuncionario.getText();
				String dataNascismento = textDataFuncionario.getText();
				String login = textLogin.getText();
				String senha = textSenha.getText();
				
				//Verifica se tem alguma coisa
				if(nomeCompleto.isEmpty() || numIdentificacao.isEmpty() || dataNascismento.isEmpty() || telefone.isEmpty() || cep.isEmpty() || numCasa.isEmpty()
						|| login.isEmpty() || senha.isEmpty()){
					TelaPopUpErroFuncionarioCamposNaoPreenchidos frame = new TelaPopUpErroFuncionarioCamposNaoPreenchidos();
					frame.setVisible(true);	/*exibir uma mensagem de erro preencha todos os campos*/
					
				}else {
					
					numIdentificacao = numIdentificacao.replace(".", "");
					numIdentificacao = numIdentificacao.replace("-", "");
					cep = cep.replace("-", "");
					
					
					Long numIndentificacaoI = Long.valueOf(numIdentificacao);
					int cepI = Integer.parseInt(cep);
					int numCasaI = Integer.valueOf(numCasa);
					LocalDate dataNascismentoI = LocalDate.parse(dataNascismento, formatter);
					
					FuncionarioDAO funcioDAO = FuncionarioDAO.getInstancia();
					
					// Cria um novo obj com os novos valores atualizados
					Funcionario funcionarioAtualizado = new Funcionario();
					funcionarioAtualizado.setIdFuncionario(funcionarioLogado.getIdFuncionario());
					funcionarioAtualizado.setNumIndentificacao(numIndentificacaoI);
					funcionarioAtualizado.setNomeCompleto(nomeCompleto);
					funcionarioAtualizado.setDataNascismento(dataNascismentoI);
					funcionarioAtualizado.setTelefone(telefone);
					funcionarioAtualizado.setCep(cepI);
					funcionarioAtualizado.setNumCasa(numCasaI);
					funcionarioAtualizado.setLogin(login);
					funcionarioAtualizado.setSenha(senha);
	

			        // Chamar o método para atualizar o funcionário utilizando o número de identificação
			        boolean sucesso = funcioDAO.atualizarFuncionarioPorIndentificacao(funcionarioAtualizado);
			        
			        // Exibir mensagem de sucesso ou erro
			        if (sucesso) {
			        	TelaPopUpSucessoFuncionario frame = new TelaPopUpSucessoFuncionario();
			        	frame.setVisible(true); //JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
			        	
			            
			        } else {
			        	TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
			        	frame.setVisible(true);// JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o funcionário.");
			           
			        }
				}	
			}
		});
		
		btnNewButton.setBackground(new Color(61, 115, 84));
		btnNewButton.setForeground(new Color(252, 251, 244));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(960, 717, 176, 39);
		contentPane.add(btnNewButton);
	}
}
