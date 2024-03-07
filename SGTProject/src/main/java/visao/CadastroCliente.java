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
import javax.swing.ImageIcon;


public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataEntrada;
	private JTextField textEmail_Cliente;
	private JTextField textTelefone_Cliente;
	private JTextField textCep_Cliente;
	private JTextField textHoraEntrada;
	private JTextField textHoraSaida;
	private JTextField textDataSaida;
	private JTextField textCPF_Cliente;
	private JTextField txtSenha;
	private JTextField txtHoraSaida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCaroFuncionario = new JLabel("Caro cliente,");
		lblCaroFuncionario.setBounds(592, 71, 466, 61);
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setBackground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblCaroFuncionario);
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações para cadastro: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(592, 146, 474, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNome_Cliente.setBounds(194, 301, 202, 21);
		contentPane.add(lblNome_Cliente);
		
		textDataEntrada = new JTextField();
		textDataEntrada.setText(" dd/mm/aaaa");
		textDataEntrada.setForeground(new Color(1, 50, 1));
		textDataEntrada.setBackground(new Color(252, 251, 244));
		textDataEntrada.setBounds(811, 369, 165, 29);
		textDataEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textDataEntrada);
		textDataEntrada.setColumns(10);
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSobrenomeCliente.setBounds(194, 363, 165, 22);
		contentPane.add(lblSobrenomeCliente);
		
		textEmail_Cliente = new JTextField();
		textEmail_Cliente.setForeground(new Color(1, 50, 1));
		textEmail_Cliente.setText(" dd/mm/aaaa");
		textEmail_Cliente.setBackground(new Color(252, 251, 244));
		textEmail_Cliente.setBounds(194, 522, 404, 29);
		contentPane.add(textEmail_Cliente);
		textEmail_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail_Cliente.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("* Data de nascimento:");
		lblDataNascimento.setBackground(new Color(1, 50, 1));
		lblDataNascimento.setForeground(new Color(1, 50, 1));
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataNascimento.setBounds(194, 489, 236, 21);
		contentPane.add(lblDataNascimento);
		
		textTelefone_Cliente = new JTextField();
		textTelefone_Cliente.setForeground(new Color(1, 50, 1));
		textTelefone_Cliente.setText(" 11111111111");
		textTelefone_Cliente.setBackground(new Color(252, 251, 244));
		textTelefone_Cliente.setBounds(194, 455, 404, 29);
		contentPane.add(textTelefone_Cliente);
		textTelefone_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone_Cliente.setColumns(10);
		
		JLabel lblDataEntrada = new JLabel("* Data e hora de entrada: ");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setBackground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataEntrada.setBounds(811, 341, 255, 21);
		contentPane.add(lblDataEntrada);
		
		textCep_Cliente = new JTextField();
		textCep_Cliente.setForeground(new Color(252, 251, 244));
		textCep_Cliente.setBackground(new Color(252, 251, 244));
		textCep_Cliente.setBounds(194, 329, 404, 29);
		contentPane.add(textCep_Cliente);
		textCep_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCep_Cliente.setColumns(10);
		
		JLabel lblDataSaida = new JLabel("* Data e hora de saída:");
		lblDataSaida.setBackground(new Color(1, 50, 1));
		lblDataSaida.setForeground(new Color(1, 50, 1));
		lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataSaida.setBounds(811, 403, 232, 21);
		contentPane.add(lblDataSaida);
		
		textHoraEntrada = new JTextField();
		textHoraEntrada.setText(" hh:mm");
		textHoraEntrada.setForeground(new Color(1, 50, 1));
		textHoraEntrada.setBackground(new Color(252, 251, 244));
		textHoraEntrada.setBounds(986, 369, 165, 29);
		textHoraEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textHoraEntrada);
		
		textHoraEntrada.setColumns(10);
		
				
		JLabel lblSenhaCad = new JLabel("* Crie uma senha para o cadastro: ");
		lblSenhaCad.setBackground(new Color(1, 50, 1));
		lblSenhaCad.setForeground(new Color(1, 50, 1));
		lblSenhaCad.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSenhaCad.setBounds(811, 465, 340, 21);
		contentPane.add(lblSenhaCad);
		
		textDataSaida = new JTextField();
		textDataSaida.setText(" dd/mm/aaaa");
		textDataSaida.setBackground(new Color(252, 251, 244));
		textDataSaida.setBounds(811, 429, 165, 29);
		contentPane.add(textDataSaida);
		textDataSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataSaida.setColumns(10);
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCPFCliente.setBounds(194, 425, 300, 18);
		contentPane.add(lblCPFCliente);
		
		textCPF_Cliente = new JTextField();
		textCPF_Cliente.setForeground(new Color(252, 251, 244));
		textCPF_Cliente.setBackground(new Color(252, 251, 244));
		textCPF_Cliente.setBounds(194, 389, 404, 29);
		textCPF_Cliente.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textCPF_Cliente);
		textCPF_Cliente.setColumns(10);
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(423, 638, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		JButton btnCadastro_Cliente = new JButton("Cadastrar");
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBounds(813, 638, 176, 39);
		contentPane.add(btnCadastro_Cliente);
		
		JButton btnSair_tela_cad_Cliente = new JButton("Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_tela_cad_Cliente.setBounds(1323, 708, 176, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
		
		JLabel lblInformacaoSenha = new JLabel("Apenas números, com no Mínimo 8 caracteres  e Sem caracteres especiais.");
		lblInformacaoSenha.setForeground(new Color(255, 0, 0));
		lblInformacaoSenha.setBounds(811, 488, 353, 13);
		contentPane.add(lblInformacaoSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(1, 50, 1));
		txtSenha.setText(" ***********");
		txtSenha.setBackground(new Color(252, 251, 244));
		txtSenha.setBounds(811, 508, 404, 29);
		contentPane.add(txtSenha);
		txtSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtSenha.setColumns(10);
		
		txtHoraSaida = new JTextField();
		txtHoraSaida.setText(" hh:mm");
		txtHoraSaida.setBounds(986, 429, 165, 29);
		contentPane.add(txtHoraSaida);
		txtHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtHoraSaida.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vivis\\OneDrive\\Área de Trabalho\\IMG PI\\LogoPI.png"));
		lblNewLabel.setBounds(437, 62, 145, 128);
		contentPane.add(lblNewLabel);
	}
}
