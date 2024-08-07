package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaPopUpCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPopUpCadastroFuncionario frame = new TelaPopUpCadastroFuncionario();
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
	public TelaPopUpCadastroFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPopUpCadastroFuncionario.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[136px][][][][][][][]", "[139px][][][][][][][]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaPopUpCadastroFuncionario.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblLogo, "cell 1 0 2 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Caro Funcionario seu Cadastro");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1, "cell 1 2 2 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("foi realizado com sucesso!");
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_2, "cell 1 3 2 1,alignx center");
		
		JButton btnSair = new JButton("<- | Sair");
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnSair, "cell 2 7,alignx center");
	}

}
