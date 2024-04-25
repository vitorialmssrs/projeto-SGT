package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedagemDAO;
import controle.HospedeDAO;
import modelo.Hospedagem;
import modelo.Hospede;

import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class TelaCheckIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataEntrada;
	private JTextField textDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textHoraEntrada;
	private JTextField textDataSaida;
	private JTextField textSobrenome;
	private JTextField txtSenha;
	private JTextField txtHoraSaida;
	private JTextField textTelefone;
	private JTextField textEmail;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckIn frame = new TelaCheckIn();
					//sempre antes do set visible para abrir em tela cheia 
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public TelaCheckIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCheckIn.class.getResource("/imagens/LogoPI.png")));
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
		lblNome_Cliente.setBounds(195, 263, 202, 21);
		contentPane.add(lblNome_Cliente);
		
		textDataEntrada = new JTextField();
		textDataEntrada.setForeground(new Color(1, 50, 1));
		textDataEntrada.setBackground(new Color(252, 251, 244));
		textDataEntrada.setBounds(811, 319, 165, 29);
		textDataEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textDataEntrada);
		textDataEntrada.setColumns(10);
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSobrenomeCliente.setBounds(195, 325, 165, 22);
		contentPane.add(lblSobrenomeCliente);
		

		textDataNascimento = new JTextField();
		textDataNascimento.setForeground(new Color(1, 50, 1));
		textDataNascimento.setBackground(new Color(252, 251, 244));
		textDataNascimento.setBounds(195, 484, 404, 29);
		contentPane.add(textDataNascimento);
		textDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataNascimento.setColumns(10);

		
		JLabel lblTelefone = new JLabel("* Telefone:");
		lblTelefone.setBackground(new Color(1, 50, 1));
		lblTelefone.setForeground(new Color(1, 50, 1));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTelefone.setBounds(195, 524, 236, 21);
		contentPane.add(lblTelefone);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("");
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setBounds(195, 417, 404, 29);
		contentPane.add(textCPF);
		textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCPF.setColumns(10);
		
		JLabel lblDataEntrada = new JLabel("* Data e hora de entrada: ");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setBackground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataEntrada.setBounds(811, 291, 255, 21);
		contentPane.add(lblDataEntrada);
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBounds(195, 291, 404, 29);
		contentPane.add(textPrimeiroNome);
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		
		JLabel lblDataSaida = new JLabel("* Data e hora de saída:");
		lblDataSaida.setBackground(new Color(1, 50, 1));
		lblDataSaida.setForeground(new Color(1, 50, 1));
		lblDataSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataSaida.setBounds(811, 353, 232, 21);
		contentPane.add(lblDataSaida);
		
		textHoraEntrada = new JTextField();
		textHoraEntrada.setForeground(new Color(1, 50, 1));
		textHoraEntrada.setBackground(new Color(252, 251, 244));
		textHoraEntrada.setBounds(986, 319, 165, 29);
		textHoraEntrada.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textHoraEntrada);
		
		textHoraEntrada.setColumns(10);
		
				
		JLabel lblSenhaCad = new JLabel("* Crie uma senha para o cadastro: ");
		lblSenhaCad.setBackground(new Color(1, 50, 1));
		lblSenhaCad.setForeground(new Color(1, 50, 1));
		lblSenhaCad.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSenhaCad.setBounds(811, 489, 340, 21);
		contentPane.add(lblSenhaCad);
		
		textDataSaida = new JTextField();
		textDataSaida.setBackground(new Color(252, 251, 244));
		textDataSaida.setBounds(811, 379, 165, 29);
		contentPane.add(textDataSaida);
		textDataSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataSaida.setColumns(10);
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCPFCliente.setBounds(195, 387, 300, 18);
		contentPane.add(lblCPFCliente);
		
		textSobrenome = new JTextField();
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBounds(195, 351, 404, 29);
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
				textDataNascimento.setText("");
				textDataEntrada.setText("");
				textHoraEntrada.setText("");
				textDataSaida.setText("");
				txtHoraSaida.setText("");
				txtSenha.setText("");	
				textTelefone.setText(" ");
				textEmail.setText("");
				

			}
		});
		
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		btnLimpar_info_cliente.setBounds(423, 638, 176, 39);
		contentPane.add(btnLimpar_info_cliente);
		
		JButton btnCadastro_Cliente = new JButton("Cadastrar");
		btnCadastro_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Como adicionar uma mascara ao text
				MaskFormatter mascaraTel = null;
					try {
      					mascaraTel = new MaskFormatter("(##) ###-###-###");
					} catch (ParseException e) {
      					e.printStackTrace();
 					}
 						textField = new JFormattedTextField(mascaraTel);
 						contentPane.add(textField);
 						textField.setColumns(10);
 						
 					*/
				
				
				//recebe a o conteudo que esta no Text e joga para a variavel 
				String nome = textPrimeiroNome.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Nome obrigatório!");
					return ;
				}
				
				String sobrenome = textSobrenome.getText();
				if(sobrenome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Sobrenome obrigatório!");
					return ;
				}
				
				String numId = textCPF.getText();
				if(numId.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo CPF obrigatório!");
					return ;
				}
				numId = numId.replace(".", "");
				numId = numId.replace("-", "");
				Long numID = Long.parseLong(numId);
				
				MaskFormatter mascaraNumID = null;
				try {
					mascaraNumID = new MaskFormatter("###.###.###-##");
				} catch (ParseException e1) {
  					e1.printStackTrace();
					}
						textCPF = new JFormattedTextField(mascaraNumID);
						contentPane.add(textCPF);
						textCPF.setColumns(15);
				
				String dataNascimento = textDataNascimento.getText();
				if(dataNascimento.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Nascimento obrigatório!");
					return ;
				}
				
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

				LocalDate dn = LocalDate.parse(dataNascimento, formatter);
				
				MaskFormatter mascaraDataNascimento = null;
				try {
					mascaraDataNascimento = new MaskFormatter("##/##/####");
				} catch (ParseException e1) {
  					e1.printStackTrace();
					}
				textDataNascimento = new JFormattedTextField(mascaraDataNascimento);
						contentPane.add(textDataNascimento);
						textDataNascimento.setColumns(10);
				
				String dataEntrada = textDataEntrada.getText();
				if(dataEntrada.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Entrada obrigatório!");
					return ;
				}
				
				MaskFormatter mascaraDataEntrada = null;
				try {
					mascaraDataEntrada = new MaskFormatter("##/##/####");
				} catch (ParseException e1) {
  					e1.printStackTrace();
					}
						textDataEntrada = new JFormattedTextField(mascaraDataEntrada);
						contentPane.add(textDataEntrada);
						textDataEntrada.setColumns(10);
				
				String dataSaida = textDataSaida.getText();
				if(dataSaida.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Data de Saída obrigatório!");
					return ;
				}
				MaskFormatter mascaraDataSaida = null;
				try {
					mascaraDataSaida = new MaskFormatter("##/##/####");
				} catch (ParseException e1) {
  					e1.printStackTrace();
					}
						textDataSaida = new JFormattedTextField(mascaraDataSaida);
						contentPane.add(textDataSaida);
						textDataSaida.setColumns(10);
				
				String horaEntrada = textHoraEntrada.getText();
				if(horaEntrada.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Hora de Entrada obrigatório!");
					return ;
				}
				
				MaskFormatter mascaraHoraEntrada = null;
				try {
					mascaraHoraEntrada = new MaskFormatter("##:##");
				} catch (ParseException e1) {
					e1.printStackTrace();
					}
						textHoraEntrada = new JFormattedTextField(mascaraHoraEntrada);
						contentPane.add(textHoraEntrada);
						textHoraEntrada.setColumns(5);
						
				String horaSaida = txtHoraSaida.getText();
				if(horaSaida.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Hora de Saída obrigatório!");
					return ;
				}
				
				String telefone = textTelefone.getText();
				if(telefone.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Telefone obrigatório!");
					return ;
				}
				
				String email = textEmail.getText();
				if(email.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Email obrigatório!");
					return ;
				}
				String senha = txtSenha.getText();
				if(senha.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Senha obrigatório!");
					return ;
				}
				int senhai = Integer.parseInt(senha);
			
				LocalDate dtEntrada = LocalDate.parse(dataEntrada, formatter);
				LocalDate dtSaida = LocalDate.parse(dataSaida, formatter);
				DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");

				LocalTime hrEntrada = LocalTime.parse(horaEntrada,formattertime);
				LocalTime hrSaida = LocalTime.parse(horaSaida,formattertime);
				
				Hospedagem hospedagem = new Hospedagem();
				
				hospedagem.setDataEntrada(dtEntrada);
				hospedagem.setDataSaida(dtSaida);
				hospedagem.setHoraEntrada(hrEntrada);
				hospedagem.setHoraSaida(hrSaida);
				
				HospedagemDAO hospedagemdao = new HospedagemDAO();
				
				hospedagemdao.insertHospedagem(hospedagem);
				
				//cricao de objeto 
				Hospede h = new Hospede();
				
				//setando os valores
				h.setPrimeironome(nome);
				h.setSobrenome(sobrenome);
				h.setNumidentificacao(numID);
				h.setDatanascimento(dn);
				h.setTelefone(telefone);
				h.setEmail(email);
				h.setSenha(senhai);
				
				//instanciando a classe DAO
				HospedeDAO dao = new HospedeDAO();
				///inserindo na classe 
				dao.insertHospede(h);
				
				AvisoCheckInHospede frame = new AvisoCheckInHospede();
				frame.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Cadastro Realizado!");

				
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
				
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair_tela_cad_Cliente.setBounds(1323, 708, 176, 39);
		contentPane.add(btnSair_tela_cad_Cliente);
		
		JLabel lblInformacaoSenha = new JLabel("Apenas números, com no Mínimo 8 caracteres  e Sem caracteres especiais.");
		lblInformacaoSenha.setForeground(new Color(255, 0, 0));
		lblInformacaoSenha.setBounds(811, 512, 353, 13);
		contentPane.add(lblInformacaoSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(1, 50, 1));
		txtSenha.setBackground(new Color(252, 251, 244));
		txtSenha.setBounds(811, 532, 404, 29);
		contentPane.add(txtSenha);
		txtSenha.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtSenha.setColumns(10);
		
		txtHoraSaida = new JTextField();
		txtHoraSaida.setBounds(986, 379, 165, 29);
		contentPane.add(txtHoraSaida);
		txtHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		txtHoraSaida.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCheckIn.class.getResource("/imagens/LogoPI.png")));
		lblNewLabel.setBounds(437, 62, 145, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblDataNascimento_1 = new JLabel("* Data de nascimento:");
		lblDataNascimento_1.setForeground(new Color(1, 50, 1));
		lblDataNascimento_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDataNascimento_1.setBackground(new Color(1, 50, 1));
		lblDataNascimento_1.setBounds(195, 452, 236, 21);
		contentPane.add(lblDataNascimento_1);
		
		textTelefone = new JTextField();
		textTelefone.setForeground(new Color(1, 50, 1));
		textTelefone.setColumns(10);
		textTelefone.setBorder(new LineBorder(new Color(1, 50, 1)));
		textTelefone.setBackground(new Color(252, 251, 244));
		textTelefone.setBounds(195, 556, 404, 29);
		contentPane.add(textTelefone);
		
		JLabel lblEmail = new JLabel("* Email: ");
		lblEmail.setForeground(new Color(1, 50, 1));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBackground(new Color(1, 50, 1));
		lblEmail.setBounds(811, 417, 340, 21);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setForeground(new Color(1, 50, 1));
		textEmail.setColumns(10);
		textEmail.setBorder(new LineBorder(new Color(1, 50, 1)));
		textEmail.setBackground(new Color(252, 251, 244));
		textEmail.setBounds(811, 449, 404, 29);
		contentPane.add(textEmail);
	}

	/**criado para ser adicionado em hospede
	 * 
	 * @param end
	 */
	public static void add(Hospede end) {
		// TODO Auto-generated method stub
		
	}
}