package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

import modelo.Hospedagem;
import modelo.Hospede;

public class HospedagemDAO {

	private static HospedagemDAO instancia;

	public static HospedagemDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedagemDAO();
		}
		return instancia;
	}

	public int insertHospedagem(Hospedagem end) {
		String SQL = "INSERT INTO hospedagens (DataEntrada, HoraEntrada, clientes_id_cliente) VALUES (?,?,?)";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, Date.valueOf(end.getDataEntrada()));
			ps.setTime(2, Time.valueOf(end.getHoraEntrada()));
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
		String SQL = "SELECT * FROM hospedagens";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Hospedagem end = new Hospedagem();
				
				int numquarto = rs.getInt("num_quarto");
				LocalDate DataEntrada = rs.getDate("DataEntrada").toLocalDate();
				LocalDate DataSaida = rs.getDate("DataSaida").toLocalDate();
				LocalTime HoraEntrada = rs.getTime("HoraEntrada").toLocalTime();
				LocalTime HoraSaida = rs.getTime("HoraSaida").toLocalTime();

				end.setNumQuarto(numquarto);
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

	
	
	

	public Hospedagem buscarHospedagemPorHospede(Hospede h) {
		Hospedagem hospedagem = null;
		String SQL = "SELECT hospedagens.* FROM hospedagens INNER JOIN clientes ON clientes.id_cliente = hospedagens.clientes_id_cliente WHERE clientes.num_identificacao = ? AND hospedagens.DataSaida IS null ";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setLong(1, h.getNumidentificacao());


			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				hospedagem = new Hospedagem();
				
				Integer numQuarto = rs.getInt("num_quarto");
				LocalDate DataEntrada = rs.getDate("DataEntrada").toLocalDate();
				LocalTime HoraEntrada = rs.getTime("HoraEntrada").toLocalTime();

				hospedagem.setDataEntrada(DataEntrada);
				hospedagem.setHoraEntrada(HoraEntrada);
				hospedagem.setNumQuarto(numQuarto);

	
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
		String SQL = "UPDATE hospedagens SET DataEntrada = ?, DataSaida = ?, HoraEntrada = ?, HoraSaida = ? WHERE num_quarto = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setDate(1, Date.valueOf(end.getDataEntrada()));
			ps.setDate(2, Date.valueOf(end.getDataSaida()));
			ps.setTime(3, Time.valueOf(end.getHoraEntrada()));
			ps.setTime(4, Time.valueOf(end.getHoraSaida()));
			ps.setInt(5, end.getNumQuarto());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno != 0;
	}

	public int removerHospedagem(Hospedagem end) {

		String SQL = "DELETE FROM hospedagens WHERE num_quarto = ?"; // verificar
		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setInt(1, end.getNumQuarto());
			

			retorno = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno;

	}
	
	public int AtualizarCheckOut(Hospedagem end) {
		String SQL = "UPDATE hospedagens SET DataSaida = ?, HoraSaida = ? WHERE num_quarto = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, java.sql.Date.valueOf(end.getDataSaida()));
			ps.setTime(2, java.sql.Time.valueOf(end.getHoraSaida()));
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
}
