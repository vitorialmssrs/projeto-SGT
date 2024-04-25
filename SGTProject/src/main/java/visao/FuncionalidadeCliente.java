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
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadeCliente frame = new FuncionalidadeCliente();
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
		panelOpcoes.setLayout(new MigLayout("", "[150][300][150]", "[200][][100][50][200][50][200][50][200][50][100]"));

		JLabel lblNewLabel_1 = new JLabel("Caro Cliente");
		lblNewLabel_1.setForeground(new Color(1, 50, 1));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		panelOpcoes.add(lblNewLabel_1, "cell 1 0,alignx center");

		JLabel lblNewLabel_2 = new JLabel("Escolhe uma Opção de Atendimento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(1, 50, 1));
		panelOpcoes.add(lblNewLabel_2, "cell 1 2,alignx center");

		JButton btnNewButton = new JButton("Check-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCheckIn cadastrocliente = new TelaCheckIn();
				cadastrocliente.setExtendedState(cadastrocliente.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				cadastrocliente.setVisible(true);
				cadastrocliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(81, 108, 81));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnNewButton, "cell 1 4,grow");

		JButton btnNewButton_1 = new JButton("Check-out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CheckoutCliente checkoutcliente = new CheckoutCliente();
					checkoutcliente.setExtendedState(checkoutcliente.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					checkoutcliente.setVisible(true);
					checkoutcliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(66, 142, 66));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnNewButton_1, "cell 1 6,grow");

		JButton btnNewButton_2 = new JButton("Reservas Espaços");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(109, 164, 109));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelOpcoes.add(btnNewButton_2, "cell 1 8,grow");

		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(227, 236, 226));
		btnNewButton_3.setIcon(new ImageIcon(FuncionalidadeCliente.class.getResource("/imagens/Vector sair.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(1, 50, 1));
		panelOpcoes.add(btnNewButton_3, "cell 2 10,growx");
	}
}
