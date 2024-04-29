package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class LimpAcademia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LimpAcademia frame = new LimpAcademia();
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
	public LimpAcademia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelImagem = new JPanel();
		contentPane.add(panelImagem);
		
		JPanel panelFundo = new JPanel();
		contentPane.add(panelFundo);
		panelFundo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Selecione o que precisa ser consertado na academia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 46));
		panelFundo.add(lblNewLabel, BorderLayout.NORTH);
	}

}
