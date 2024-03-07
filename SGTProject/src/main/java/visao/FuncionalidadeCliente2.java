package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FuncionalidadeCliente2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadeCliente2 frame = new FuncionalidadeCliente2();
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
	public FuncionalidadeCliente2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelFt = new JPanel();
		contentPane.add(panelFt);
		panelFt.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 5, 911, 1080);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Hotel 2.png"));
		panelFt.add(lblNewLabel);
		
		JPanel panelOpcoes = new JPanel();
		contentPane.add(panelOpcoes);
	}
}
