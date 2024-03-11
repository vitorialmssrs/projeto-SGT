package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

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
		 * Variavel padrao Singleton
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

			String SQL = "INSERT INTO EspacoHotel (academia, quiosque, salao_festa, quadra_futebol, sala_jogos, quadra_volei, SPA, brinquedoteca, piscina ) VALUES (?)";

			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();

			int chavePrimariaGerada = Integer.MIN_VALUE;

			try {
				PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, end.getAcademia());
				ps.setString(1, end.getQuiosque());
				ps.setString(1, end.getSalao_festa());
				ps.setString(1, end.getQuadra_futebol());
				ps.setString(1, end.getSala_jogos());
				ps.setString(1, end.getQuadra_volei());
				ps.setString(1, end.getSPA());
				ps.setString(1, end.getBrinquedoteca());
				ps.setString(1, end.getPiscina());
				
				
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					chavePrimariaGerada = rs.getInt(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				con.fecharConexao();
			}

			return chavePrimariaGerada;

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
					String quadra_Futebol = rs.getString("Quadra de Futebol");
					String quadra_volei = rs.getString("Quadra de vôlei");
					String quiosque = rs.getString("Quiosque");
					String sala_jogos = rs.getString("Sala de jogos");
					String salao_festa = rs.getString("Salão de festas");
					String spa = rs.getString("SPA");
					
				

					
					// Seta os valores no obj java
					
					end.setAcademia(academia);
					end.setBrinquedoteca(brinquedoteca);
					end.setPiscina(piscina);
					end.setQuadra_futebol(quadra_Futebol);
					end.setQuadra_volei(quadra_volei);
					end.setQuiosque(quiosque);
					end.setSala_jogos(sala_jogos);
					end.setSalao_festa(salao_festa);
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

		
	}
	


