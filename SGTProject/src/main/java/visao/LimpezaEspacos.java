package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LimpezaEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LimpezaEspacos frame = new LimpezaEspacos();
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
	public LimpezaEspacos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Qual espaço você deseja solicitar limpeza?");
		lblTitulo.setBounds(375, 39, 865, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecione a opção que você deseja");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(552, 90, 486, 49);
		contentPane.add(lblNewLabel);
		
		
		JButton btnAcademia = new JButton("Academia");
		btnAcademia.setBorder(new LineBorder(new Color(1, 50, 1)));
		btnAcademia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Academia academia = new Academia ();
				//academia.setViseble(true);
			}
		});
		btnAcademia.setBackground(new Color(247, 246, 243));
		btnAcademia.setForeground(new Color(1, 50, 1));
		btnAcademia.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAcademia.setBounds(94, 281, 181, 50);
		contentPane.add(btnAcademia);
		
		JButton btnBrinquedoteca = new JButton("Brinquedoteca");
		btnBrinquedoteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBrinquedoteca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBrinquedoteca.setBackground(new Color(247, 246, 243));
		btnBrinquedoteca.setForeground(new Color(1, 50, 1));
		btnBrinquedoteca.setBounds(94, 429, 181, 50);
		contentPane.add(btnBrinquedoteca);
		
		JButton btnPiscina = new JButton("Piscina");
		btnPiscina.setBackground(new Color(247, 246, 243));
		btnPiscina.setForeground(new Color(1, 50, 1));
		btnPiscina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPiscina.setBounds(94, 571, 181, 50);
		contentPane.add(btnPiscina);
		
		JButton btnQuiosque = new JButton("Quiosque");
		btnQuiosque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuiosque.setForeground(new Color(1, 50, 1));
		btnQuiosque.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuiosque.setBackground(new Color(247, 246, 243));
		btnQuiosque.setBounds(661, 281, 181, 50);
		contentPane.add(btnQuiosque);
		
		JButton btnQuadraFut = new JButton("Quadra de Futebol");
		btnQuadraFut.setForeground(new Color(1, 50, 1));
		btnQuadraFut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuadraFut.setBackground(new Color(247, 246, 243));
		btnQuadraFut.setBounds(661, 429, 181, 50);
		contentPane.add(btnQuadraFut);
		
		JButton btnQuadraVolei = new JButton("Quadra de vôlei");
		btnQuadraVolei.setForeground(new Color(1, 50, 1));
		btnQuadraVolei.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuadraVolei.setBackground(new Color(247, 246, 243));
		btnQuadraVolei.setBounds(661, 571, 181, 50);
		contentPane.add(btnQuadraVolei);
		
		JButton btnSalaoFesta = new JButton("Salão de Festas");
		btnSalaoFesta.setForeground(new Color(1, 50, 1));
		btnSalaoFesta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalaoFesta.setBackground(new Color(247, 246, 243));
		btnSalaoFesta.setBounds(1205, 281, 181, 50);
		contentPane.add(btnSalaoFesta);
		
		JButton btnSalaJogos = new JButton("Sala de Jogos");
		btnSalaJogos.setForeground(new Color(1, 50, 1));
		btnSalaJogos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalaJogos.setBackground(new Color(247, 246, 243));
		btnSalaJogos.setBounds(1205, 429, 181, 50);
		contentPane.add(btnSalaJogos);
		
		JButton btnSPA = new JButton("SPA");
		btnSPA.setForeground(new Color(1, 50, 1));
		btnSPA.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSPA.setBackground(new Color(247, 246, 243));
		btnSPA.setBounds(1205, 571, 181, 50);
		contentPane.add(btnSPA);
		
		JButton btnSair = new JButton("<- |  Sair ");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBackground(new Color(227, 236, 229));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setForeground(new Color(1, 50, 1));
		btnSair.setBounds(1389, 704, 126, 27);
		contentPane.add(btnSair);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LimpezaEspacos.class.getResource("/imagens/LogoPI.png")));
		lblLogo.setBounds(117, 39, 150, 113);
		contentPane.add(lblLogo);
	}
}
