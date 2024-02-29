package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Hospede extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospede frame = new Hospede();
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
	public Hospede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][1894px]", "[][][1032px]"));
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "cell 1 0,aligny top");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Châteu_Imperial-removebg-preview 4.png"));
		contentPane.add(lblNewLabel, "cell 3 2,aligny top");
	}

}
