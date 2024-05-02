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
		String SQL = "INSERT INTO clientes (primeiro_nome, sobrenome, num_identificacao, data_de_nascimento, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setString(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setString(5, end.getTelefone());
			ps.setString(6, end.getEmail());
			ps.setInt(7, end.getSenha());

			int ra = ps.executeUpdate();

			if (ra > 0) { 
				
				//Obtém um ResultSet (gk) contendo as chaves primárias geradas pela operação de inserção.
				ResultSet gk = ps.getGeneratedKeys();
				
				if (gk.next()) { 
					
					//Se gk contém uma chave primária, define a variável chavePrimariaGerada com o valor da chave primária.
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

		String SQL = "SELECT * FROM clientes";

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
				String Numidentificacao = rs.getString("num_identificacao");
				String Telefone = rs.getString("telefone");
				String Email = rs.getString("email");
				Integer senha = rs.getInt("senha");

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
				end.setSenha(senha);

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

	public boolean atualizarHospedeporIdentificacao(String numidentificacao, Hospede atualizarHospede) {

		String SQL = "UPDATE clientes SET primeiro_nome = ?, sobrenome = ?, data_de_nascimento = ?, telefone = ?, email = ?, senha = ?, WHERE num_identificacao = ?";

		// Abre conexão e cria a "ponte de conexão" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int rowsAffected = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, atualizarHospede.getPrimeironome());
			ps.setString(2, atualizarHospede.getSobrenome());
			ps.setDate(3, Date.valueOf(atualizarHospede.getDatanascimento()));
			ps.setString(4, atualizarHospede.getTelefone());
			ps.setString(5, atualizarHospede.getEmail());
			ps.setInt(6, atualizarHospede.getSenha());
			ps.setString(7, atualizarHospede.getNumidentificacao());
			
			rowsAffected = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return rowsAffected > 0;
	}

	public int removerHospede(String numidentificacao, Integer senhai) {
		String SQL = "DELETE FROM clientes WHERE num_identificacao = ? AND senha = ?"; // verificar

		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, numidentificacao);
			ps.setInt(2, senhai);

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
		return retorno;
	}
	
	public Hospede buscarHospedePorCpf(String numidentificacao) {
		String SQL = "SELECT primeiro_nome, sobrenome, data_de_nascimento FROM clientes WHERE num_identificacao = ?"; // verificar

		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		Hospede hospede = null;
		
		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, numidentificacao);
			

			ResultSet retorno = ps.executeQuery();
			
			while (retorno.next()) {
				String pm = retorno.getString("primeiro_nome");
				String sob = retorno.getString("sobrenome");
				String dn = retorno.getString("data_de_nascimento");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return hospede;
	}
}
