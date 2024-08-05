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

public class HospedeDAO implements IHospedeDao{

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
			ps.setLong(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setString(5, end.getTelefone());
			ps.setString(6, end.getEmail());
			ps.setInt(7, end.getSenha());

			ps.executeUpdate();
			ResultSet gk = ps.getGeneratedKeys();
			if (gk.next()) { 
					
				chavePrimariaGerada = gk.getInt(1);
				
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

				Integer idcliente = rs.getInt("id_cliente");
				String PrimeiroNome = rs.getString("primeiro_nome");
				String Sobrenome = rs.getString("sobrenome");
				LocalDate Datanascimento = rs.getDate("data_de_nascimento").toLocalDate();
				Long Numidentificacao = rs.getLong("num_identificacao");
				String Telefone = rs.getString("telefone");
				String Email = rs.getString("email");
				Integer senha = rs.getInt("senha");
 
				// seta oa valores no objeto java
				end.setIdcliente(idcliente);
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

	public int atualizarHospedeporIdentificacao(Hospede atualizarHospede) {

		// verificar se o WHERE vai finalizar com n°identificação ou id_cliente
		String SQL = "UPDATE clientes SET primeiro_nome = ?, sobrenome = ?, num_identificacao = ?, data_de_nascimento = ?, telefone = ?, email = ? WHERE senha = ? AND id_cliente = ?";

		// Abre conexão e cria a "ponte de conexão" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int rowsAffected = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, atualizarHospede.getPrimeironome());
			ps.setString(2, atualizarHospede.getSobrenome());
			ps.setLong(3, atualizarHospede.getNumidentificacao());
			ps.setDate(4, Date.valueOf(atualizarHospede.getDatanascimento()));
			ps.setString(5, atualizarHospede.getTelefone());
			ps.setString(6, atualizarHospede.getEmail());
			ps.setInt(7, atualizarHospede.getSenha());
			ps.setInt(8, atualizarHospede.getIdcliente());
			
			rowsAffected = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return rowsAffected;
	}

	public int removerHospede(Long numidentificacaoL, Integer senhai) {
		String SQL = "DELETE FROM clientes WHERE num_identificacao = ? AND senha = ?"; // verificar

		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setLong(1, numidentificacaoL);
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
	

	public Hospede buscarHospedePorCpf(long cpf) {
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		Hospede h = null;
		
		String query = "SELECT * FROM clientes WHERE num_identificacao = ?";
		
		try {
			PreparedStatement ps = conBD.prepareStatement(query);
			ps.setLong(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				h = new Hospede();

				
				String PrimeiroNome = rs.getString("primeiro_nome");
				String Sobrenome = rs.getString("sobrenome");
				LocalDate Datanascimento = rs.getDate("data_de_nascimento").toLocalDate();
				Long Numidentificacao = rs.getLong("num_identificacao");
				String Telefone = rs.getString("telefone");
				String Email = rs.getString("email");
				Integer senha = rs.getInt("senha");
				Integer idCliente = rs.getInt("id_cliente");

				h.setPrimeironome(PrimeiroNome);
				h.setSobrenome(Sobrenome);
				h.setNumidentificacao(Numidentificacao);
				h.setDatanascimento(Datanascimento);
				h.setTelefone(Telefone);
				h.setEmail(Email);
				h.setSenha(senha);
				h.setIdcliente(idCliente);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return h;
	}

	@Override
	public boolean atualizarHospede(Hospede end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerHospede(Hospede end) {
		// TODO Auto-generated method stub
		return false;
	}
}
