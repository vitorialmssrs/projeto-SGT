package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import modelo.Hospede;

public class HospedeDAO {

	private static HospedeDAO instancia;

	public static HospedeDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedeDAO();
		}
		return instancia;
	}

	public int insertHospede(Hospede end) {
		String SQL = "INSERT INTO hospede (primeiro_nome, sobrenome, num_identificacao, data_de_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getNumidentificacao());

			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setInt(5, end.getTelefone());
			ps.setString(6, end.getEmail());

			int ra = ps.executeUpdate();

			if (ra > 0) {
				ResultSet gk = ps.getGeneratedKeys();
				if (gk.next()) {
					chavePrimariaGerada = gk.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return chavePrimariaGerada;
	}

	public ArrayList<Hospede> listarHospede() {

		// ArrayList para armazenar o resultado do select

		ArrayList<Hospede> hospedes = new ArrayList<Hospede>();

		// Comando SQL a ser executado

		String SQL = "SELECT * FROM hospedes";

		// Cria a "ponta de conexão" com o MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Cria o objeto
				Hospede end = new Hospede();

				/*
				 * primeiro_nome, sobrenome, num_identificacao, data_de_nascimento, telefone,
				 * email
				 */

				// Pega os valores de cada coluna do registro
				String PrimeiroNome = rs.getString("primeiro_nome");
				String Sobrenome = rs.getString("sobrenome");
				LocalDate Datanascimento = rs.getDate("data_de_nascimento").toLocalDate();
				int Numidentificacao = rs.getInt("num_identificacao");
				int Telefone = rs.getInt("telefone");
				String Email = rs.getString("email");

				// localdate ==> mais indicado para utilizar
				// LocalTime
				// LocalDateTime
				/*
				 * (Java)LocalTime <-> Time(BD) 
				 * (Java)LocalDateTime <-> DateTime(BD)
				 * (Java)LocalDate <-> Date(BD) 
				 * Se estiver muito dificil usar a conversão,
				 * separar em 3 input, para verificar e converter mais rapido
				 **/

				// seta oa valores no objeto java
				end.setPrimeironome(PrimeiroNome);
				end.setSobrenome(Sobrenome);
				end.setNumidentificacao(Numidentificacao);
				end.setDatanascimento(Datanascimento);
				end.setTelefone(Telefone);
				end.setEmail(Email);

				hospedes.add(end);
				// precisa acrescentar a tela de confimação

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return hospedes;
	}

	public boolean atualizarHospede(Hospede end) {

		/*
		 * primeiro_nome, sobrenome, num_identificacao, data_de_nascimento, telefone,
		 * email
		 */
		// verificar se o WHERE vai finalizar com n°identificação ou id_cliente
		String SQL = "UPDATE hospedes SET primeiro_nome = ?, sobrenome = ?, num_identificacao = ?, data_de_nascimento = ?, telefone = ?, email = ?, WHERE id_cliente = ?";

		// Abre conexão e cria a "ponte de conexão" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setInt(5, end.getTelefone());
			ps.setString(6, end.getEmail());

			retorno = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		// IF Ternário: se o retorno for zero é pra considerar esse valor falso, senão é
		// pra considerar verdadeiro
		return retorno != 0;
	}

	public boolean removerHospede(Hospede end) {

		String SQL = "DELETE FROM hospedes SET primeiro_nome = ?, sobrenome = ?, num_identificacao = ?, data_de_nascimento = ?, telefone = ?, email = ?, WHERE id_cliente = ?"; // verificar
																																														// qual
																																														// sera
																																														// usado
																																														// para
																																														// excluir
																																														// id
																																														// ou
																																														// cpf

		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setInt(5, end.getTelefone());
			ps.setString(6, end.getEmail());

			retorno = ps.executeUpdate();

			/*
			 * int rowsAffected = ps.executeUpdate(); if (rowsAffected > 0) {
			 * con.fecharConexao(); return true;}
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno != 0;
	}
}
