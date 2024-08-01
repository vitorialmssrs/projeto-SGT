package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.FuncionarioDAO;
import modelo.Funcionario;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFuncionario frame = new LoginFuncionario();
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
	public LoginFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelVerde = new JPanel();
		panelVerde.setBackground(new Color(227, 236, 229));
		contentPane.add(panelVerde);
		panelVerde.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setIcon(
				new ImageIcon(LoginFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblLogo.setBounds(276, 420, 218, 169);
		panelVerde.add(lblLogo);

		JLabel lblSejaBemVindo = new JLabel("Seja bem-vindo!");
		lblSejaBemVindo.setBounds(218, 219, 449, 82);
		lblSejaBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSejaBemVindo.setForeground(new Color(66, 142, 66));
		lblSejaBemVindo.setBackground(new Color(66, 142, 66));
		lblSejaBemVindo.setFont(new Font("Tahoma", Font.BOLD, 54));
		panelVerde.add(lblSejaBemVindo);

		JLabel lblRealizeSeuLogin = new JLabel("Realize o seu Login");
		lblRealizeSeuLogin.setBounds(316, 312, 244, 31);
		lblRealizeSeuLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizeSeuLogin.setForeground(new Color(66, 142, 66));
		lblRealizeSeuLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelVerde.add(lblRealizeSeuLogin);

		JPanel panelCinza = new JPanel();
		panelCinza.setForeground(new Color(227, 236, 229));
		panelCinza.setBackground(new Color(255, 255, 245));
		contentPane.add(panelCinza);
		panelCinza.setLayout(null);

		textCPF = new JTextField();
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBounds(70, 294, 633, 32);
		textCPF.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		panelCinza.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblCPF = new JLabel("Login:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCPF.setBounds(87, 267, 56, 20);
		panelCinza.add(lblCPF);

		JLabel lblAtencao = new JLabel("*");
		lblAtencao.setForeground(new Color(242, 48, 48));
		lblAtencao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtencao.setBounds(70, 270, 21, 13);
		panelCinza.add(lblAtencao);

		textSenha = new JTextField();
		textSenha.setForeground(new Color(1, 50, 1));
		textSenha.setBackground(new Color(252, 251, 244));
		textSenha.setBounds(70, 422, 633, 32);
		textSenha.setBorder(new LineBorder(new Color(30, 32, 37), 1));
		panelCinza.add(textSenha);
		textSenha.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(87, 376, 56, 13);
		panelCinza.add(lblSenha);

		JLabel lblAtecaoSenha = new JLabel("*");
		lblAtecaoSenha.setForeground(new Color(242, 48, 48));
		lblAtecaoSenha.setBackground(new Color(242, 48, 48));
		lblAtecaoSenha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtecaoSenha.setBounds(70, 375, 12, 13);
		panelCinza.add(lblAtecaoSenha);

		JLabel lblRecadoSenha = new JLabel("A senha deve conter no Mínimo 8 caracteres");
		lblRecadoSenha.setForeground(new Color(242, 48, 48));
		lblRecadoSenha.setBackground(new Color(242, 48, 48));
		lblRecadoSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecadoSenha.setBounds(70, 399, 432, 13);
		panelCinza.add(lblRecadoSenha);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCPF.setText(" ");
				textSenha.setText(" ");
			}
		});
		btnLimpar.setBackground(new Color(255, 255, 245));
		btnLimpar.setForeground(new Color(36, 169, 36));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(70, 525, 301, 32);
		btnLimpar.setBorder(new LineBorder(new Color(36, 169, 36)));
		panelCinza.add(btnLimpar);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String login = textCPF.getText();
				String senha = textSenha.getText();

				if (login.isEmpty() || senha.isEmpty()) {
					TelaErroLogin telaErroLogin = new TelaErroLogin();
					telaErroLogin.setLocationRelativeTo(null);
					telaErroLogin.setVisible(true);
				} else {
					FuncionarioDAO funcDAO = FuncionarioDAO.getInstancia();
					Funcionario fun = funcDAO.efetuaLogin(login, senha);
					if (fun == null) {
						TelaErroLogin telaErroLogin = new TelaErroLogin();
						telaErroLogin.setLocationRelativeTo(null);
						telaErroLogin.setVisible(true);
					} else {
						dispose();
						FuncionalidadeFuncionario funcionalidadefuncionario = new FuncionalidadeFuncionario(fun);
						funcionalidadefuncionario.setExtendedState(JFrame.MAXIMIZED_BOTH);
						funcionalidadefuncionario.setVisible(true);
						funcionalidadefuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}

			}
		});
		btnEntrar.setForeground(new Color(255, 255, 245));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEntrar.setBackground(new Color(1, 50, 1));
		btnEntrar.setBounds(402, 525, 301, 32);
		panelCinza.add(btnEntrar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaInicial.setVisible(true);
			}
		});
		btnSair.setIcon(new ImageIcon(
				"C:\\Users\\vitor\\OneDrive\\Área de Trabalho\\git\\Projeto\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Vector (1).png"));
		btnSair.setForeground(new Color(255, 255, 245));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSair.setBounds(457, 709, 246, 50);
		panelCinza.add(btnSair);

	}
}
