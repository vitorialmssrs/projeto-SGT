package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import modelo.EspacoHotel;


//criar o DAO para segunda e fazer a conexão com banco de dados 
	/**
	 * DAO = Data access object objeto de acesso a dados
	 * 
	 * Serve para trocar dados com a tabela Endereco
	 *
	 */
	public class EspacosDAO implements IEspacosDAO {
		
		/*
		 * Variavel padrao Singleton serve para somente criar a variavel na memoria ram uma unica vez
		 * é colocado uma variavel da propria classe 
		 * torna o construtor privado para n ser mais instanciada 
		 * e para utilizar é usado o metodo getInstancia 
		 * 
		 * a primeira vez que for instanciada sera 
		 * depois só retorna o mesmo valor na memoria 
		 * e precisa ter no DAO e Conexao 
		 * precisa ter o try catch e finaly
		 * 
		 */
		private static EspacosDAO instancia;

		/*
		 * Construtor privado (padrao Singleton)
		 */
		private EspacosDAO() {
		}

		/*
		 * Metodo para instanciar (padrao Singleton)
		 */

		public static EspacosDAO getInstancia() {

			if (instancia == null) {
				instancia = new EspacosDAO();
			}
			return instancia;
		}
		
		//array para listar as informações para espaços no combo box de manutenção que está no banco de dados
		public ArrayList<EspacoHotel> listarEspacos() {

			// Arraylist para armazenar resultado do select
			ArrayList<EspacoHotel> espacos = new ArrayList<EspacoHotel>();

			// Comando SQL a ser executado
			String SQL = "SELECT * FROM espacos_hotel";

			// Cria a "ponte de conexao" com MYSQL
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					// Criar objeto
					EspacoHotel end = new EspacoHotel();

					// Pega os valores de cada coluna do registro
					
					int id_espacos = rs.getInt("id_espacos");
					String nome_espaco = rs.getString("nome_espaco");
					LocalDate dia_semana_abertura = rs.getDate("dia_semana_abertura").toLocalDate();
					LocalDate dia_semana_fechamento = rs.getDate("dia_semana_fechamento").toLocalDate();
					LocalTime horario_abertura = rs.getTime("horario_abertura").toLocalTime();
					LocalTime horario_fechamento = rs.getTime("horario_fechamento").toLocalTime();
					int capacidade = rs.getInt("capacidade");
					// Seta os valores no obj java
					
					end.setId(id_espacos);
					end.setNome(nome_espaco);
					end.setCapacidade(capacidade);
					end.setDataAbertura(dia_semana_abertura);
					end.setDataFechamento(dia_semana_fechamento);
					end.setHorarioAbertura(horario_abertura);
					end.setHorarioFechamento(horario_fechamento);
				

					// Adiciona obj no arraylist
					espacos.add(end);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}

			return espacos;
		}

		@Override
		public int inserirEspacos(EspacoHotel end) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ArrayList<EspacoHotel> insertEspacos2() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean atualizarEspaco(EspacoHotel end) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removerEspaco(EspacoHotel end) {
			// TODO Auto-generated method stub
			return false;
		}

		
		/**
		 * Utilizar essa forma de INSERT somente quando a chave primaria Ã©
		 * AUTO_INCREMENT no BD
		 * 
		 *//*
		public int inserirEspacos(EspacoHotel end) {

			String SQL = "INSERT INTO EspacoHotel (academia, quiosque, salao_festa, quadra_futebol, sala_jogos, quadra_volei, SPA, brinquedoteca, piscina ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			//Abre conexao e cria a "ponte de conexao" com o MySQL
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();

			int chavePrimariaGerada = Integer.MIN_VALUE;

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, end.getAcademia());
				ps.setString(2, end.getQuiosque());
				ps.setString(3, end.getSalaoFesta());
				ps.setString(4, end.getQuadraFutebol());
				ps.setString(5, end.getSalaJogos());
				ps.setString(6, end.getQuadraVolei());
				ps.setString(7, end.getSPA());
				ps.setString(8, end.getBrinquedoteca());
				ps.setString(9, end.getPiscina());
				
				//Executa sem esperar retorno do BD
				return ps.executeUpdate(); 

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}

			return 0;

		}

		
		public ArrayList<EspacoHotel> insertEspacos2() {

			// Arraylist para armazenar resultado do select
			
			ArrayList<EspacoHotel> espacos = new ArrayList<EspacoHotel>();

			// Comando SQL a ser executado
			
			String SQL = "SELECT * FROM espacos";

			// Cria a "ponte de conexao" com MYSQL
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					
					// Criar objeto
					
					EspacoHotel end = new EspacoHotel();

					// Pega os valores de cada coluna do registro
					
					String academia = rs.getString("Academia");
					String brinquedoteca = rs.getString("brinquedoteca");
					String piscina = rs.getString("Piscina");
					String quadrafutebol = rs.getString("Quadra de Futebol");
					String quadravolei = rs.getString("Quadra de vôlei");
					String quiosque = rs.getString("Quiosque");
					String salajogos = rs.getString("Sala de jogos");
					String salaofesta = rs.getString("Salão de festas");
					String spa = rs.getString("SPA");
					
				

					
					// Seta os valores no obj java
					
					end.setAcademia(academia);
					end.setBrinquedoteca(brinquedoteca);
					end.setPiscina(piscina);
					end.setQuadraFutebol(quadrafutebol);
					end.setQuadraVolei(quadravolei);
					end.setQuiosque(quiosque);
					end.setSalaJogos(salajogos);
					end.setSalaoFesta(salaofesta);
					end.setSPA(spa);
					
					// Adiciona obj no arraylist
					espacos.add(end);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}

			return espacos;
		}
		*/
	
	/*
		public boolean atualizarEspaco(EspacoHotel end) {
			//arrumar a sintese de update or ou end
			String SQL = "UPDATE espacos SET academia = ?, quiosque = ?, salao_festa = ?, quadra_futebol = ?, sala_jogos = ?, quadra_volei = ?, SPA = ?, brinquedoteca = ?, piscina = ?   WHERE academia = ?, quiosque = ?, salao_festa = ?, quadra_futebol = ?, sala_jogos = ?, quadra_volei = ?, SPA = ?, brinquedoteca = ?, piscina = ? "; 

			
			//Cria a "ponta de conexão" com o MYSQL com o padrão singleton
			Conexao con = Conexao.getInstancia(); // instancia 
			Connection conBD = con.conectar(); // cria a ponte
			
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				
				//Setando os valores
				
				ps.setString(1, end.getAcademia());
				ps.setString(2, end.getQuiosque());
				ps.setString(3, end.getSalaoFesta());
				ps.setString(4, end.getQuadraFutebol());
				ps.setString(5, end.getSalaJogos());
				ps.setString(6, end.getQuadraVolei());
				ps.setString(7, end.getSPA());
				ps.setString(8, end.getBrinquedoteca());
				ps.setString(9, end.getPiscina());
				
				retorno = ps.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				
			}
			
			return retorno != 0;
		}

		
		public boolean removerEspaco(EspacoHotel end) {
			
			String SQL = "SELECT * FROM espaco WHERE id_espaco = ?";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				 
				ps.setString(1, end.getAcademia());
				ps.setString(2, end.getQuiosque());
				ps.setString(3, end.getSalaoFesta());
				ps.setString(4, end.getQuadraFutebol());
				ps.setString(5, end.getSalaJogos());
				ps.setString(6, end.getQuadraVolei());
				ps.setString(7, end.getSPA());
				ps.setString(8, end.getBrinquedoteca());
				ps.setString(9, end.getPiscina());
				
				retorno = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}
			
			return retorno != 0;
		
		}

		*/
	}
	
	


