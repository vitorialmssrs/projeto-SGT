package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String SQL = "INSERT INTO hospedagem (DataEntrada, HoraEntrada, clientes_id_cliente) VALUES (?,?,?)";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, java.sql.Date.valueOf(end.getDataEntrada()));
			ps.setTime(2, java.sql.Time.valueOf(end.getHoraEntrada()));
			ps.setInt(3, end.getHospede().getIdcliente());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<Hospedagem> listarHospedagem() {
		ArrayList<Hospedagem> hospedagem = new ArrayList<Hospedagem>();
		String SQL = "SELECT * FROM hospedagem";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Hospedagem end = new Hospedagem();

				LocalDate DataEntrada = rs.getDate("DataEntrada").toLocalDate();
				LocalDate DataSaida = rs.getDate("DataSaida").toLocalDate();
				LocalTime HoraEntrada = rs.getTime("HoraEntrada").toLocalTime();
				LocalTime HoraSaida = rs.getTime("HoraSaida").toLocalTime();

				end.setDataEntrada(DataEntrada);
				end.setDataSaida(DataSaida);
				end.setHoraEntrada(HoraEntrada);
				end.setHoraSaida(HoraSaida);

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
		// DataEntrada,DataSaida,HoraEntrada,HoraSaida
		String SQL = "UPDATE hospedagem SET DataEntrada = ?, DataSaida = ?, HoraEntrada = ?, HoraSaida = ? WHERE num_quarto = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, java.sql.Date.valueOf(end.getDataEntrada()));
			ps.setDate(2, java.sql.Date.valueOf(end.getDataSaida()));
			ps.setTime(3, java.sql.Time.valueOf(end.getHoraEntrada()));
			ps.setTime(4, java.sql.Time.valueOf(end.getHoraSaida()));

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno != 0;
	}

	public boolean removerHospedagem(Hospedagem end) {

		String SQL = "DELETE FROM hospedagem SET DataEntrada = ?, DataSaida = ?, HoraEntrada = ?, HoraSaida = ? WHERE num_quarto = ?"; // verificar
		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, java.sql.Date.valueOf(end.getDataEntrada()));
			ps.setDate(2, java.sql.Date.valueOf(end.getDataSaida()));
			ps.setTime(3, java.sql.Time.valueOf(end.getHoraEntrada()));
			ps.setTime(4, java.sql.Time.valueOf(end.getHoraSaida()));

			retorno = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno != 0;

	}
}
