package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 236, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[620][641px][]", "[200][191px][49px][72px][80px][50][85px]"));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		contentPane.add(lblLogo, "cell 1 1,alignx center,growy");

		JLabel lblBemVindos = new JLabel("Bem-vindo ao Chateau Imperial");
		lblBemVindos.setForeground(new Color(1, 50, 1));
		lblBemVindos.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblBemVindos, "cell 1 2,growx,aligny bottom");

		JLabel lblNewLabel = new JLabel("Escolha uma das opções:");
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel, "cell 1 3,alignx center,growy");

		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				FuncionalidadeCliente funcionalidadeCliente = new FuncionalidadeCliente();
				funcionalidadeCliente.setExtendedState(funcionalidadeCliente.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				funcionalidadeCliente.setVisible(true);
				funcionalidadeCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(1, 50, 1));
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnCliente, "cell 1 4,grow");

		JButton btnNewButton = new JButton("Funcionário");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				LoginFuncionario loginfuncionario = new LoginFuncionario();
				loginfuncionario.setExtendedState(loginfuncionario.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				loginfuncionario.setVisible(true);
				loginfuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBackground(new Color(1, 50, 1));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnNewButton, "cell 1 6,grow");
	}
}
