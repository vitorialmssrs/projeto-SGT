package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import modelo.EspacoHotel;
import visao.EspacosHotel;

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
		/**
		 * Utilizar essa forma de INSERT somente quando a chave primaria Ã©
		 * AUTO_INCREMENT no BD
		 * 
		 */
		public int inserirEspacos(EspacoHotel end) {

			String SQL = "INSERT INTO EspacoHotel (academia, quiosque, salao_festa, quadra_futebol, sala_jogos, quadra_volei, SPA, brinquedoteca, piscina ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			//Abre conexao e cria a "ponte de conexao" com o MySQL
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();

			int chavePrimariaGerada = Integer.MIN_VALUE;

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, end.getAcademia());
				ps.setString(1, end.getQuiosque());
				ps.setString(1, end.getSalaoFesta());
				ps.setString(1, end.getQuadraFutebol());
				ps.setString(1, end.getSalaJogos());
				ps.setString(1, end.getQuadraVolei());
				ps.setString(1, end.getSPA());
				ps.setString(1, end.getBrinquedoteca());
				ps.setString(1, end.getPiscina());
				
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
		
		public ArrayList<EspacoHotel> listarEspacos() {

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

	
		public boolean atualizarEspaco(EspacoHotel end) {
			
			String SQL = "UPDATE espacos SET academia = ?, quiosque = ?, salao_festa = ?, quadra_futebol = ?, sala_jogos = ?, quadra_volei = ?, SPA = ?, brinquedoteca = ?, piscina = ?   WHERE academia = ?, quiosque = ?, salao_festa = ?, quadra_futebol = ?, sala_jogos = ?, quadra_volei = ?, SPA = ?, brinquedoteca = ?, piscina = ? "; 

			
			//Cria a "ponta de conexão" com o MYSQL com o padrão singleton
			Conexao con = Conexao.getInstancia(); // instancia 
			Connection conBD = con.conectar(); // cria a ponte
			
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				
				//Setando os valores
				
				ps.setString(1, end.getAcademia());
				ps.setString(1, end.getQuiosque());
				ps.setString(1, end.getSalaoFesta());
				ps.setString(1, end.getQuadraFutebol());
				ps.setString(1, end.getSalaJogos());
				ps.setString(1, end.getQuadraVolei());
				ps.setString(1, end.getSPA());
				ps.setString(1, end.getBrinquedoteca());
				ps.setString(1, end.getPiscina());
				
				retorno = ps.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				
			}
			
			
			return retorno != 0;
		}

		@Override
		public boolean removerEspaco(EspacoHotel end) {
			
			String SQL = "SELECT * FROM espaco WHERE id_espaco = ?";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				 
				ps.setString(1, Academia);
				ps.setString(2, Quiosque);
				ps.setString(3, Salaofesta);
				ps.setString(4, Quadrafutebol);
				ps.setString(5, Salajogos);
				ps.setString(6, Quadravolei);
				ps.setString(7, SPA);
				ps.setString(8, Brinquedoteca);
				ps.setString(9, Piscina);
				
			} catch (Exception e) {
				
			} finally {
				
			}
			
				return false;
		
		}
		
			
			
			


		
	}
	
	


