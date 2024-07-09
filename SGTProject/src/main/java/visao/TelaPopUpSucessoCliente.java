package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPopUpSucessoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPopUpSucessoCliente frame = new TelaPopUpSucessoCliente();
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
	public TelaPopUpSucessoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(180, 0, 136, 136);
		lblLogo.setIcon(new ImageIcon(TelaPopUpSucessoCliente.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblLogo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	
			}
		});
		btnSair.setIcon(new ImageIcon(TelaPopUpSucessoCliente.class.getResource("/imagens/Vector (1).png")));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setBounds(203, 241, 113, 31);
		contentPane.add(btnSair);
		
		JLabel lblTexto1 = new JLabel("Caro cliente sua ação");
		lblTexto1.setBackground(new Color(1, 50, 1));
		lblTexto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTexto1.setBounds(82, 161, 334, 31);
		contentPane.add(lblTexto1);
		
		JLabel lblTexto2 = new JLabel("ocorreu com sucesso!");
		lblTexto2.setForeground(new Color(1, 50, 1));
		lblTexto2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto2.setBounds(92, 202, 324, 28);
		contentPane.add(lblTexto2);
	}
}
