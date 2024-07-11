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
import java.time.format.DateTimeParseException;

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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Time;


public class TelaCheckOut extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextDataNascimento;
	private JTextField textNumeroIdentificacao;
	private JTextField textPrimeiroNome;
	private JTextField textSobrenome;
	private JTextField textHoraSaida;
	private JTextField textDataSaida;
	private JTextField textDataEntrada;
	private JTextField textDataEntrada_1;
	private JTextField textHoraEntrada;
	private JTextField textHoraEntrada_1;
	private JTextField textNumQuarto;
	private Hospede hosp;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckOut frame = new TelaCheckOut();
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
	public TelaCheckOut() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCheckOut.class.getResource("/imagens/LogoPI.png")));
		setBackground(new Color(255, 255, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[270][25px,grow][50][179.00px][268.00px,grow][159.00,grow][50][176px]", "[60][61px][11px][56px][21px][33px][35][33px][21px][35][12px][33px][21px][35][39px][17.00][50.00][39px][][][][][][]"));
		
		JLabel lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon(TelaCheckOut.class.getResource("/imagens/LogoPI.png")));
		contentPane.add(lblIcone, "cell 1 1,alignx center");
		
		JLabel lblAgradecemosPorSua = new JLabel("Agradecemos por sua estadia!");
		lblAgradecemosPorSua.setForeground(new Color(1, 50, 1));
		lblAgradecemosPorSua.setFont(new Font("Tahoma", Font.BOLD, 52));
		lblAgradecemosPorSua.setBackground(new Color(1, 50, 1));
		contentPane.add(lblAgradecemosPorSua, "cell 2 1 4 1");
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações abaixo para realizar o check-out: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		contentPane.add(lbl_Insira_Informacoes_Cadastro, "cell 2 3 4 1,growx,aligny top");
		
		JLabel lblCPFCliente = new JLabel("* CPF / CRNM / RNN / RNE:");
		lblCPFCliente.setForeground(new Color(1, 50, 1));
		lblCPFCliente.setBackground(new Color(1, 50, 1));
		lblCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblCPFCliente, "cell 1 4,grow");
		
		
		JLabel lblDataNascimento = new JLabel("* Data de nascimento:");
		lblDataNascimento.setBackground(new Color(1, 50, 1));
		lblDataNascimento.setForeground(new Color(1, 50, 1));
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataNascimento, "cell 4 4,alignx left,growy");
		
		/*try {
			MaskFormatter formatterNIden = new MaskFormatter("###.###.###-##");
			formatterNIden.setPlaceholder("");
			textNumeroIdentificacao = new JFormattedTextField(formatterNIden);
			textNumeroIdentificacao.setToolTipText("Digite seu CPF...");
			textNumeroIdentificacao.setForeground(new Color(102, 112, 133));
			textNumeroIdentificacao.setFont(new Font("Corbel", Font.ITALIC, 15));
			textNumeroIdentificacao.setBounds(10, 564, 458, 35);
			contentPane.add(formattedTextFieldCPF);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//textNumeroIdentificacao = new JTextField();
		try {
			MaskFormatter formatterNIden = new MaskFormatter("###.###.###-##");
			formatterNIden.setPlaceholder("");
			textNumeroIdentificacao = new JFormattedTextField(formatterNIden);
			textNumeroIdentificacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				HospedeDAO dao = HospedeDAO.getInstancia();  
				String numIdentificacao =  textNumeroIdentificacao.getText().trim();
		        String s =((JTextField) e.getSource()).getText();   
		        numIdentificacao = numIdentificacao.replace(".", "");
		        numIdentificacao = numIdentificacao.replace("-", "");
				Long numId = Long.valueOf(numIdentificacao);  
  
				hosp = dao.buscarHospedePorCpf(numId);
				if(hosp!=null) {  
					  
					textPrimeiroNome.setText(hosp.getPrimeironome());  
					textSobrenome.setText(hosp.getSobrenome());  
					  
					//conversão para data de nascimento de LocalDate para String  
					String dataNasc = String.valueOf(hosp.getDatanascimento());  
					TextDataNascimento.setText(dataNasc);
					
					HospedagemDAO hospedagemDao = new HospedagemDAO();
					Hospedagem hospedagem = hospedagemDao.buscarHospedagemPorHospede(hosp);
					
					textDataEntrada.setText(hospedagem.getDataEntrada().toString());
					textHoraEntrada.setText(hospedagem.getHoraEntrada().toString());
					textNumQuarto.setText(hospedagem.getNumQuarto().toString());
					
					 			  
				}  
			}
		});
		textNumeroIdentificacao.setToolTipText("Coloque o seu CPF Aqui");
		textNumeroIdentificacao.setForeground(new Color(1, 50, 1));
		textNumeroIdentificacao.setBackground(new Color(252, 251, 244));
		textNumeroIdentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroIdentificacao.setColumns(10);
		contentPane.add(textNumeroIdentificacao, "cell 1 5,grow");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TextDataNascimento = new JTextField();
		TextDataNascimento.setEditable(false);
		TextDataNascimento.setForeground(new Color(1, 50, 1));
		TextDataNascimento.setBackground(new Color(252, 251, 244));
		TextDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
		TextDataNascimento.setColumns(10);
		contentPane.add(TextDataNascimento, "cell 4 5,grow");
		
		JLabel lblNome_Cliente = new JLabel("* Primeiro nome:");
		lblNome_Cliente.setBackground(new Color(1, 50, 1));
		lblNome_Cliente.setForeground(new Color(1, 50, 1));
		lblNome_Cliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblNome_Cliente, "cell 1 6,grow");
		
		JLabel lblDataEntrada = new JLabel("* Data e hora de Entrada:");
		lblDataEntrada.setForeground(new Color(1, 50, 1));
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataEntrada, "cell 4 6");
		
		textPrimeiroNome = new JTextField();
		textPrimeiroNome.setEditable(false);
		textPrimeiroNome.setForeground(new Color(1, 50, 1));
		textPrimeiroNome.setBackground(new Color(252, 251, 244));
		textPrimeiroNome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textPrimeiroNome.setColumns(10);
		contentPane.add(textPrimeiroNome, "cell 1 7,grow");
		
		textDataEntrada_1 = new JTextField();
		textDataEntrada_1.setForeground(new Color(1, 50, 1));
		textDataEntrada_1.setBackground(new Color(252, 251, 244));
		textDataEntrada_1.setEditable(false);
		contentPane.add(textDataEntrada_1, "cell 4 7,grow");
		textDataEntrada_1.setColumns(10);
		
		
		try {
		    MaskFormatter mascaraHoraEntrada = new MaskFormatter("##/##/####");
		    textHoraEntrada = new JFormattedTextField(mascaraHoraEntrada);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		textHoraEntrada_1 = new JTextField();
		textHoraEntrada_1.setForeground(new Color(1, 50, 1));
		textHoraEntrada_1.setBackground(new Color(252, 251, 244));
		textHoraEntrada_1.setEditable(false);
		contentPane.add(textHoraEntrada_1, "cell 5 7,alignx left,growy");
		textHoraEntrada_1.setColumns(10);
		
		JLabel lblSobrenomeCliente = new JLabel("* Sobrenome:");
		lblSobrenomeCliente.setBackground(new Color(1, 50, 1));
		lblSobrenomeCliente.setForeground(new Color(1, 50, 1));
		lblSobrenomeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblSobrenomeCliente, "cell 1 9,growx,aligny center");
		
		JLabel lblDataHoraSaida = new JLabel("* Data e hora de saída:");
		lblDataHoraSaida.setForeground(new Color(1, 50, 1));
		lblDataHoraSaida.setBackground(new Color(1, 50, 1));
		lblDataHoraSaida.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblDataHoraSaida, "cell 4 9,alignx left,aligny bottom");
		
		textSobrenome = new JTextField();
		textSobrenome.setEditable(false);
		textSobrenome.setForeground(new Color(1, 50, 1));
		textSobrenome.setBackground(new Color(252, 251, 244));
		textSobrenome.setBorder(new LineBorder(new Color(1, 50, 1)));
		textSobrenome.setColumns(10);
		contentPane.add(textSobrenome, "cell 1 11,grow");
		/*try {
			MaskFormatter formttDNasc = new MaskFormatter("##/##/####");
			formttDNasc.setPlaceholder("");
			textDataNascimento = new JFormattedTextField(formttDNasc);
			textDataNascimento.setToolTipText("Coloque sua Data de Nascimento Aqui");
			textDataNascimento.setForeground(new Color(1, 50, 1));
			textDataNascimento.setBackground(new Color(252, 251, 244));
			textDataNascimento.setBounds(195, 484, 404, 29);
			textDataNascimento.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataNascimento.setColumns(10);
			contentPane.add(textDataNascimento);
		} catch(Exception e) {
			e.printStackTrace();
			}*/
		
		try {
			MaskFormatter formttDS = new MaskFormatter("##/##/####");
			formttDS.setPlaceholder("");
			textDataSaida = new JFormattedTextField(formttDS);
			textDataSaida.setToolTipText("Coloque a Data de Saida Aqui");
			

			//textDataNascimento.setBounds(195, 484, 404, 29);
			
			textDataSaida.setForeground(new Color(1, 50, 1));
			textDataSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
			textDataSaida.setBackground(new Color(252, 251, 244));
			textDataSaida.setColumns(10);
			contentPane.add(textDataSaida, "cell 4 11,grow");
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		try {
			MaskFormatter formttHS = new MaskFormatter("##:##");
			formttHS.setPlaceholder("");
			textHoraSaida = new JFormattedTextField(formttHS);
			textHoraSaida.setToolTipText("Coloque Hora de Saida Aqui");
			textHoraSaida.setForeground(new Color(1, 50, 1));
			textHoraSaida.setBorder(new LineBorder(new Color(1, 50, 1)));
			textHoraSaida.setBackground(new Color(252, 251, 244));
			textHoraSaida.setColumns(10);
			contentPane.add(textHoraSaida, "cell 5 11,alignx left,growy");
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		JLabel lblNumQuarto = new JLabel("* Número do Quarto: ");
		lblNumQuarto.setForeground(new Color(1, 50, 1));
		lblNumQuarto.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(lblNumQuarto, "cell 1 13,alignx left,aligny top");
		
		textNumQuarto = new JTextField();
		textNumQuarto.setForeground(new Color(1, 50, 1));
		textNumQuarto.setBackground(new Color(252, 251, 244));
		textNumQuarto.setEditable(false);
		contentPane.add(textNumQuarto, "cell 1 14,grow");
		textNumQuarto.setColumns(10);
		
		JButton btnLimpar_info_cliente = new JButton("Limpar");
		btnLimpar_info_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPrimeiroNome.setText(" ");
				textSobrenome.setText(" ");				
				textNumeroIdentificacao.setText(" ");
				textDataSaida.setText(" ");
				textDataSaida.setText(" ");
				textHoraSaida.setText(" ");	
				textDataEntrada.setText(" ");
				textHoraEntrada.setText(" ");
				textNumQuarto.setText(" ");
				TextDataNascimento.setText(" ");
				
			}
		});
		
		btnLimpar_info_cliente.setForeground(new Color(252, 251, 244));
		btnLimpar_info_cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar_info_cliente.setBackground(new Color(109, 164, 109));
		contentPane.add(btnLimpar_info_cliente, "cell 2 16,grow");
		
		JButton btnCadastro_Cliente = new JButton("Check-out");
		btnCadastro_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				// Validações de data e hora
                String dataSaida = textDataSaida.getText().trim();
                if (dataSaida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Data de Saída obrigatório!");
                    return;
                }

                // Conversão de data e hora
                LocalDate dSaida;
                try {
                    dSaida = LocalDate.parse(dataSaida, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data de saída inválida!");
                    return;
                }
                
                
                String horaSaida = textHoraSaida.getText().trim(); 
                if (horaSaida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Hora de Saída obrigatório!");
                    return;
                }

                LocalTime hSaida;
                try {
                    hSaida = LocalTime.parse(horaSaida, DateTimeFormatter.ofPattern("HH:mm"));
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Horário de saída inválido! O formato deve ser HH:mm");
                    return;
                }
                
                String dataEntrada = textDataSaida.getText().trim();
                if (dataEntrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Data de Entrada obrigatório!");
                    return;
                }

                // Conversão de data e hora
                LocalDate dEntrada;
                try {
                	dEntrada = LocalDate.parse(dataEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data de entrada inválida!");
                    return;
                }
                
                String horaEntrada = textHoraSaida.getText().trim(); 
                if (horaEntrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Hora de entrada obrigatório!");
                    return;
                }
                LocalTime hEntrada;
                try {
                	hEntrada = LocalTime.parse(horaEntrada, DateTimeFormatter.ofPattern("HH:mm"));
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Horário de entrada inválido! O formato deve ser HH:mm");
                    return;
                }

                // Criação do objeto Hospedagem
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setDataSaida(dSaida);
                hospedagem.setHoraSaida(hSaida);
                hospedagem.setDataEntrada(dEntrada);
                hospedagem.setHoraEntrada(hEntrada);
                hospedagem.setHospede(hosp);
                

                // Inserção no banco de dados
                HospedagemDAO hospedagemdao = new HospedagemDAO();
                hospedagemdao.AtualizarCheckOut(hospedagem);
                
              
				JOptionPane.showMessageDialog(null, "Check-Out realizado com sucesso!");

                dispose();	
				
			}
		});
		
		btnCadastro_Cliente.setForeground(new Color(252, 251, 244));
		btnCadastro_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastro_Cliente.setBackground(new Color(66, 142, 66));
		contentPane.add(btnCadastro_Cliente, "cell 4 16,alignx center,growy");
		
		JButton btnSair_tela_cad_Cliente = new JButton("<- | Sair");
		btnSair_tela_cad_Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				FuncionalidadeCliente frame = new FuncionalidadeCliente();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnSair_tela_cad_Cliente.setForeground(new Color(252, 251, 244));
		btnSair_tela_cad_Cliente.setBackground(new Color(1, 50, 1));
		btnSair_tela_cad_Cliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(btnSair_tela_cad_Cliente, "cell 5 21 1 3,alignx center,growy");
	}

	/**criado para ser adicionado em hospede
	 * 
	 * @param end
	 */
	public static void add(Hospede end) {
		// TODO Auto-generated method stub
		
	}
}
