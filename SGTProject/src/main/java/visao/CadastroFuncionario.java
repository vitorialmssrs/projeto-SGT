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
	private JTextField textEmail_Funcionario;
	private JTextField textTelefone_Funcionario;
	private JTextField textCep_Funcionario;
	private JTextField textRua_Funcionario;
	private JTextField textNumero_Funcionario;
	private JTextField textBairro_Funcionario;
	private JTextField textCPF_Funcionario;

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
		lblLogo.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\Châteu_Imperial-removebg-preview 1.png"));
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
		textNome_Funcionario.setBounds(739, 289, 644, 21);
		textNome_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textNome_Funcionario);
		textNome_Funcionario.setColumns(10);
		
		JLabel lblEmail_Funcionario = new JLabel("Email do Funcionário:");
		lblEmail_Funcionario.setBackground(new Color(1, 50, 1));
		lblEmail_Funcionario.setForeground(new Color(1, 50, 1));
		lblEmail_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail_Funcionario.setBounds(553, 330, 162, 13);
		contentPane.add(lblEmail_Funcionario);
		
		textEmail_Funcionario = new JTextField();
		textEmail_Funcionario.setForeground(new Color(1, 50, 1));
		textEmail_Funcionario.setBackground(new Color(252, 251, 244));
		textEmail_Funcionario.setBounds(739, 329, 644, 21);
		contentPane.add(textEmail_Funcionario);
		textEmail_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail_Funcionario.setColumns(10);
		
		JLabel lblTelefone_Funcionario = new JLabel("Telefone:");
		lblTelefone_Funcionario.setBackground(new Color(1, 50, 1));
		lblTelefone_Funcionario.setForeground(new Color(1, 50, 1));
		lblTelefone_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone_Funcionario.setBounds(553, 362, 87, 21);
		contentPane.add(lblTelefone_Funcionario);
		
		textTelefone_Funcionario = new JTextField();
		textTelefone_Funcionario.setForeground(new Color(1, 50, 1));
		textTelefone_Funcionario.setBackground(new Color(252, 251, 244));
		textTelefone_Funcionario.setBounds(642, 365, 192, 21);
		contentPane.add(textTelefone_Funcionario);
		textTelefone_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone_Funcionario.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBackground(new Color(1, 50, 1));
		lblEndereco.setForeground(new Color(1, 50, 1));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(553, 435, 87, 21);
		contentPane.add(lblEndereco);
		
		JLabel lblCep_Funcionario = new JLabel("Cep:");
		lblCep_Funcionario.setForeground(new Color(1, 50, 1));
		lblCep_Funcionario.setBackground(new Color(1, 50, 1));
		lblCep_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCep_Funcionario.setBounds(553, 472, 45, 21);
		contentPane.add(lblCep_Funcionario);
		
		textCep_Funcionario = new JTextField();
		textCep_Funcionario.setForeground(new Color(1, 50, 1));
		textCep_Funcionario.setBackground(new Color(252, 251, 244));
		textCep_Funcionario.setBounds(608, 472, 129, 21);
		contentPane.add(textCep_Funcionario);
		textCep_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCep_Funcionario.setColumns(10);
		
		JLabel lblRua_Funcionario = new JLabel("Rua:");
		lblRua_Funcionario.setBackground(new Color(1, 50, 1));
		lblRua_Funcionario.setForeground(new Color(1, 50, 1));
		lblRua_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRua_Funcionario.setBounds(756, 469, 45, 21);
		contentPane.add(lblRua_Funcionario);
		
		textRua_Funcionario = new JTextField();
		textRua_Funcionario.setForeground(new Color(1, 50, 1));
		textRua_Funcionario.setBackground(new Color(252, 251, 244));
		textRua_Funcionario.setBounds(811, 472, 370, 21);
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
		
		JLabel lblBairro_Funcionario = new JLabel("Bairro:");
		lblBairro_Funcionario.setBackground(new Color(1, 50, 1));
		lblBairro_Funcionario.setForeground(new Color(1, 50, 1));
		lblBairro_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBairro_Funcionario.setBounds(553, 517, 59, 13);
		contentPane.add(lblBairro_Funcionario);
		
		textBairro_Funcionario = new JTextField();
		textBairro_Funcionario.setForeground(new Color(1, 50, 1));
		textBairro_Funcionario.setBackground(new Color(252, 251, 244));
		textBairro_Funcionario.setBounds(622, 515, 347, 23);
		contentPane.add(textBairro_Funcionario);
		textBairro_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textBairro_Funcionario.setColumns(10);
		
		JLabel lblCPF_Funcionario = new JLabel("CPF / CRNM / RNN / RNE:");
		lblCPF_Funcionario.setForeground(new Color(1, 50, 1));
		lblCPF_Funcionario.setBackground(new Color(1, 50, 1));
		lblCPF_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCPF_Funcionario.setBounds(553, 397, 214, 13);
		contentPane.add(lblCPF_Funcionario);
		
		textCPF_Funcionario = new JTextField();
		textCPF_Funcionario.setForeground(new Color(1, 50, 1));
		textCPF_Funcionario.setBackground(new Color(252, 251, 244));
		textCPF_Funcionario.setBounds(777, 396, 606, 21);
		textCPF_Funcionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textCPF_Funcionario);
		textCPF_Funcionario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comando para limpar os campos 
				
				 textNome_Funcionario.setText(" ");
				 textEmail_Funcionario.setText(" ");
				 textTelefone_Funcionario.setText(" ");
				 textCep_Funcionario.setText(" ");
				 textRua_Funcionario.setText(" ");
				 textNumero_Funcionario.setText(" ");
				 textBairro_Funcionario.setText(" ");
				 textCPF_Funcionario.setText(" ");
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
				String email = textEmail_Funcionario.getText();
				String telefone = textTelefone_Funcionario.getText();
				String cpf = textCPF_Funcionario.getText();
				String cep = textCep_Funcionario.getText();
				String rua = textRua_Funcionario.getText();
				String  numero = textNumero_Funcionario.getText();
				String  bairro = textBairro_Funcionario.getText();
				
				//Verifica se tem alguma coisa
				if(nome.isEmpty()) {
					// exibir uma mensagem de erro
				}else {
					
				//Instanciar o OBJETO do cadastro
				Funcionario f = new Funcionario();
				
				//Setar valores digitados nos atributos do OBJETO
				f.setPrimeiroNome(nome);
				
				//Instanciar o DAO
				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				//Fazer a INSERÇÃO
			    boolean valida = dao.inserirFuncionario(f);
					
				}
				
			}
		});
		btnCadastrar.setBackground(new Color(66, 142, 66));
		btnCadastrar.setForeground(new Color(252, 251, 244));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastrar.setBounds(843, 623, 176, 39);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("<- | Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSair.setForeground(new Color(252, 251, 244));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair.setBounds(1204, 714, 176, 39);
		contentPane.add(btnSair);
	}
}
