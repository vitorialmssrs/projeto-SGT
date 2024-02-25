package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class EspacosLR extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspacosLR frame = new EspacosLR();
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
	public EspacosLR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 236, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagemHotel = new JLabel("");
		lblImagemHotel.setBounds(5, 0, 947, 759);
		lblImagemHotel.setIcon(new ImageIcon("C:\\Users\\otavi\\Downloads\\Hotel 2.png"));
		contentPane.add(lblImagemHotel);
		
		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckin.setForeground(new Color(255, 255, 255));
		btnCheckin.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnCheckin.setBackground(new Color(81, 108, 81));
		btnCheckin.setBounds(944, 103, 923, 147);
		contentPane.add(btnCheckin);
		
		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.setForeground(new Color(255, 255, 255));
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnCheckout.setBackground(new Color(66, 142, 66));
		btnCheckout.setBounds(944, 288, 923, 147);
		contentPane.add(btnCheckout);
		
		JButton btnReservarEspaco = new JButton("Reservar Espaço");
		btnReservarEspaco.setForeground(new Color(255, 255, 255));
		btnReservarEspaco.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnReservarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservarEspaco.setBackground(new Color(109, 164, 109));
		btnReservarEspaco.setBounds(944, 471, 923, 147);
		contentPane.add(btnReservarEspaco);
		
		JLabel lblInstrucaoCliente = new JLabel("Caro cliente, escolha uma opção \r\nde atendimento");
		lblInstrucaoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucaoCliente.setForeground(new Color(1, 50, 1));
		lblInstrucaoCliente.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInstrucaoCliente.setBounds(1069, 11, 680, 65);
		contentPane.add(lblInstrucaoCliente);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(227, 236, 226));
		btnSair.setForeground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.setIcon(new ImageIcon("C:\\Users\\otavi\\Downloads\\Vector.png"));
		btnSair.setBounds(1716, 685, 151, 39);
		contentPane.add(btnSair);
	}
}
