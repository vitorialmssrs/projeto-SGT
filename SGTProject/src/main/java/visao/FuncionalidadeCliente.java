package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FuncionalidadeCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadeCliente frame = new FuncionalidadeCliente();
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
	public FuncionalidadeCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 236, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagemHotel = new JLabel("");
		lblImagemHotel.setBounds(0, 0, 952, 1042);
		lblImagemHotel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Hotel 2.png"));
		contentPane.add(lblImagemHotel);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckin.setForeground(new Color(255, 255, 255));
		btnCheckin.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnCheckin.setBackground(new Color(81, 108, 81));
		btnCheckin.setBounds(327, 293, 923, 147);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.setForeground(new Color(255, 255, 255));
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnCheckout.setBackground(new Color(66, 142, 66));
		btnCheckout.setBounds(327, 521, 923, 147);
		contentPane.add(btnCheckout);
		
		JButton btnReservarEspaco = new JButton("Reservar Espaço");
		btnReservarEspaco.setForeground(new Color(255, 255, 255));
		btnReservarEspaco.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnReservarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservarEspaco.setBackground(new Color(109, 164, 109));
		btnReservarEspaco.setBounds(327, 749, 923, 147);
		contentPane.add(btnReservarEspaco);
		
		JLabel lblInstrucaoCliente = new JLabel("Caro Cliente");
		lblInstrucaoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucaoCliente.setForeground(new Color(1, 50, 1));
		lblInstrucaoCliente.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblInstrucaoCliente.setBounds(637, 44, 326, 65);
		contentPane.add(lblInstrucaoCliente);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(227, 236, 226));
		btnSair.setForeground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Vector sair.png"));
		btnSair.setBounds(1716, 968, 151, 39);
		btnSair.setBorder(new LineBorder(new Color(36, 169, 36)));
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Escolha uma opção de atendimento");
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(556, 134, 582, 80);
		contentPane.add(lblNewLabel);
	}
}
