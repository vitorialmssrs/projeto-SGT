package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{84, 0, 374, 0, 0};
		gbl_contentPane.rowHeights = new int[]{139, 77, 49, 77, 85, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\vivis\\OneDrive\\Área de Trabalho\\IMG PI\\LogoPI.png"));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogo.gridx = 3;
		gbc_lblLogo.gridy = 1;
		contentPane.add(lblLogo, gbc_lblLogo);
		
		JLabel lblBemVindos = new JLabel("Bem-vindo ao Chateau Imperial");
		lblBemVindos.setForeground(new Color(1, 50, 1));
		lblBemVindos.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lblBemVindos = new GridBagConstraints();
		gbc_lblBemVindos.anchor = GridBagConstraints.SOUTH;
		gbc_lblBemVindos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBemVindos.insets = new Insets(0, 0, 5, 0);
		gbc_lblBemVindos.gridx = 3;
		gbc_lblBemVindos.gridy = 2;
		contentPane.add(lblBemVindos, gbc_lblBemVindos);
		
		JLabel lblNewLabel = new JLabel("Escolha uma das opções:");
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setBackground(new Color(1, 50, 1));
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnCliente = new GridBagConstraints();
		gbc_btnCliente.fill = GridBagConstraints.BOTH;
		gbc_btnCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnCliente.gridx = 3;
		gbc_btnCliente.gridy = 4;
		contentPane.add(btnCliente, gbc_btnCliente);
		
		JButton btnNewButton = new JButton("Funcionário ");
		btnNewButton.setBackground(new Color(1, 50, 1));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
}
