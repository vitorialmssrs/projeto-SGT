package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.Hospedagem;

public class HospedagemDAO {

	private static HospedagemDAO instancia;
	
	public static HospedagemDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedagemDAO();
		}
		return instancia;
	}
	
	public int insertHospedagem(Hospedagem end) {
		String SQL = "INSERT INTO hospedagem (checkin,checkout) VALUES (?,?)";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, Date.valueOf(end.getCheckindata()));
			ps.setTime(2, Time.valueOf(end.getCheckinhora()));
			ps.setDate(3, Date.valueOf(end.getCheckoutdata()));
			ps.setTime(4, Time.valueOf(end.getCheckouthora()));

			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				chavePrimariaGerada = rs.getInt(1);
			}	
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}	
		
		return chavePrimariaGerada;}

	public ArrayList<Hospedagem> listarHospedagem() {
		ArrayList<Hospedagem> hospedagem = new ArrayList<Hospedagem>();
		String SQL = "SELECT * FROM enderecos";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Hospedagem end = new Hospedagem();
				LocalDate DtCheckin = rs.getDate("checkin").toLocalDate();
				LocalTime HrCheckin = rs.getTime("checkin").toLocalTime();
				LocalDate DtCheckout = rs.getDate ("checkout").toLocalDate();
				LocalTime HrCheckout = rs.getTime("checkout").toLocalTime();
		/*	ps.setDate(1, Date.valueOf(end.getCheckindata()));
			ps.setTime(2, Time.valueOf(end.getCheckinhora()));
			ps.setDate(3, Date.valueOf(end.getCheckoutdata()));
			ps.setTime(4, Time.valueOf(end.getCheckouthora()));
			LocalDate Datanascimento = rs.getDate("data_de_nascimento").toLocalDate();*/
		
				end.setCheckindata(DtCheckin);
				end.setCheckinhora(HrCheckin);
				end.setCheckoutdata(DtCheckout);
				end.setCheckouthora(HrCheckout);
				hospedagem.add(end);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
		return hospedagem;
		}
	
	public boolean atualizarHospedagem(Hospedagem end) {
		
		String SQL = "UPDATE hospedagem SET checkin = ?, checkout = ?, WHERE num_quarto = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		int retorno = 0;


		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, Date.valueOf(end.getCheckindata()));
			ps.setTime(2, Time.valueOf(end.getCheckinhora()));
			ps.setDate(3, Date.valueOf(end.getCheckoutdata()));
			ps.setTime(4, Time.valueOf(end.getCheckouthora()));
			

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return retorno != 0;
	}
	
	public boolean removerHospedagem (Hospedagem end) {
		
		String SQL = "DELETE FROM hospedagem SET checkin = ?, checkout = ?, WHERE num_quarto = ?"; // verificar
		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;
		
		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, Date.valueOf(end.getCheckindata()));
			ps.setTime(2, Time.valueOf(end.getCheckinhora()));
			ps.setDate(3, Date.valueOf(end.getCheckoutdata()));
			ps.setTime(4, Time.valueOf(end.getCheckouthora()));

			retorno = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno != 0;
		
	}
}
