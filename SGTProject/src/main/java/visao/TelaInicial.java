package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setUndecorated(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 236, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(815, 99, 206, 191);
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		contentPane.add(lblLogo);

		JLabel lblBemVindos = new JLabel("Bem-vindo ao Chateau Imperial");
		lblBemVindos.setBounds(600, 334, 641, 49);
		lblBemVindos.setForeground(new Color(1, 50, 1));
		lblBemVindos.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblBemVindos);

		JLabel lblNewLabel = new JLabel("Escolha uma das opções:");
		lblNewLabel.setBounds(765, 405, 281, 72);
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(600, 491, 641, 80);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				dispose();
				FuncionalidadeCliente funcionalidadeCliente = new FuncionalidadeCliente();
				funcionalidadeCliente.setUndecorated(true);
				funcionalidadeCliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				funcionalidadeCliente.setVisible(true);
				funcionalidadeCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(1, 50, 1));
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnCliente);

		JButton btnNewButton = new JButton("Funcionário");
		btnNewButton.setBounds(600, 630, 641, 85);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
				LoginFuncionario loginfuncionario = new LoginFuncionario();
				loginfuncionario.setUndecorated(true);
				loginfuncionario.setExtendedState(JFrame.MAXIMIZED_BOTH);
				loginfuncionario.setVisible(true);
				loginfuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBackground(new Color(1, 50, 1));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnNewButton);
	}
}
