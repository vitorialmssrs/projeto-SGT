package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.HospedeDAO;
import modelo.Hospede;

import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataEntrada;
	private JTextField TextDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textHoraEntrada;
	private JTextField textDataSaida;
	private JTextField textSobrenome;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCliente.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
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
		
		TextDataNascimento = new JTextField();
		TextDataNascimento.setForeground(new Color(1, 50, 1));
		TextDataNascimento.setBackground(new Color(252, 251, 244));
		TextDataNascimento.setBounds(194, 522, 404, 29);
		contentPane.add(TextDataNascimento);
		TextDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		TextDataNascimento.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("* Data de nascimento:");
		lblDataNascimento.setBackground(new Color(1, 50, 1));
		lblDataNascimento.setForeground(new Color(1, 50, 1));
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataNascimento.setBounds(194, 489, 236, 21);
		contentPane.add(lblDataNascimento);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("");
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setBounds(194, 455, 404, 29);
		contentPane.add(textCPF);
		textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCPF.setColumns(10);
		
		JLabel lblDataEntrada = new JLabel("* Data e hora de entrada: ");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setBackground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataEntrada.setBounds(811, 341, 255, 21);
		contentPane.add(lblDataEntrada);
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBounds(194, 329, 404, 29);
		contentPane.add(textPrimeiroNome);
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		
		JLabel lblDataSaida = new JLabel("* Data e hora de saída:");
		lblDataSaida.setBackground(new Color(1, 50, 1));
		lblDataSaida.setForeground(new Color(1, 50, 1));
		lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataSaida.setBounds(811, 403, 232, 21);
		contentPane.add(lblDataSaida);
		
		textHoraEntrada = new JTextField();
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
		
		textSobrenome = new JTextField();
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBounds(194, 389, 404, 29);
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textSobrenome);
		textSobrenome.setColumns(10);
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comando para limpar os campos de textos 
				
				textPrimeiroNome.setText("");
				textSobrenome.setText("");
				textCPF.setText("");
				TextDataNascimento.setText("");
				
				textDataEntrada.setText("");
				textHoraEntrada.setText("");
				textDataSaida.setText("");
				txtHoraSaida.setText("");
				txtSenha.setText("");
						

			}
		});
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(423, 638, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		
		//preciso ajeitar a funcao desse botao pois ainda nao funciona 
		//ajeitar as validacoes e as telas de validacoes 
		JButton btnCadastro_Cliente = new JButton("Cadastrar");
		btnCadastro_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//precisa adicionar um comando que mostre a tela de confirmação de cadastro realizado ou não 
				// caso de certo precisa perguntar se deseja fazer mais alguma coisa ou se pode sair 
				//dao.insertHospede(null);
				
				//recebe a o conteudo que esta no Text e joga para a variavel 
				String nome = textPrimeiroNome.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Nome obrigatório!");
					return ;
				}
				
				String sobrenome = textSobrenome.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Sobrenome obrigatório!");
					return ;
				}
				
				String cpf = textCPF.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo CPF obrigatório!");
					return ;
				}
				Integer cpfI = Integer.parseInt(cpf);
				
				String dataNascimento = textDataEntrada.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Nascimento obrigatório!");
					return ;
				}
				LocalDate dn = LocalDate.parse(dataNascimento);
				
				String dataEntradaString = textDataEntrada.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Entrada obrigatório!");
					return ;
				}
				LocalDate de = LocalDate.parse(dataEntradaString);
				
				String dataSaida = textDataSaida.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Saída obrigatório!");
					return ;
				}
				LocalDate ds = LocalDate.parse(dataSaida);
				
				String horaEntrada = textHoraEntrada.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Hora de Entrada obrigatório!");
					return ;
				}
				
				String horaSaida = txtHoraSaida.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Hora de Saída obrigatório!");
					return ;
				}
				
				
				//cricao de objeto 
				Hospede h = new Hospede();
				//setando os valores
				h.setPrimeironome(nome);
				h.setSobrenome(sobrenome);
				h.setCpfClientes(cpfI);
				h.setDatanasciadamento(dn);
				h.setDataEntrada(de);
				h.setDataSaida(ds);
				h.setHoraEntrada(null);
				h.setHoraSaida(null);
				
				//instanciando a classe DAO
				HospedeDAO dao = new HospedeDAO();
				///inserindo na classe 
				dao.insertHospede(h);
				
				dispose();
				
				
			}
		});
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBounds(813, 638, 176, 39);
		contentPane.add(btnCadastro_Cliente);
		
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
		btnSair_tela_cad_Cliente.setBounds(1323, 708, 176, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
		
		JLabel lblInformacaoSenha = new JLabel("Apenas números, com no Mínimo 8 caracteres  e Sem caracteres especiais.");
		lblInformacaoSenha.setForeground(new Color(255, 0, 0));
		lblInformacaoSenha.setBounds(811, 488, 353, 13);
		contentPane.add(lblInformacaoSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(1, 50, 1));
		txtSenha.setBackground(new Color(252, 251, 244));
		txtSenha.setBounds(811, 508, 404, 29);
		contentPane.add(txtSenha);
		txtSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtSenha.setColumns(10);
		
		txtHoraSaida = new JTextField();
		txtHoraSaida.setBounds(986, 429, 165, 29);
		contentPane.add(txtHoraSaida);
		txtHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtHoraSaida.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroCliente.class.getResource("/imagens/LogoPI.png")));
		lblNewLabel.setBounds(437, 62, 145, 128);
		contentPane.add(lblNewLabel);
	}

	/**criado para ser adicionado em hospede
	 * 
	 * @param end
	 */
	public static void add(Hospede end) {
		// TODO Auto-generated method stub
		
	}
}
