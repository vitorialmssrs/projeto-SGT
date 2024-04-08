package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.time.LocalDate;
import java.sql.Date;

import controle.FuncionarioDAO;
import modelo.Funcionario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeFuncionario;
	private JTextField textNumeroIndentificacao;
	private JTextField textCepFuncionario;
	private JTextField textDataFuncionario;
	private JTextField textNumeroFuncionario;
	private JTextField textTelefoneFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCaroFuncionario = new JLabel("Caro funcionário,");
		lblCaroFuncionario.setBounds(553, 44, 466, 61);
		lblCaroFuncionario.setForeground(new Color(1, 50, 1));
		lblCaroFuncionario.setBackground(new Color(1, 50, 1));
		lblCaroFuncionario.setFont(new Font("Tahoma", Font.BOLD, 52));
		contentPane.add(lblCaroFuncionario);
		
		JLabel lbl_Insira_Informacoes_Cadastro = new JLabel("Insira as informações para cadastro: ");
		lbl_Insira_Informacoes_Cadastro.setForeground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setBackground(new Color(1, 50, 1));
		lbl_Insira_Informacoes_Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lbl_Insira_Informacoes_Cadastro.setBounds(553, 115, 474, 31);
		contentPane.add(lbl_Insira_Informacoes_Cadastro);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(CadastroFuncionario.class.getResource("/imagens/Châteu_Imperial-removebg-preview 1.png")));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogo.setBounds(33, 185, 486, 451);
		contentPane.add(lblLogo);
		
		JLabel lblInformacoes_Funcionario = new JLabel("Informações do Funcionário");
		lblInformacoes_Funcionario.setForeground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setBackground(new Color(1, 50, 1));
		lblInformacoes_Funcionario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformacoes_Funcionario.setBounds(553, 245, 466, 31);
		contentPane.add(lblInformacoes_Funcionario);
		
		JLabel lblNomeFuncionario = new JLabel("Nome Completo:");
		lblNomeFuncionario.setBackground(new Color(1, 50, 1));
		lblNomeFuncionario.setForeground(new Color(1, 50, 1));
		lblNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNomeFuncionario.setBounds(553, 286, 143, 21);
		contentPane.add(lblNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setForeground(new Color(1, 50, 1));
		textNomeFuncionario.setBackground(new Color(252, 251, 244));
		textNomeFuncionario.setBounds(688, 286, 644, 21);
		textNomeFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblNumeroIndentificacao = new JLabel("Numero de Indentificação:");
		lblNumeroIndentificacao.setBackground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		lblNumeroIndentificacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroIndentificacao.setBounds(553, 327, 200, 21);
		contentPane.add(lblNumeroIndentificacao);
		
		textNumeroIndentificacao = new JTextField();
		textNumeroIndentificacao.setForeground(new Color(1, 50, 1));
		textNumeroIndentificacao.setBackground(new Color(252, 251, 244));
		textNumeroIndentificacao.setBounds(763, 330, 602, 21);
		contentPane.add(textNumeroIndentificacao);
		textNumeroIndentificacao.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroIndentificacao.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBackground(new Color(1, 50, 1));
		lblEndereco.setForeground(new Color(1, 50, 1));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(553, 462, 87, 21);
		contentPane.add(lblEndereco);
		
		JLabel lblCepFuncionario = new JLabel("Cep:");
		lblCepFuncionario.setForeground(new Color(1, 50, 1));
		lblCepFuncionario.setBackground(new Color(1, 50, 1));
		lblCepFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCepFuncionario.setBounds(553, 493, 45, 21);
		contentPane.add(lblCepFuncionario);
		
		textCepFuncionario = new JTextField();
		textCepFuncionario.setForeground(new Color(1, 50, 1));
		textCepFuncionario.setBackground(new Color(252, 251, 244));
		textCepFuncionario.setBounds(600, 493, 129, 21);
		contentPane.add(textCepFuncionario);
		textCepFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textCepFuncionario.setColumns(10);
		
		JLabel lblDataFuncionario = new JLabel("Data de Nascimento:");
		lblDataFuncionario.setBackground(new Color(1, 50, 1));
		lblDataFuncionario.setForeground(new Color(1, 50, 1));
		lblDataFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataFuncionario.setBounds(553, 370, 176, 21);
		contentPane.add(lblDataFuncionario);
		
		textDataFuncionario = new JTextField();
		textDataFuncionario.setForeground(new Color(1, 50, 1));
		textDataFuncionario.setBackground(new Color(252, 251, 244));
		textDataFuncionario.setBounds(719, 373, 168, 21);
		textDataFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textDataFuncionario);
		
		textDataFuncionario.setColumns(10);
		
		JLabel lblNumeroFuncionario = new JLabel("Número:");
		lblNumeroFuncionario.setForeground(new Color(1, 50, 1));
		lblNumeroFuncionario.setBackground(new Color(1, 50, 1));
		lblNumeroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroFuncionario.setBounds(553, 533, 72, 17);
		contentPane.add(lblNumeroFuncionario);
		
		textNumeroFuncionario = new JTextField();
		textNumeroFuncionario.setForeground(new Color(1, 50, 1));
		textNumeroFuncionario.setBackground(new Color(252, 251, 244));
		textNumeroFuncionario.setBounds(632, 535, 97, 19);
		contentPane.add(textNumeroFuncionario);
		textNumeroFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		textNumeroFuncionario.setColumns(10);
		
		JLabel lblTelefoneFuncionario = new JLabel("Telefone:");
		lblTelefoneFuncionario.setForeground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setBackground(new Color(1, 50, 1));
		lblTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefoneFuncionario.setBounds(553, 414, 97, 21);
		contentPane.add(lblTelefoneFuncionario);
		
		textTelefoneFuncionario = new JTextField();
		textTelefoneFuncionario.setForeground(new Color(1, 50, 1));
		textTelefoneFuncionario.setBackground(new Color(252, 251, 244));
		textTelefoneFuncionario.setBounds(633, 417, 168, 21);
		textTelefoneFuncionario.setBorder(new LineBorder(new Color(1, 50, 1)));
		contentPane.add(textTelefoneFuncionario);
		textTelefoneFuncionario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comando para limpar os campos 
				
				 textNomeFuncionario.setText(" ");
				 textNumeroIndentificacao.setText(" ");
				 textCepFuncionario.setText(" ");
				 textDataFuncionario.setText(" ");
				 textNumeroFuncionario.setText(" ");
				 textTelefoneFuncionario.setText(" ");
			}
		});
		btnLimpar.setForeground(new Color(252, 251, 244));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLimpar.setBackground(new Color(109, 164, 109));
		btnLimpar.setBounds(608, 623, 176, 39);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*String SimpleDateFormat = "dd/MM/yyyy";*/
				/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");*/
				
				String nomeCompleto = textNomeFuncionario.getText();
				int numIndentificacao = parseInt(textNumeroIndentificacao.getText());
				int telefone = parseInt(textTelefoneFuncionario.getText());
				int cep = parseInt(textCepFuncionario.getText());
				int numCasa = parseInt(textNumeroFuncionario.getText());
				
				/*Date dataNascismento = null;
				try {
					dataNascismento = dateFormat.parse(textDataFuncionario.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				   
				//Verifica se tem alguma coisa
				if(nomeCompleto.isEmpty()){
				
					// exibir uma mensagem de erro
				}else {
					
				//Instanciar o OBJETO do cadastro 
				Funcionario f = new Funcionario();
				
				//Setar valores digitados nos atributos do OBJETO
			    f.setNumIndentificacao(numIndentificacao);
			    f.setNomeCompleto(nomeCompleto);
			   /* f.setDataNascismento(dataNascismento);*/
				f.setTelefone(telefone);
				f.setCep(cep);
				f.setNumCasa(numCasa);
				
				//Instanciar o DAO
				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				//Fazer a INSERÇÃO
				int valida = dao.inserirFuncionario(f);
					
				}
			}

			private int parseInt(String text) {
				return 0;
			}
		});
		contentPane.add(btnCadastrar);
		
		btnCadastrar.setBackground(new Color(66, 142, 66));
		btnCadastrar.setForeground(new Color(252, 251, 244));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCadastrar.setBounds(843, 623, 176, 39);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("<- | Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setForeground(new Color(252, 251, 244));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSair.setBounds(1204, 714, 176, 39);
		contentPane.add(btnSair);
	}
}
