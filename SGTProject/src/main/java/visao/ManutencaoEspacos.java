package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ManutencaoEspacos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManutencaoEspacos frame = new ManutencaoEspacos();
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
	public ManutencaoEspacos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecione qual manutenção você deseja fazer no espaço:");
		lblTitulo.setBounds(362, 65, 1229, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		
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
		
		JComboBox comboBoxAcademia = new JComboBox();
		comboBoxAcademia.setForeground(new Color(1, 50, 1));
		comboBoxAcademia.setBounds(306, 289, 115, 38);
		contentPane.add(comboBoxAcademia);
		
		comboBoxAcademia.addItem(" ");
		comboBoxAcademia.addItem("Limpeza do local.");
		comboBoxAcademia.addItem("Conserto do local.");
		comboBoxAcademia.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxBrinquedoteca = new JComboBox();
		comboBoxBrinquedoteca.setForeground(new Color(1, 50, 1));
		comboBoxBrinquedoteca.setBounds(306, 435, 115, 38);
		contentPane.add(comboBoxBrinquedoteca);
		
		comboBoxBrinquedoteca.addItem(" ");
		comboBoxBrinquedoteca.addItem("Limpeza do local.");
		comboBoxBrinquedoteca.addItem("Conserto do local.");
		comboBoxBrinquedoteca.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxPiscina = new JComboBox();
		comboBoxPiscina.setBounds(306, 579, 115, 38);
		contentPane.add(comboBoxPiscina);
		
		comboBoxPiscina.addItem(" ");
		comboBoxPiscina.addItem("Limpeza do local.");
		comboBoxPiscina.addItem("Conserto do local.");
		comboBoxPiscina.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxQuiosque = new JComboBox();
		comboBoxQuiosque.setBounds(884, 287, 115, 38);
		contentPane.add(comboBoxQuiosque);
		
		comboBoxQuiosque.addItem(" ");
		comboBoxQuiosque.addItem("Limpeza do local.");
		comboBoxQuiosque.addItem("Conserto do local.");
		comboBoxQuiosque.addItem("Atualizar informações do local.");
	
		
		JComboBox comboBoxFutebol = new JComboBox();
		comboBoxFutebol.setBounds(884, 443, 115, 38);
		contentPane.add(comboBoxFutebol);
		
		comboBoxFutebol.addItem(" ");
		comboBoxFutebol.addItem("Limpeza do local.");
		comboBoxFutebol.addItem("Conserto do local.");
		comboBoxFutebol.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxVolei = new JComboBox();
		comboBoxVolei.setBounds(857, 571, 115, 38);
		contentPane.add(comboBoxVolei);
		
		comboBoxVolei.addItem(" ");
		comboBoxVolei.addItem("Limpeza do local.");
		comboBoxVolei.addItem("Conserto do local.");
		comboBoxVolei.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxSF = new JComboBox();
		comboBoxSF.setBounds(1421, 289, 115, 38);
		contentPane.add(comboBoxSF);
		
		comboBoxSF.addItem(" ");
		comboBoxSF.addItem("Limpeza do local.");
		comboBoxSF.addItem("Conserto do local.");
		comboBoxSF.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxSJ = new JComboBox();
		comboBoxSJ.setBounds(1421, 437, 115, 38);
		contentPane.add(comboBoxSJ);
		
		comboBoxSJ.addItem(" ");
		comboBoxSJ.addItem("Limpeza do local.");
		comboBoxSJ.addItem("Conserto do local.");
		comboBoxSJ.addItem("Atualizar informações do local.");
		
		JComboBox comboBoxSPA = new JComboBox();
		comboBoxSPA.setBounds(1421, 579, 115, 38);
		contentPane.add(comboBoxSPA);
		
		comboBoxSPA.addItem(" ");
		comboBoxSPA.addItem("Limpeza do local.");
		comboBoxSPA.addItem("Conserto do local.");
		comboBoxSPA.addItem("Atualizar informações do local.");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ManutencaoEspacos.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblLogo.setBounds(158, 11, 194, 172);
		contentPane.add(lblLogo);
	}
}
