package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import modelo.ReservaEspacos;

public class ReservaEspacoDAO implements IReservaEspacoDAO {
	private static ReservaEspacoDAO instancia;
	private ReservaEspacoDAO() {
	}
	public static ReservaEspacoDAO getInstancia() {

		if (instancia == null) {

			instancia = new ReservaEspacoDAO();

		}
		return instancia;
	}
	@Override
	public int inserirReservaEspaco(ReservaEspacos end) {
		String SQL = "INSERT INTO reservas_espacos (id_reservas, dia_horario, id_clientes,espaco_hotel_id_espacos) VALUES (?,?,?,?)";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setTimestamp(1, Timestamp.valueOf(end.getDiahorario()));
			ps.setInt(2, end.getCliente().getIdcliente());
			ps.setInt(3, end.getReserva().getId());

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				chavePrimariaGerada = rs.getInt(1);
			}
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}
	
}
