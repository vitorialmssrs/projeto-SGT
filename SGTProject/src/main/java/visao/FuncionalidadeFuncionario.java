package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;
import net.miginfocom.swing.MigLayout;

public class FuncionalidadeFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Funcionario funcionarioLogado;

	/**
	 * Create the frame.
	 * @param fun 
	 */
	public FuncionalidadeFuncionario(Funcionario fun) {
		this.funcionarioLogado = fun;
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
		
		JLabel lblFTHotel = new JLabel("");
		lblFTHotel.setBounds(0, 0, 911, 1080);
		lblFTHotel.setIcon(new ImageIcon(FuncionalidadeFuncionario.class.getResource("/imagens/Hotel 2.png")));
		panelFt.add(lblFTHotel);
		
		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setBackground(new Color(227, 236, 226));
		contentPane.add(panelOpcoes);
		panelOpcoes.setLayout(new MigLayout("", "[100][300][150]", "[200][][100][50][200][50][200][50][200][50][100]"));
		
		JLabel lblCaro = new JLabel("Caro Funcionario");
		lblCaro.setForeground(new Color(1, 50, 1));
		lblCaro.setFont(new Font("Tahoma", Font.BOLD, 40));
		panelOpcoes.add(lblCaro, "cell 1 0,alignx center");
		
		JLabel lblEscolha = new JLabel("Escolha uma opção de operação");
		lblEscolha.setForeground(new Color(1, 50, 1));
		lblEscolha.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelOpcoes.add(lblEscolha, "cell 1 2,alignx center");
		
		JButton btnSolicitarLimpeza = new JButton("Solicitar Limpeza");
		btnSolicitarLimpeza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSolicitarLimpeza.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnSolicitarLimpeza.setBackground(new Color(81, 108, 81));
		btnSolicitarLimpeza.setForeground(new Color(255, 255, 255));
		btnSolicitarLimpeza.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons limpeza.png"));
		panelOpcoes.add(btnSolicitarLimpeza, "cell 1 4,grow");
		
		JButton btnSolicitarConcerto = new JButton("Solicitar Conserto");
		btnSolicitarConcerto.setFont(new Font("Tahoma", Font.BOLD, 48));
		btnSolicitarConcerto.setForeground(new Color(255, 255, 255));
		btnSolicitarConcerto.setBackground(new Color(66, 142, 66));
		btnSolicitarConcerto.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons conserto.png"));
		panelOpcoes.add(btnSolicitarConcerto, "cell 1 6,grow");
		
		JButton btnAtualizarEspaco = new JButton("Atualizar Espaço");
		btnAtualizarEspaco.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnAtualizarEspaco.setBackground(new Color(109, 164, 109));
		btnAtualizarEspaco.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons atualizacao espaco.png"));
		btnAtualizarEspaco.setForeground(new Color(255, 255, 255));
		panelOpcoes.add(btnAtualizarEspaco, "cell 1 8,grow");
		
		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair_1.setIcon(new ImageIcon(FuncionalidadeFuncionario.class.getResource("/imagens/Vector sair.png")));
		btnSair_1.setForeground(new Color(1, 50, 1));
		btnSair_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair_1.setBackground(new Color(227, 236, 226));
		panelOpcoes.add(btnSair_1, "cell 2 10,growx");
	}
}
