package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.FuncionarioDAO;
import modelo.Funcionario;

import java.awt.Color;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverVerificarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSenha;
	private JTextField textIdentificacao;
	private JTextField textLogin;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverVerificarFuncionario frame = new RemoverVerificarFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RemoverVerificarFuncionario(Funcionario fun) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(252, 251, 244));
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloGrande = new JLabel("Caro funcionário,");
		lblTituloGrande.setBounds(548, 88, 449, 63);
		lblTituloGrande.setForeground(new Color(1, 50, 1));
		lblTituloGrande.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblTituloGrande);
		
		JLabel lblSubtitulo = new JLabel("Informe os dados para realizar a exclusão do cadastro");
		lblSubtitulo.setBounds(548, 171, 743, 33);
		lblSubtitulo.setForeground(new Color(1, 50, 1));
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		contentPane.add(lblSubtitulo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(RemoverVerificarFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 1.png")));
		lblLogo.setBounds(39, 217, 500, 458);
		contentPane.add(lblLogo);
		
		JLabel lblInformacoes = new JLabel("Informações do Funcionário");
		lblInformacoes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes.setBounds(561, 310, 364, 33);
		contentPane.add(lblInformacoes);
		
		textNome = new JTextField();
		textNome.setBounds(708, 364, 662, 26);
		textNome.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome Completo: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(561, 360, 137, 26);
		contentPane.add(lblNome);
		
		JLabel lblIdentificacao = new JLabel("Numero de Identificação:");
		lblIdentificacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdentificacao.setBounds(561, 406, 190, 19);
		contentPane.add(lblIdentificacao);
		
		JLabel lblLoginSenha = new JLabel("Informações de Login/Senha");
		lblLoginSenha.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLoginSenha.setBounds(561, 464, 250, 26);
		contentPane.add(lblLoginSenha);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(561, 518, 51, 19);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSenha.setBounds(561, 561, 83, 19);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(622, 561, 303, 26);
		textSenha.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textSenha);
		
		try {
			MaskFormatter formttDEntrada = new MaskFormatter("###.###.###-##");
			formttDEntrada.setPlaceholder("");
			textIdentificacao = new JFormattedTextField(formttDEntrada);
			textIdentificacao.setBorder(new LineBorder(new Color(30, 32, 37), 1));
			textIdentificacao.setToolTipText("Coloque o CPF Aqui");
			textIdentificacao.setBounds(761, 406, 303, 26);
			textIdentificacao.setColumns(10);
			contentPane.add(textIdentificacao);
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		/*textIdentificacao = new JTextField();
		textIdentificacao.setColumns(10);
		textIdentificacao.setBounds(761, 406, 303, 26);
		contentPane.add(textIdentificacao);*/
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(622, 518, 303, 26);
		textLogin.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		contentPane.add(textLogin);
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = textLogin.getText();
				String senha = textSenha.getText();
				
				if (!login.isEmpty() || !senha.isEmpty()) {
					FuncionarioDAO funcioDAO = FuncionarioDAO.getInstancia();
					int retorno = funcioDAO.removerFuncionario(login, senha);
					
					if (retorno == 0) {
						TelaPopUpErroFuncionario frame = new TelaPopUpErroFuncionario();
						frame.setUndecorated(true);
						frame.setLocationRelativeTo(null);
			        	frame.setVisible(true);//JOptionPane.showMessageDialog(null, "Erro ao EXCLUIR!"); 
						
					} else {TelaPopUpSucessoFuncionario frame = new TelaPopUpSucessoFuncionario();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
		        	frame.setVisible(true);//JOptionPane.showMessageDialog(null, "EXCLUIDO com sucesso!");
		        	
					
						
					}
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(252, 251, 244));
		btnNewButton.setBackground(new Color(172, 23, 44));
		btnNewButton.setBounds(925, 706, 157, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FuncionalidadeFuncionario frame = new FuncionalidadeFuncionario(fun);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
				//setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setForeground(new Color(252, 251, 244));
		btnNewButton_2.setBackground(new Color(1, 50, 1));
		btnNewButton_2.setBounds(1312, 706, 115, 44);
		contentPane.add(btnNewButton_2);
	}
}
