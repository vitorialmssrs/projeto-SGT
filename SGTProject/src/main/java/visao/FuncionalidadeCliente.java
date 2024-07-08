package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionalidadeCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 //Removendo o metodo main para poder só rodar pela tela inicial
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadeCliente frame = new FuncionalidadeCliente();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelFt = new JPanel();
		panelFt.setBackground(new Color(227, 236, 226));
		contentPane.add(panelFt);
		panelFt.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 911, 1080);
		lblNewLabel.setIcon(new ImageIcon(FuncionalidadeCliente.class.getResource("/imagens/Hotel 2.png")));
		panelFt.add(lblNewLabel);

		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setBackground(new Color(227, 236, 226));
		contentPane.add(panelOpcoes);
		panelOpcoes.setLayout(new MigLayout("", "[150][300][150]", "[150][100][150][150][150][150][100]"));

		JLabel lblTexto1 = new JLabel("Caro Cliente");
		lblTexto1.setForeground(new Color(1, 50, 1));
		lblTexto1.setFont(new Font("Tahoma", Font.BOLD, 40));
		panelOpcoes.add(lblTexto1, "cell 1 0,alignx center");

		JLabel lblTexto2 = new JLabel("Escolhe uma Opção de Atendimento");
		lblTexto2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTexto2.setForeground(new Color(1, 50, 1));
		panelOpcoes.add(lblTexto2, "cell 1 1,alignx center");

		JButton btnCheckin = new JButton("Check-in");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCheckIn cadastrocliente = new TelaCheckIn();
				cadastrocliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				cadastrocliente.setVisible(true);
				cadastrocliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCheckin.setForeground(new Color(255, 255, 255));
		btnCheckin.setBackground(new Color(81, 108, 81));
		btnCheckin.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnCheckin, "cell 1 2,grow");

		JButton btnCheckout = new JButton("Check-out");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaCheckOut checkoutcliente = new TelaCheckOut();
					checkoutcliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
					checkoutcliente.setVisible(true);
					checkoutcliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);				
			}
		});
		btnCheckout.setForeground(new Color(255, 255, 255));
		btnCheckout.setBackground(new Color(66, 142, 66));
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnCheckout, "cell 1 3,grow");

		JButton btnReservasEspacos = new JButton("Reservas Espaços");
		btnReservasEspacos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EspacosHotel espacoshotel = new EspacosHotel();
				espacoshotel.setExtendedState(JFrame.MAXIMIZED_BOTH);
				espacoshotel.setVisible(true);
				espacoshotel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			}
		});
		btnReservasEspacos.setForeground(new Color(255, 255, 255));
		btnReservasEspacos.setBackground(new Color(109, 164, 109));
		btnReservasEspacos.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnReservasEspacos, "cell 1 4,grow");

		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaInicial.setVisible(true);
			}
		});
		
		JButton btnAlterarCadastro = new JButton("Alterar Cadastro");
		btnAlterarCadastro.setBackground(new Color(126, 191, 131));
		btnAlterarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlterarCadastroCliente AlterarCadastroCliente = new TelaAlterarCadastroCliente();
				AlterarCadastroCliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				AlterarCadastroCliente.setVisible(true);
			}
		});
		btnAlterarCadastro.setForeground(new Color(255, 255, 255));
		btnAlterarCadastro.setFont(new Font("Tahoma", Font.BOLD, 50));
		panelOpcoes.add(btnAlterarCadastro, "cell 1 5,grow");
		btnNewButton_3.setBackground(new Color(227, 236, 226));
		btnNewButton_3.setIcon(new ImageIcon(FuncionalidadeCliente.class.getResource("/imagens/Vector sair.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(1, 50, 1));
		panelOpcoes.add(btnNewButton_3, "cell 2 6,growx");
	}
}
