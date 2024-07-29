package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.w3c.dom.Text;

import controle.EspacosDAO;
import controle.FuncionarioDAO;
import controle.HospedeDAO;
import controle.ManutencaoEspacosDAO;
import controle.ReservaEspacoDAO;
import modelo.EspacoHotel;
import modelo.Funcionario;
import modelo.Hospede;
import modelo.ManutencaoEspacos;
import modelo.ReservaEspacos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class TelaReservaEspacoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textData;
	private JTextField textHorario;

	/**
	 * Launch the application.*/
	 
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManutencaoEspacos frame = new ManutencaoEspacos();
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
	public TelaReservaEspacoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 246, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaReservaEspacoCliente.class.getResource("/imagens/Hotel 2.png")));
		lblNewLabel.setBounds(0, 0, 947, 1031);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Qual dia e horario você deseja reservar?");
		lblTitulo.setForeground(new Color(1, 50, 1));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitulo.setBounds(51, 87, 837, 49);
		panel_1.add(lblTitulo);
		
		JLabel lblData = new JLabel("Data\r\n");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblData.setBounds(425, 283, 43, 67);
		panel_1.add(lblData);
		
		/*textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(350, 333, 214, 40);
		panel_1.add(textData);*/
		try {
			MaskFormatter formttDNasc = new MaskFormatter("##/##/####");
			formttDNasc.setPlaceholder("");
			textData = new JFormattedTextField(formttDNasc);
			textData.setToolTipText("Coloque a Data da Reserva Aqui");
			textData.setForeground(new Color(1, 50, 1));
			textData.setBackground(new Color(252, 251, 244));
			textData.setBounds(350, 333, 214, 40);
			textData.setColumns(10);
			panel_1.add(textData);
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		JLabel lblHorario = new JLabel("Horario\r\n");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorario.setBounds(415, 411, 66, 81);
		panel_1.add(lblHorario);
		
		/*textHorario = new JTextField();
		textHorario.setColumns(10);
		textHorario.setBounds(350, 467, 214, 40);
		panel_1.add(textHorario);*/
		
		try {
			MaskFormatter formttDNasc = new MaskFormatter("##:##");
			formttDNasc.setPlaceholder("");
			textHorario = new JFormattedTextField(formttDNasc);
			textHorario.setToolTipText("Coloque o Horario da Reserva Aqui");
			textHorario.setForeground(new Color(1, 50, 1));
			textHorario.setBackground(new Color(252, 251, 244));
			textHorario.setBounds(350, 467, 214, 40);
			textHorario.setColumns(10);
			panel_1.add(textHorario);
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaEspacosHotelCliente frame = new TelaEspacosHotelCliente();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		btnSair.setIcon(new ImageIcon(TelaReservaEspacoCliente.class.getResource("/imagens/Vector sair.png")));
		btnSair.setBounds(651, 839, 157, 40);
		btnSair.setBackground(new Color(66, 142, 66));
		btnSair.setForeground(new Color(252, 251, 244));
		panel_1.add(btnSair);
		
		JButton btnConfirmar = new JButton("Confirmar\r\n");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");	
				String dia = textData.getText();
				String hora = textHorario.getText();
				LocalDateTime diadate = LocalDateTime.parse(dia+" "+hora, formatter);
				
				ReservaEspacos hospede = new ReservaEspacos();
				
				ReservaEspacos res = new ReservaEspacos();
				res.setDiahorario(diadate);

				ReservaEspacoDAO reserva = ReservaEspacoDAO.getInstancia();
				int id = reserva.inserirReservaEspaco(hospede);
				hospede.setCliente(id);
				
				int resdao = reserva.inserirReservaEspaco(res);
				
				
				
				if(resdao != Integer.MIN_VALUE) {
					dispose();//verificar qual tela levar
					TelaPopUpSucessoCliente suscli = new TelaPopUpSucessoCliente();
					suscli.setVisible(true);
				}else {
					TelaPopUpErroCliente errcli = new TelaPopUpErroCliente();
					errcli.setVisible(true);
				}
				} catch(Exception ex) {
					ex.printStackTrace();
					/*TelaPopUpErroCliente errcli = new TelaPopUpErroCliente();
					errcli.setVisible(true);*/
				}
			}
		});
		btnConfirmar.setBackground(new Color(109, 164, 109));
		btnConfirmar.setForeground(new Color(252, 251, 244));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmar.setBounds(380, 673, 157, 61);
		panel_1.add(btnConfirmar);
		
		
	}
	}
