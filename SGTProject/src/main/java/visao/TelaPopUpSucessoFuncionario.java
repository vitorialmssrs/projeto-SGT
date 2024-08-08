package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaPopUpSucessoFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPopUpSucessoFuncionario frame = new TelaPopUpSucessoFuncionario();
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
	public TelaPopUpSucessoFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPopUpSucessoFuncionario.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSair = new JButton("<- | Sair");
		btnSair.setBounds(174, 242, 127, 25);
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSair);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(161, 0, 136, 139);
		lblLogo.setIcon(new ImageIcon(TelaPopUpSucessoFuncionario.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblLogo);
		
		JLabel lblNewLabel_1 = new JLabel("Caro funcionário sua ação ");
		lblNewLabel_1.setBounds(51, 137, 400, 37);
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("foi realizada com sucesso!");
		lblNewLabel_2.setBounds(51, 185, 395, 37);
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_2);
	}

}