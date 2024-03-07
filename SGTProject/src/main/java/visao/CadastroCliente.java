package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome_Cliente;
	private JTextField textEmail_Cliente;
	private JTextField textTelefone_Cliente;
	private JTextField textCep_Cliente;
	private JTextField textRua_Cliente;
	private JTextField textNumero_Cliente;
	private JTextField textBairro_Cliente;
	private JTextField textCPF_Cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCaroFuncionario = new JLabel("Caro cliente,");
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
		
		JLabel lblInformacoes_Funcionario = new JLabel("Informações do cliente");
		lblInformacoes_Funcionario.setForeground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setBackground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes_Funcionario.setBounds(553, 245, 466, 31);
		contentPane.add(lblInformacoes_Funcionario);
		
		JLabel lblNome_Cliente = new JLabel("Nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome_Cliente.setBounds(553, 286, 176, 21);
		contentPane.add(lblNome_Cliente);
		
		textNome_Cliente = new JTextField();
		textNome_Cliente.setForeground(new Color(1, 50, 1));
		textNome_Cliente.setBackground(new Color(252, 251, 244));
		textNome_Cliente.setBounds(739, 289, 644, 21);
		textNome_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textNome_Cliente);
		textNome_Cliente.setColumns(10);
		
		JLabel lblEmail_Cliente = new JLabel("Email:");
		lblEmail_Cliente.setBackground(new Color(1, 50, 1));
		lblEmail_Cliente.setForeground(new Color(1, 50, 1));
		lblEmail_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail_Cliente.setBounds(553, 330, 162, 13);
		contentPane.add(lblEmail_Cliente);
		
		textEmail_Cliente = new JTextField();
		textEmail_Cliente.setBackground(new Color(252, 251, 244));
		textEmail_Cliente.setBounds(739, 329, 644, 21);
		contentPane.add(textEmail_Cliente);
		textEmail_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail_Cliente.setColumns(10);
		
		JLabel lblTelefone_Cliente = new JLabel("Telefone:");
		lblTelefone_Cliente.setBackground(new Color(1, 50, 1));
		lblTelefone_Cliente.setForeground(new Color(1, 50, 1));
		lblTelefone_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone_Cliente.setBounds(553, 362, 87, 21);
		contentPane.add(lblTelefone_Cliente);
		
		textTelefone_Cliente = new JTextField();
		textTelefone_Cliente.setBackground(new Color(252, 251, 244));
		textTelefone_Cliente.setBounds(642, 365, 192, 21);
		contentPane.add(textTelefone_Cliente);
		textTelefone_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone_Cliente.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBackground(new Color(1, 50, 1));
		lblEndereco.setForeground(new Color(1, 50, 1));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(554, 453, 87, 21);
		contentPane.add(lblEndereco);
		
		JLabel lblCep_Cliente = new JLabel("Cep:");
		lblCep_Cliente.setForeground(new Color(1, 50, 1));
		lblCep_Cliente.setBackground(new Color(1, 50, 1));
		lblCep_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCep_Cliente.setBounds(554, 490, 45, 21);
		contentPane.add(lblCep_Cliente);
		
		textCep_Cliente = new JTextField();
		textCep_Cliente.setForeground(new Color(252, 251, 244));
		textCep_Cliente.setBackground(new Color(252, 251, 244));
		textCep_Cliente.setBounds(609, 490, 129, 21);
		contentPane.add(textCep_Cliente);
		textCep_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCep_Cliente.setColumns(10);
		
		JLabel lblRua_Cliente = new JLabel("Rua:");
		lblRua_Cliente.setBackground(new Color(1, 50, 1));
		lblRua_Cliente.setForeground(new Color(1, 50, 1));
		lblRua_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRua_Cliente.setBounds(757, 487, 45, 21);
		contentPane.add(lblRua_Cliente);
		
		textRua_Cliente = new JTextField();
		textRua_Cliente.setForeground(new Color(252, 251, 244));
		textRua_Cliente.setBackground(new Color(252, 251, 244));
		textRua_Cliente.setBounds(812, 490, 370, 21);
		textRua_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textRua_Cliente);
		
		textRua_Cliente.setColumns(10);
		
		JLabel lblNumero_Cliente = new JLabel("Número:");
		lblNumero_Cliente.setForeground(new Color(1, 50, 1));
		lblNumero_Cliente.setBackground(new Color(1, 50, 1));
		lblNumero_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumero_Cliente.setBounds(1205, 491, 72, 17);
		contentPane.add(lblNumero_Cliente);
		
		textNumero_Cliente = new JTextField();
		textNumero_Cliente.setForeground(new Color(252, 251, 244));
		textNumero_Cliente.setBackground(new Color(252, 251, 244));
		textNumero_Cliente.setBounds(1287, 491, 97, 19);
		contentPane.add(textNumero_Cliente);
		textNumero_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumero_Cliente.setColumns(10);
		
		JLabel lblBairro_Cliente = new JLabel("Bairro:");
		lblBairro_Cliente.setBackground(new Color(1, 50, 1));
		lblBairro_Cliente.setForeground(new Color(1, 50, 1));
		lblBairro_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBairro_Cliente.setBounds(554, 535, 59, 13);
		contentPane.add(lblBairro_Cliente);
		
		textBairro_Cliente = new JTextField();
		textBairro_Cliente.setBackground(new Color(252, 251, 244));
		textBairro_Cliente.setBounds(623, 533, 347, 23);
		contentPane.add(textBairro_Cliente);
		textBairro_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textBairro_Cliente.setColumns(10);
		
		JLabel lblCPF_Funcionario = new JLabel("CPF / CRNM / RNN / RNE:");
		lblCPF_Funcionario.setForeground(new Color(1, 50, 1));
		lblCPF_Funcionario.setBackground(new Color(1, 50, 1));
		lblCPF_Funcionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCPF_Funcionario.setBounds(553, 406, 214, 13);
		contentPane.add(lblCPF_Funcionario);
		
		textCPF_Cliente = new JTextField();
		textCPF_Cliente.setForeground(new Color(252, 251, 244));
		textCPF_Cliente.setBackground(new Color(252, 251, 244));
		textCPF_Cliente.setBounds(766, 405, 617, 21);
		textCPF_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textCPF_Cliente);
		textCPF_Cliente.setColumns(10);
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(608, 623, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		JButton btnCadastro_Cliente = new JButton("Cadastrar");
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBounds(843, 623, 176, 39);
		contentPane.add(btnCadastro_Cliente);
		
		JButton btnSair_tela_cad_Cliente = new JButton("Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_tela_cad_Cliente.setBounds(1204, 714, 126, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
	}

}
