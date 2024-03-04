package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FuncionalidadeFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadeFuncionario frame = new FuncionalidadeFuncionario();
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
	public FuncionalidadeFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 236, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(227, 236, 226));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFTHotel = new JLabel("");
		lblFTHotel.setBounds(0, 0, 911, 1080);
		lblFTHotel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Hotel 2.png"));
		panel.add(lblFTHotel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(227, 236, 226));
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[150][300][150]", "[200][][100][50][200][50][200][50][200][50][100]"));
		
		JLabel lblNewLabel = new JLabel("Caro Funcionario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_1.add(lblNewLabel, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Escolha uma opção de operação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(lblNewLabel_1, "cell 1 2,alignx center");
		
		JButton btnNewButton = new JButton("Solicitar Limpeza");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnNewButton.setBackground(new Color(81, 108, 81));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons limpeza.png"));
		panel_1.add(btnNewButton, "cell 1 4,grow");
		
		JButton btnNewButton_1 = new JButton("Solicitar Conserto");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(66, 142, 66));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons conserto.png"));
		panel_1.add(btnNewButton_1, "cell 1 6,grow");
		
		JButton btnNewButton_2 = new JButton("Atualizar Espaço");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnNewButton_2.setBackground(new Color(109, 164, 109));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Icons atualizacao espaco.png"));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		panel_1.add(btnNewButton_2, "cell 1 8,grow");
		
		JButton btnNewButton_3_1 = new JButton("Sair");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\projeto-SGT\\SGTProject\\src\\main\\resources\\img\\Vector sair.png"));
		btnNewButton_3_1.setBackground(new Color(227, 236, 226));
		btnNewButton_3_1.setForeground(new Color(1, 50, 1));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton_3_1, "cell 2 10");
	}
}
