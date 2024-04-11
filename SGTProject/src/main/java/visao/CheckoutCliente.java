 package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.HospedeDAO;
import modelo.Hospede;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;


public class CheckoutCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textSobrenome;
	private JTextField textDataSaida;
	private JTextField txtHoraSaida;
	private JTextField textHoraEntrada;
	private JTextField textDataEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutCliente frame = new CheckoutCliente();
					//sempre antes do set visible para abrir em tela cheia 
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
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
	public CheckoutCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CheckoutCliente.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações abaixo para realizar o check-out: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		TextDataNascimento = new JTextField();
		TextDataNascimento.setForeground(new Color(1, 50, 1));
		TextDataNascimento.setBackground(new Color(252, 251, 244));
		TextDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		TextDataNascimento.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("");
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCPF.setColumns(10);
		
		JLabel lblDataEntrada = new JLabel("* Data e hora de entrada: ");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setBackground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		
		JLabel lblDataSaida = new JLabel("* Data e hora de saída:");
		lblDataSaida.setBackground(new Color(1, 50, 1));
		lblDataSaida.setForeground(new Color(1, 50, 1));
		lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		textSobrenome = new JTextField();
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSobrenome.setColumns(10);
		
		JButton btnSair_tela_cad_Cliente = new JButton("<- | Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				/*CadastroCliente cadastrocliente = new CadastroCliente();
				cadastrocliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.setLayout(new MigLayout("", "[300px][10px][27px][27px][50][45][212px][225][165][50][176px]", "[60][61px][11px][56px][21px][33px][35][15px][21px][35][12px][35][21px][35][39px][50][][39px]"));
		
		JLabel lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon(CheckoutCliente.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblIcone, "cell 4 1,alignx center");
		
		JLabel lblAgradecemosPorSua = new JLabel("Agradecemos por sua estadia!");
		lblAgradecemosPorSua.setForeground(new Color(1, 50, 1));
		lblAgradecemosPorSua.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblAgradecemosPorSua.setBackground(new Color(1, 50, 1));
		contentPane.add(lblAgradecemosPorSua, "cell 5 1 5 1");
		contentPane.add(lbl_Insira_Informacoes_Cadastro, "cell 5 3 4 1,growx,aligny top");
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblNome_Cliente, "cell 3 4 3 1,grow");
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblSobrenomeCliente, "cell 3 6 2 1,growx,aligny center");
		
		textDataEntrada = new JTextField();
		textDataEntrada.setForeground(new Color(1, 50, 1));
		textDataEntrada.setColumns(10);
		textDataEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataEntrada.setBackground(new Color(252, 251, 244));
		contentPane.add(textDataEntrada, "cell 7 6,grow");
		
		textHoraEntrada = new JTextField();
		textHoraEntrada.setForeground(new Color(1, 50, 1));
		textHoraEntrada.setColumns(10);
		textHoraEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		textHoraEntrada.setBackground(new Color(252, 251, 244));
		contentPane.add(textHoraEntrada, "cell 8 6,alignx left,growy");
		
		textDataSaida = new JTextField();
		textDataSaida.setForeground(new Color(1, 50, 1));
		textDataSaida.setColumns(10);
		textDataSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataSaida.setBackground(new Color(252, 251, 244));
		contentPane.add(textDataSaida, "cell 7 9,grow");
		
		txtHoraSaida = new JTextField();
		txtHoraSaida.setForeground(new Color(1, 50, 1));
		txtHoraSaida.setColumns(10);
		txtHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtHoraSaida.setBackground(new Color(252, 251, 244));
		contentPane.add(txtHoraSaida, "cell 8 9,alignx left,growy");
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblCPFCliente, "cell 3 10 2 1,grow");
		
		JLabel lblDataNascimento = new JLabel("* Data de nascimento:");
		lblDataNascimento.setBackground(new Color(1, 50, 1));
		lblDataNascimento.setForeground(new Color(1, 50, 1));
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataNascimento, "cell 3 12 2 1,alignx left,growy");
		contentPane.add(TextDataNascimento, "cell 3 13 3 1,grow");
		contentPane.add(textCPF, "cell 3 11 3 1,grow");
		contentPane.add(lblDataEntrada, "cell 7 5 2 1,alignx left,aligny bottom");
		contentPane.add(textPrimeiroNome, "cell 3 5 3 1,grow");
		contentPane.add(lblDataSaida, "cell 7 8 2 1,alignx left,growy");
		contentPane.add(textSobrenome, "cell 3 7 3 2,grow");
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		contentPane.add(btnLimpar_info_cliente, "cell 4 15,grow");
		
		JButton btnCadastro_Cliente = new JButton("Check-out");
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		contentPane.add(btnCadastro_Cliente, "cell 7 15,grow");
		contentPane.add(btnSair_tela_cad_Cliente, "cell 10 17,grow");
	}

	/**criado para ser adicionado em hospede
	 * 
	 * @param end
	 */
	public static void add(Hospede end) {
		// TODO Auto-generated method stub
		
	}
}
