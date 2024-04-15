package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeFuncionario;
	private JTextField textNumeroIndentificacao;
	private JTextField textCepFuncionario;
	private JTextField textDia;
	private JTextField textNumeroCasaFuncionario;
	private JTextField textTelefone;
	private JTextField textMes;
	private JTextField textAno;
	private JTextField textLogin;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
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

		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações para cadastro: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(553, 115, 474, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(
				CadastroFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 1.png")));
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
		textNomeFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);

		JLabel lblNumeroIndentificacao = new JLabel("Numero de Indentificação:");
		lblNumeroIndentificacao.setBackground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroIndentificacao.setBounds(553, 327, 200, 21);
		contentPane.add(lblNumeroIndentificacao);

		textNumeroIndentificacao = new JTextField();
		textNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		textNumeroIndentificacao.setBackground(new Color(252, 251, 244));
		textNumeroIndentificacao.setBounds(763, 330, 602, 21);
		contentPane.add(textNumeroIndentificacao);
		textNumeroIndentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroIndentificacao.setColumns(10);

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

		textCepFuncionario = new JTextField();
		textCepFuncionario.setForeground(new Color(1, 50, 1));
		textCepFuncionario.setBackground(new Color(252, 251, 244));
		textCepFuncionario.setBounds(600, 493, 129, 21);
		contentPane.add(textCepFuncionario);
		textCepFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCepFuncionario.setColumns(10);

		JLabel lblDataFuncionario = new JLabel("Data de Nascimento:");
		lblDataFuncionario.setBackground(new Color(1, 50, 1));
		lblDataFuncionario.setForeground(new Color(1, 50, 1));
		lblDataFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataFuncionario.setBounds(553, 370, 176, 21);
		contentPane.add(lblDataFuncionario);

		textDia = new JTextField();
		textDia.setForeground(new Color(1, 50, 1));
		textDia.setBackground(new Color(252, 251, 244));
		textDia.setBounds(719, 373, 45, 21);
		textDia.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textDia);

		textDia.setColumns(10);

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
		contentPane.add(textNumeroCasaFuncionario);
		textNumeroCasaFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroCasaFuncionario.setColumns(10);

		JLabel lblTelefoneFuncionario = new JLabel("Telefone:");
		lblTelefoneFuncionario.setForeground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setBackground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefoneFuncionario.setBounds(553, 414, 97, 21);
		contentPane.add(lblTelefoneFuncionario);

		textTelefone = new JTextField();
		textTelefone.setForeground(new Color(1, 50, 1));
		textTelefone.setBackground(new Color(252, 251, 244));
		textTelefone.setBounds(633, 417, 168, 21);
		textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comando para limpar os campos

				textNomeFuncionario.setText(" ");
				textNumeroIndentificacao.setText(" ");
				textCepFuncionario.setText(" ");
				textDia.setText(" ");
				textMes.setText(" ");
				textAno.setText(" ");
				textNumeroCasaFuncionario.setText(" ");
				textTelefone.setText(" ");
				textLogin.setText(" ");
				textSenha.setText(" ");
				
			}
		});
		btnLimpar.setForeground(new Color(252, 251, 244));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar.setBackground(new Color(109, 164, 109));
		btnLimpar.setBounds(600, 714, 176, 39);
		contentPane.add(btnLimpar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomeCompleto = textNomeFuncionario.getText();
				String numIdentificacaoText = textNumeroIndentificacao.getText();
				String diaText = textDia.getText();
				String mesText = textMes.getText();
				String anoText = textAno.getText();
				String telefoneText = textTelefone.getText();
				String cepText = textCepFuncionario.getText();
				String numCasaText = textNumeroCasaFuncionario.getText();
				String login = textLogin.getText();
				String senha = textSenha.getText();
				
			

				if (nomeCompleto.isEmpty() || numIdentificacaoText.isEmpty() || diaText.isEmpty() || mesText.isEmpty()
						|| anoText.isEmpty() || telefoneText.isEmpty() || cepText.isEmpty() || numCasaText.isEmpty() || login.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!"); // SUBSTITUIR JOPTIONPANE por TELA
																						// DE MENSAGEM
				} else {

					// Converte para inteiro
					int numIdentificacao = Integer.valueOf(numIdentificacaoText);
					int telefone = Integer.valueOf(telefoneText);
					int cep = Integer.valueOf(cepText);
					int numCasa = Integer.valueOf(numCasaText);
					int dia = Integer.valueOf(diaText);
					int mes = Integer.valueOf(mesText);
					int ano = Integer.valueOf(anoText);

					// Converte para data
					LocalDate dataConvertida = LocalDate.of(ano, mes, dia);

					// Instanciar o OBJETO do cadastro
					Funcionario f = new Funcionario();

					// Setar valores digitados nos atributos do OBJETO
					f.setNomeCompleto(nomeCompleto);
					f.setNumIndentificacao(numIdentificacao);
					f.setDataNascimento(dataConvertida);
					f.setTelefone(telefone);
					f.setCep(cep);
					f.setNumCasa(numCasa);
					f.setLogin(login);
					f.setSenha(senha);

					// Instanciar o DAO
					FuncionarioDAO dao = FuncionarioDAO.getInstancia();

					// Fazer a INSERÇÃO
					int valida = dao.inserirFuncionario(f);
					if (valida == 1) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!"); // SUBSTITUIR JOPTIONPANE por
																						// TELA DE MENSAGEM
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"); // SUBSTITUIR JOPTIONPANE por TELA DE
																					// MENSAGEM
					}

				}
			}

		});
		contentPane.add(btnCadastrar);

		btnCadastrar.setBackground(new Color(66, 142, 66));
		btnCadastrar.setForeground(new Color(252, 251, 244));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastrar.setBounds(843, 714, 176, 39);
		contentPane.add(btnCadastrar);

		JButton btnSair = new JButton("<- | Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(252, 251, 244));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair.setBounds(1204, 714, 176, 39);
		contentPane.add(btnSair);

		textMes = new JTextField();
		textMes.setForeground(new Color(1, 50, 1));
		textMes.setColumns(10);
		textMes.setBorder(new LineBorder(new Color(1, 50, 1)));
		textMes.setBackground(new Color(252, 251, 244));
		textMes.setBounds(776, 374, 45, 21);
		contentPane.add(textMes);

		textAno = new JTextField();
		textAno.setForeground(new Color(1, 50, 1));
		textAno.setColumns(10);
		textAno.setBorder(new LineBorder(new Color(1, 50, 1)));
		textAno.setBackground(new Color(252, 251, 244));
		textAno.setBounds(831, 374, 45, 21);
		contentPane.add(textAno);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(1, 50, 1));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(553, 610, 72, 21);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBackground(new Color(252, 251, 244));
		textLogin.setBounds(611, 614, 602, 20);
		contentPane.add(textLogin);
		textLogin.setBorder(new LineBorder(new Color(1, 50, 1)));
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setForeground(new Color(1, 50, 1));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSenha.setBounds(553, 652, 72, 17);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBackground(new Color(252, 251, 244));
		textSenha.setBounds(611, 653, 236, 21);
		contentPane.add(textSenha);
		textSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSenha.setColumns(10);
		
		JLabel lblInformacaoLoginSenha = new JLabel("Informações de Login/Senha");
		lblInformacaoLoginSenha.setForeground(new Color(1, 50, 1));
		lblInformacaoLoginSenha.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacaoLoginSenha.setBounds(553, 575, 294, 24);
		contentPane.add(lblInformacaoLoginSenha);
		
		JLabel lblNewLabel = new JLabel("A senha deve conter apenas números, com no Mínimo 6 caracteres e Sem caracteres especiais");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(814, 584, 486, 13);
		contentPane.add(lblNewLabel);
	}
}
