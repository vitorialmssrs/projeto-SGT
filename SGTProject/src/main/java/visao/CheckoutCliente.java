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
import net.miginfocom.swing.MigLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class CheckoutCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextDataNascimento;
	private JTextField textCPF;
	private JTextField textPrimeiroNome;
	private JTextField textSobrenome;
	private JTextField textHoraSaida;
	private JTextField textDataSaida;

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
		contentPane.setLayout(new MigLayout("", "[300px][10px][27px][25px][50][45][179.00px][268.00px][159.00][50][176px]", "[60][61px][11px][56px][21px][33px][35][33px][21px][35][12px][33px][21px][35][39px][50][][39px]"));
		
		JLabel lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon(CheckoutCliente.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblIcone, "cell 4 1,alignx center");
		
		JLabel lblAgradecemosPorSua = new JLabel("Agradecemos por sua estadia!");
		lblAgradecemosPorSua.setForeground(new Color(1, 50, 1));
		lblAgradecemosPorSua.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblAgradecemosPorSua.setBackground(new Color(1, 50, 1));
		contentPane.add(lblAgradecemosPorSua, "cell 5 1 5 1");
		contentPane.add(lbl_Insira_Informacoes_Cadastro, "cell 5 3 4 1,growx,aligny top");
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblCPFCliente, "cell 3 4,grow");
		
		JLabel lblDataNascimento = new JLabel("* Data de nascimento:");
		lblDataNascimento.setBackground(new Color(1, 50, 1));
		lblDataNascimento.setForeground(new Color(1, 50, 1));
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataNascimento, "cell 7 4,alignx left,growy");
		
		textCPF = new JTextField();
		textCPF.setToolTipText("");
		textCPF.setForeground(new Color(1, 50, 1));
		textCPF.setBackground(new Color(252, 251, 244));
		textCPF.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCPF.setColumns(10);
		contentPane.add(textCPF, "cell 3 5,grow");
		
		TextDataNascimento = new JTextField();
		TextDataNascimento.setEnabled(false);
		TextDataNascimento.setForeground(new Color(1, 50, 1));
		TextDataNascimento.setBackground(new Color(252, 251, 244));
		TextDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		TextDataNascimento.setColumns(10);
		contentPane.add(TextDataNascimento, "cell 7 5,grow");
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblNome_Cliente, "cell 3 6,grow");
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setEnabled(false);
		textPrimeiroNome.setEditable(false);
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		contentPane.add(textPrimeiroNome, "cell 3 7,grow");
		
		JLabel lblDataHoraSaida = new JLabel("* Data e hora de saída:");
		lblDataHoraSaida.setForeground(new Color(1, 50, 1));
		lblDataHoraSaida.setBackground(new Color(1, 50, 1));
		lblDataHoraSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataHoraSaida, "cell 7 8,alignx left,aligny bottom");
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblSobrenomeCliente, "cell 3 9,growx,aligny center");
		
		textDataSaida = new JTextField();
		textDataSaida.setForeground(new Color(1, 50, 1));
		textDataSaida.setColumns(10);
		textDataSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		textDataSaida.setBackground(new Color(252, 251, 244));
		contentPane.add(textDataSaida, "cell 7 9,grow");
		
		textHoraSaida = new JTextField();
		textHoraSaida.setForeground(new Color(1, 50, 1));
		textHoraSaida.setColumns(10);
		textHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
		textHoraSaida.setBackground(new Color(252, 251, 244));
		contentPane.add(textHoraSaida, "cell 8 9,alignx left,growy");
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPrimeiroNome.setText(" ");
				textSobrenome.setText(" ");				
				textCPF.setText(" ");
				textDataSaida.setText("");
				textDataSaida.setText(" ");
				textHoraSaida.setText(" ");	
				
			}
		});
		
		textSobrenome = new JTextField();
		textSobrenome.setEnabled(false);
		textSobrenome.setEditable(false);
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSobrenome.setColumns(10);
		contentPane.add(textSobrenome, "cell 3 11,grow");
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		contentPane.add(btnLimpar_info_cliente, "cell 4 15,grow");
		
		JButton btnCadastro_Cliente = new JButton("Check-out");
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
//				String nome = textPrimeiroNome.getText();
//				if(nome.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Campo Nome obrigatório!");
//					return ;
//				}
//				
//				String sobrenome = textSobrenome.getText();
//				if(nome.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Campo Sobrenome obrigatório!");
//					return ;
//				}
//				
//				String cpf = textCPF.getText();
//				if(nome.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Campo CPF obrigatório!");
//					return ;
//				}
//				cpf = cpf.replace(".", "");
//				cpf = cpf.replace("-", "");
//				//Long cpfI = Long.parseLong(cpf);
//				
//				MaskFormatter mascaraCPF = null;
//				try {
//					mascaraCPF = new MaskFormatter("###.###.###-##");
//				} catch (ParseException e1) {
//  					e1.printStackTrace();
//					}
//						textCPF = new JFormattedTextField(mascaraCPF);
//						contentPane.add(textCPF);
//						textCPF.setColumns(15);
//				
//						String dataNascimento = TextDataNascimento.getText();
//						if(nome.length() == 0) {
//							JOptionPane.showMessageDialog(null, "Campo Data de Nascimento obrigatório!");
//							return ;
//						}
//						
//				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//
//						LocalDate dn = LocalDate.parse(dataNascimento, formatter);
//						
//						MaskFormatter mascaraDataNascimento = null;
//						try {
//							mascaraDataNascimento = new MaskFormatter("##/##/####");
//						} catch (ParseException e1) {
//		  					e1.printStackTrace();
//							}
//						TextDataNascimento = new JFormattedTextField(mascaraDataNascimento);
//								contentPane.add(TextDataNascimento);
//								TextDataNascimento.setColumns(10);
//				
//				String dataSaida = textDataSaida.getText();
//				if(nome.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Campo Data de Saída obrigatório!");
//					return ;
//				}
//				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//
//				LocalDate ds = LocalDate.parse(dataSaida, formatter1);
//				
//				MaskFormatter mascaraDataSaida = null;
//				try {
//					mascaraDataSaida = new MaskFormatter("##/##/####");
//				} catch (ParseException e1) {
//  					e1.printStackTrace();
//					}
//						textDataSaida = new JFormattedTextField(mascaraDataSaida);
//						contentPane.add(textDataSaida);
//						textDataSaida.setColumns(10);
//				
//				String horaSaida = textHoraSaida.getText();
//				if(nome.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Campo Hora de Saída obrigatório!");
//					return ;
//				}
//				MaskFormatter mascaraHoraSaida = null;
//				try {
//					mascaraHoraSaida = new MaskFormatter("##:##");
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//					}
//				textHoraSaida = new JFormattedTextField(mascaraHoraSaida);
//						contentPane.add(textHoraSaida);
//						textHoraSaida.setColumns(5);
//			
//						
//				//LocalDate dtSaida = LocalDate.parse(dataSaida);
//				LocalTime hrSaida = LocalTime.parse(horaSaida);
//				
//				Hospedagem hospedagem = new Hospedagem();
//				
//				hospedagem.setDataSaida(ds);
//				hospedagem.setHoraSaida(hrSaida);
//				
//				HospedagemDAO hospedagemdao = new HospedagemDAO();
//				
//				hospedagemdao.insertHospedagem(hospedagem);
//				
//				//cricao de objeto 
//				Hospede h = new Hospede();
//				
//				//setando os valores
//				h.setPrimeironome(nome);
//				h.setSobrenome(sobrenome);
//				h.setNumidentificacao(cpf);
//				h.setDatanascimento(dn);
//				
//				//instanciando a classe DAO
//				HospedeDAO dao = new HospedeDAO();
//				///inserindo na classe 
//				dao.insertHospede(h);
//				
//				dispose();	
				
			}
		});
		
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		contentPane.add(btnCadastro_Cliente, "cell 7 15,grow");
		contentPane.add(btnSair_tela_cad_Cliente, "cell 10 17,grow");
		
		textCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
		        String cpf = textCPF.getText();
		        if(cpf.length()==0) {
		            JOptionPane.showMessageDialog(null,"Campo de CPF obrigatório");
		            return ;
		        }
		        
		        HospedeDAO dao = new HospedeDAO();
		        Hospede hosp = dao.buscarHospedePorCpf(cpf);
		        
		        if (hosp != null) {
		            textPrimeiroNome.setText(hosp.getPrimeironome());
		            textSobrenome.setText(hosp.getSobrenome());
		            TextDataNascimento.setText(hosp.getDatanascimento().toString()); // Certifique-se de que o método getDatanascimento retorne um LocalDate ou algo similar que possa ser convertido para String
		        } else {
		            JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
		        }
		    }
		});
	}

	/**criado para ser adicionado em hospede
	 * 
	 * @param end
	 */
	public static void add(Hospede end) {
		// TODO Auto-generated method stub
		
	}
}
