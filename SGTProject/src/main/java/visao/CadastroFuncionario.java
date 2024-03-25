package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.Funcionario;
import controle.FuncionarioDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome_Funcionario;
	private JTextField textSobrenome_Funcionario;
	private JTextField textNumeroIndentificacao;
	private JTextField textCep_Funcionario;
	private JTextField textRua_Funcionario;
	private JTextField textNumero_Funcionario;
	private JTextField textTelefone_Funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
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
		lblLogo.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 1.png")));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(33, 185, 486, 451);
		contentPane.add(lblLogo);
		
		JLabel lblInformacoes_Funcionario = new JLabel("Informações do Funcionário");
		lblInformacoes_Funcionario.setForeground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setBackground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes_Funcionario.setBounds(553, 245, 466, 31);
		contentPane.add(lblInformacoes_Funcionario);
		
		JLabel lblNome_Funcionario = new JLabel("Nome do Funcionário:");
		lblNome_Funcionario.setBackground(new Color(1, 50, 1));
		lblNome_Funcionario.setForeground(new Color(1, 50, 1));
		lblNome_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome_Funcionario.setBounds(553, 286, 176, 21);
		contentPane.add(lblNome_Funcionario);
		
		textNome_Funcionario = new JTextField();
		textNome_Funcionario.setForeground(new Color(1, 50, 1));
		textNome_Funcionario.setBackground(new Color(252, 251, 244));
		textNome_Funcionario.setBounds(733, 289, 644, 21);
		textNome_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textNome_Funcionario);
		textNome_Funcionario.setColumns(10);
		
		JLabel lblSobrenome_Funcionario = new JLabel("Sobrenome do Funcionário:");
		lblSobrenome_Funcionario.setBackground(new Color(1, 50, 1));
		lblSobrenome_Funcionario.setForeground(new Color(1, 50, 1));
		lblSobrenome_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSobrenome_Funcionario.setBounds(553, 330, 231, 13);
		contentPane.add(lblSobrenome_Funcionario);
		
		textSobrenome_Funcionario = new JTextField();
		textSobrenome_Funcionario.setForeground(new Color(1, 50, 1));
		textSobrenome_Funcionario.setBackground(new Color(252, 251, 244));
		textSobrenome_Funcionario.setBounds(775, 329, 602, 21);
		contentPane.add(textSobrenome_Funcionario);
		textSobrenome_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSobrenome_Funcionario.setColumns(10);
		
		JLabel lblNumeroIndentificacao = new JLabel("Numero de Indentificação:");
		lblNumeroIndentificacao.setBackground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroIndentificacao.setBounds(553, 362, 200, 21);
		contentPane.add(lblNumeroIndentificacao);
		
		textNumeroIndentificacao = new JTextField();
		textNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		textNumeroIndentificacao.setBackground(new Color(252, 251, 244));
		textNumeroIndentificacao.setBounds(775, 365, 602, 21);
		contentPane.add(textNumeroIndentificacao);
		textNumeroIndentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroIndentificacao.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBackground(new Color(1, 50, 1));
		lblEndereco.setForeground(new Color(1, 50, 1));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(553, 487, 87, 21);
		contentPane.add(lblEndereco);
		
		JLabel lblCep_Funcionario = new JLabel("Cep:");
		lblCep_Funcionario.setForeground(new Color(1, 50, 1));
		lblCep_Funcionario.setBackground(new Color(1, 50, 1));
		lblCep_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCep_Funcionario.setBounds(553, 531, 45, 21);
		contentPane.add(lblCep_Funcionario);
		
		textCep_Funcionario = new JTextField();
		textCep_Funcionario.setForeground(new Color(1, 50, 1));
		textCep_Funcionario.setBackground(new Color(252, 251, 244));
		textCep_Funcionario.setBounds(703, 507, 129, 21);
		contentPane.add(textCep_Funcionario);
		textCep_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCep_Funcionario.setColumns(10);
		
		JLabel lblRua_Funcionario = new JLabel("Data de Nascimento:");
		lblRua_Funcionario.setBackground(new Color(1, 50, 1));
		lblRua_Funcionario.setForeground(new Color(1, 50, 1));
		lblRua_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRua_Funcionario.setBounds(553, 442, 176, 21);
		contentPane.add(lblRua_Funcionario);
		
		textRua_Funcionario = new JTextField();
		textRua_Funcionario.setForeground(new Color(1, 50, 1));
		textRua_Funcionario.setBackground(new Color(252, 251, 244));
		textRua_Funcionario.setBounds(726, 445, 168, 21);
		textRua_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textRua_Funcionario);
		
		textRua_Funcionario.setColumns(10);
		
		JLabel lblNumero_Funcionario = new JLabel("Número:");
		lblNumero_Funcionario.setForeground(new Color(1, 50, 1));
		lblNumero_Funcionario.setBackground(new Color(1, 50, 1));
		lblNumero_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumero_Funcionario.setBounds(1204, 473, 72, 17);
		contentPane.add(lblNumero_Funcionario);
		
		textNumero_Funcionario = new JTextField();
		textNumero_Funcionario.setForeground(new Color(1, 50, 1));
		textNumero_Funcionario.setBackground(new Color(252, 251, 244));
		textNumero_Funcionario.setBounds(1286, 473, 97, 19);
		contentPane.add(textNumero_Funcionario);
		textNumero_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumero_Funcionario.setColumns(10);
		
		JLabel lblCPF_Funcionario = new JLabel("Telefone:");
		lblCPF_Funcionario.setForeground(new Color(1, 50, 1));
		lblCPF_Funcionario.setBackground(new Color(1, 50, 1));
		lblCPF_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCPF_Funcionario.setBounds(553, 397, 97, 21);
		contentPane.add(lblCPF_Funcionario);
		
		textTelefone_Funcionario = new JTextField();
		textTelefone_Funcionario.setForeground(new Color(1, 50, 1));
		textTelefone_Funcionario.setBackground(new Color(252, 251, 244));
		textTelefone_Funcionario.setBounds(641, 400, 168, 21);
		textTelefone_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textTelefone_Funcionario);
		textTelefone_Funcionario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comando para limpar os campos 
				
				 textNome_Funcionario.setText(" ");
				 textSobrenome_Funcionario.setText(" ");
				 textNumeroIndentificacao.setText(" ");
				 textCep_Funcionario.setText(" ");
				 textRua_Funcionario.setText(" ");
				 textNumero_Funcionario.setText(" ");
				 textTelefone_Funcionario.setText(" ");
			}
		});
		btnLimpar.setForeground(new Color(252, 251, 244));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar.setBackground(new Color(109, 164, 109));
		btnLimpar.setBounds(608, 623, 176, 39);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textNome_Funcionario.getText();
				String email = textSobrenome_Funcionario.getText();
				int telefone = parseInt(textNumeroIndentificacao.getText());
				int cpf = parseInt(textTelefone_Funcionario.getText());
				int cep = parseInt(textCep_Funcionario.getText());
				String rua = textRua_Funcionario.getText();
				int  numero = parseInt(textNumero_Funcionario.getText());;
				
				
				//Verifica se tem alguma coisa
				if(nome.isEmpty()) {
					// exibir uma mensagem de erro
				}else {
					
				//Instanciar o OBJETO do cadastro 
				Funcionario f = new Funcionario();
				
				//Setar valores digitados nos atributos do OBJETO
				f.setPrimeiroNome(nome);
			//	f.setEmail(email);
				f.setTelefone(telefone);
			//	f.setCPF(cpf);
				f.setCep(cep);
			//	f.setRua(rua);
				f.setNumero(numero);
			//	f.setBairro(bairro);
				
				
				//Instanciar o DAO
				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				//Fazer a INSERÇÃO
				int valida = dao.inserirFuncionario(f);
					
				}
			}

			private int parseInt(String text) {
				return 0;
			}
		});
		contentPane.add(btnCadastrar);
		
		btnCadastrar.setBackground(new Color(66, 142, 66));
		btnCadastrar.setForeground(new Color(252, 251, 244));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastrar.setBounds(843, 623, 176, 39);
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
	}
}
