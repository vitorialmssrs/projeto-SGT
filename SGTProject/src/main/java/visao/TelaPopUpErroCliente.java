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

import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

public class TelaPopUpErroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPopUpErroCliente frame = new TelaPopUpErroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public TelaPopUpErroCliente() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPopUpErroCliente.class.getResource("/imagens/LogoPI.png")));
	setBackground(new Color(255, 255, 245));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 330);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 245));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[136px][][][][][][][]", "[139px][][][][][][][][]"));
	
	JLabel lblLogo = new JLabel("");
	lblLogo.setIcon(new ImageIcon(TelaPopUpConfimacaoCheckin.class.getResource("/imagens/LogoPI.png")));
	contentPane.add(lblLogo, "cell 1 0 2 1,alignx center,aligny top");
	
	JLabel lblNewLabel_1 = new JLabel("Caro cliente houve um erro");
	lblNewLabel_1.setForeground(new Color(1, 50, 1));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	contentPane.add(lblNewLabel_1, "cell 1 2 2 1,alignx center");
	
	JLabel lblNewLabel_2 = new JLabel("ao finalizar sua ação");
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
