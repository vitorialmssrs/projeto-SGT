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
		String SQL = "INSERT INTO clientes (primeiro_nome, sobrenome, num_identificacao, data_de_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

			//inicializa a variavel chave primaria antes de outra operação no banco 
		int chavePrimariaGerada = Integer.MIN_VALUE;

		//incializa um bloco de exceções 
		try {
			//Cria um objeto PreparedStatement chamado ps usando a conexão com o banco de dados (conBD).
			//O método prepareStatement recebe a string SQL (que representa a instrução SQL a ser executada) 
			//e um segundo argumento Statement.RETURN_GENERATED_KEYS é uma constante que informa ao banco de dados para retornar as chaves primárias geradas 
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			//END Define o primeiro parâmetro (?) da instrução SQL com o valor do primeiro nome 
			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setLong(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setString(5, end.getTelefone());
			ps.setString(6, end.getEmail());

			//Executa a instrução SQL (uma operação de inserção) e armazena o número de linhas afetadas na variável ra.
			int ra = ps.executeUpdate();

			if (ra > 0) { 
				
				//Obtém um ResultSet (gk) contendo as chaves primárias geradas pela operação de inserção.
				ResultSet gk = ps.getGeneratedKeys();
				
				if (gk.next()) { 
					
					//Se gk contém uma chave primária, define a variável chavePrimariaGerada com o valor da chave primária.
					chavePrimariaGerada = gk.getInt(1);
				}
			}
			
		} catch (SQLException e) { //Captura qualquer exceção de tipo SQLException que possa ocorrer durante a execução do bloco try.
			
			e.printStackTrace(); //Imprime o rastreamento de pilha da exceção para o console (geralmente usado para depuração).
			
		} finally { //nicia o bloco finally, que será executado independentemente de o bloco try ou catch serem executados.
			
			con.fecharConexao(); //Fecha a conexão com o banco de dados (con).
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
				Long Numidentificacao = rs.getLong("num_identificacao");
				String Telefone = rs.getString("telefone");
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
		String SQL = "UPDATE clientes SET primeiro_nome = ?, sobrenome = ?, num_identificacao = ?, data_de_nascimento = ?, telefone = ?, email = ?, WHERE id_cliente = ?";

		// Abre conexão e cria a "ponte de conexão" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setLong(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setString(5, end.getTelefone());
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

		String SQL = "DELETE FROM clientes SET primeiro_nome = ?, sobrenome = ?, num_identificacao = ?, data_de_nascimento = ?, telefone = ?, email = ?, WHERE id_cliente = ?"; // verificar

		Conexao con = Conexao.getInstancia();

		Connection conBD = con.conectar();

		int retorno = 0;

		try {

			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setLong(3, end.getNumidentificacao());
			ps.setDate(4, Date.valueOf(end.getDatanascimento()));
			ps.setString(5, end.getTelefone());
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
