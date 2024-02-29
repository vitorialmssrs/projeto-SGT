package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import modelo.Hospede;

public class HospedeDAO {

	private static HospedeDAO instancia;
	
	private HospedeDAO() {}
	
	public static HospedeDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedeDAO();
		}
	return instancia;
	}
	
	public int insertEndereco(Hospede end) {
		String SQL = "INSERT INTO hospede (cpf,idade) VALUES (?, ?)";

		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, end.getNome());
			ps.setString(2, end.getSobrenome());
			ps.setString(3, end.getCpf());
			ps.setString(4, end.getNascimento);
			ps.setString(5, end.getCheckin());
			ps.setString(6, end.getCheckout());

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
				String cpf = rs.getString("cpf");

				String nome = rs.getString("nome");
				
				/*end.setCpf(cpf);
				end.setNome(nome);

				String idade = rs.getString("idade");
				
				/*end.setCpf(cpf);
				end.setIdade(idade);

				hospede.add(end);*/ //retirar do comentario quando criar a tela hospede
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return hospedes;
	}
	//public boolean atualizarHospede(Hospede end) {	}
}
