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

public class TelaEspacosHotelCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEspacosHotelCliente frame = new TelaEspacosHotelCliente();
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
	public TelaEspacosHotelCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Qual espaço você deseja reservar?");
		lblTitulo.setBounds(636, 86, 750, 49);
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecione a opção que você deseja");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setBounds(739, 137, 486, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaEspacosHotelCliente.class.getResource("/imagens/Châteu_Imperial-removebg-preview 4.png")));
		lblNewLabel_1.setBounds(420, 58, 194, 172);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAcademia = new JButton("Academia");
		btnAcademia.setBorder(new LineBorder(new Color(1, 50, 1)));
		btnAcademia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnAcademia.setBackground(new Color(66, 142, 66));
		btnAcademia.setForeground(new Color(252, 251, 244));
		btnAcademia.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAcademia.setBounds(420, 371, 181, 50);
		contentPane.add(btnAcademia);
		
		JButton btnBrinquedoteca = new JButton("Brinquedoteca");
		btnBrinquedoteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnBrinquedoteca.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBrinquedoteca.setBackground(new Color(66, 142, 66));
		btnBrinquedoteca.setForeground(new Color(252, 251, 244));
		btnBrinquedoteca.setBounds(420, 519, 181, 50);
		contentPane.add(btnBrinquedoteca);
		
		JButton btnPiscina = new JButton("Piscina");
		btnPiscina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnPiscina.setBackground(new Color(66, 142, 66));
		btnPiscina.setForeground(new Color(252, 251, 244));
		btnPiscina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPiscina.setBounds(420, 661, 181, 50);
		contentPane.add(btnPiscina);
		
		JButton btnQuiosque = new JButton("Quiosque");
		btnQuiosque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnQuiosque.setForeground(new Color(252, 251, 244));
		btnQuiosque.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuiosque.setBackground(new Color(66, 142, 66));
		btnQuiosque.setBounds(875, 371, 181, 50);
		contentPane.add(btnQuiosque);
		
		JButton btnQuadraFut = new JButton("Quadra de Futebol");
		btnQuadraFut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnQuadraFut.setForeground(new Color(252, 251, 244));
		btnQuadraFut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuadraFut.setBackground(new Color(66, 142, 66));
		btnQuadraFut.setBounds(875, 519, 181, 50);
		contentPane.add(btnQuadraFut);
		
		JButton btnQuadraVolei = new JButton("Quadra de vôlei");
		btnQuadraVolei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnQuadraVolei.setForeground(new Color(252, 251, 244));
		btnQuadraVolei.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnQuadraVolei.setBackground(new Color(66, 142, 66));
		btnQuadraVolei.setBounds(875, 661, 181, 50);
		contentPane.add(btnQuadraVolei);
		
		JButton btnSalaoFesta = new JButton("Salão de Festas");
		btnSalaoFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnSalaoFesta.setForeground(new Color(252, 251, 244));
		btnSalaoFesta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalaoFesta.setBackground(new Color(66, 142, 66));
		btnSalaoFesta.setBounds(1378, 371, 181, 50);
		contentPane.add(btnSalaoFesta);
		
		JButton btnSalaJogos = new JButton("Sala de Jogos");
		btnSalaJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnSalaJogos.setForeground(new Color(252, 251, 244));
		btnSalaJogos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalaJogos.setBackground(new Color(66, 142, 66));
		btnSalaJogos.setBounds(1378, 519, 181, 50);
		contentPane.add(btnSalaJogos);
		
		JButton btnSPA = new JButton("SPA");
		btnSPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaReservaEspacoCliente frame = new TelaReservaEspacoCliente();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnSPA.setForeground(new Color(252, 251, 244));
		btnSPA.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSPA.setBackground(new Color(66, 142, 66));
		btnSPA.setBounds(1378, 661, 181, 50);
		contentPane.add(btnSPA);
		
		JButton btnSair = new JButton("<- |  Sair ");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* para editar precisa ter todos os parametros e dos novos valores 
				 * 
				 * pegar o que precisa excluir 
				 * String cep txtCep.getText();
				 * 
				 * instanciar 
				 * EspacosDAO endDAO = EspacosDAO.getInstancia();
				 *  
				 * pegar o retorno 
				 * int retorno = endDAO.removerEspaco(academia);
				 * 
				 * exibir mensagem de erro ou sucesso com if 
				 * if
				 * 
				 * 
				 * 
				 * 
				 */
				dispose();
				FuncionalidadeCliente frame = new FuncionalidadeCliente();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSair.setForeground(new Color(252, 251, 244));
		btnSair.setBounds(1587, 899, 126, 49);
		contentPane.add(btnSair);
	}
}
