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
		
		JLabel lblNewLabel = new JLabel("Academia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(95, 292, 144, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Brinquedoteca");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(94, 440, 163, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Piscina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		lblNewLabel_2.setBounds(95, 588, 144, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quiosque");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(1, 50, 1));
		lblNewLabel_3.setBounds(652, 293, 126, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quadra de Futebol");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setBounds(654, 449, 181, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quadra de Vôlei");
		lblNewLabel_5.setForeground(new Color(1, 50, 1));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(654, 582, 172, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salão de Festas");
		lblNewLabel_6.setBounds(1214, 301, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sala de jogos");
		lblNewLabel_7.setBounds(1229, 447, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SPA");
		lblNewLabel_8.setBounds(1229, 600, 46, 14);
		contentPane.add(lblNewLabel_8);
	}
}
