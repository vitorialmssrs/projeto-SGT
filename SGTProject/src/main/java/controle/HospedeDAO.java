package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Hospede;
import visao.CadastroCliente;

public class HospedeDAO {

	private static final Date Date = null;
	private static HospedeDAO instancia;
	
	private HospedeDAO() {}
	
	public static HospedeDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedeDAO();
		}
	return instancia;
	}
	
	public int insertHospede(Hospede end) { 
		String SQL = "INSERT INTO hospede (primeiroNome, sobrenome, cpf, dataNascimento, checkIn, checkOut) VALUES (?, ?)";

		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, end.getPrimeiro_nome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getCpf_clientes());
			ps.setDate(4, (java.sql.Date) end.getData_de_nascimento());
			ps.setDate(5, (java.sql.Date) end.getCheckin());
			ps.setDate(6, (java.sql.Date) end.getCheckout());

			return ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		

		return 0;
	}
	
	public ArrayList<Hospede> listarHospede(){
		
		ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
		
		String SQL = "SELECT * FROM hospedes";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Hospede end = new Hospede();
				
				String PrimeiroNome = rs.getString("primeiroNome");
				
				String Sobrenome = rs.getString("sobrenome");
				
				String dataNascimento = rs.getString("dataNascimento");
								
				String cpf = rs.getString("cpf");
				
				String dataCheckIn = rs.getString("DataCheckIn");
				
				String dataCheckOut = rs.getString("DataCheckOut");
				
				end.setPrimeiro_nome(PrimeiroNome);
				end.setSobrenome(Sobrenome);
				end.setCpf_clientes(0);
				end.setData_de_nascimento(Date);
				end.setCheckin(Date);
				end.setCheckout(Date);
				
				
				String primeiroNome = rs.getString("Primeiro Nome");
				String sobrenome = rs.getString("Sobrenome");
				String CPF = rs.getNString("CPF");
				String DataNascimento = rs.getNString("Data de Nascimento");
				String checkIn = rs.getString("Check-in");
				String checkOut = rs.getString("Check-out");
				
				CadastroCliente.add(end);		
			//precisa acrescentar a tela de confimação 
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return hospedes;
	}
	
	public boolean atualizarHospede(Hospede end) {
		String SQL = "UPDATE atualizar SET nome = ? WHERE cpf = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		int retorno = 0;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, end.getPrimeiro_nome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getCpf_clientes());
			ps.setDate(4, (java.sql.Date) end.getData_de_nascimento());
			ps.setDate(5, (java.sql.Date) end.getCheckin());
			ps.setDate(6, (java.sql.Date) end.getCheckout());
			retorno = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno;
	}
}
