package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

import modelo.LimpezaEspacos;

public class LimpezaDAO implements ILimpezaDAO {
	
	
	private static LimpezaDAO instancia;
	
	private LimpezaDAO() {
		
	}
	
	public static LimpezaDAO getInstancia() {

		if (instancia == null) {
			instancia = new LimpezaDAO();
		}
		return instancia;
	}
	
	public int inserirLimpeza(LimpezaEspacos end) {

		String SQL = "INSERT INTO LimpezaEspacos (idlimpeza, tipolimpeza, horarioinicio, horariofinal, dia) VALUES (?, ?, ?, ?, ?)";

		//Abre conexao e cria a "ponte de conexao" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		

		try {
		    PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

		    ps.setInt(1,end.getIdlimpeza());
		    ps.setString(2,end.getTipolimpeza());
		    ps.setTime(3,end.getHorarioinicio());
		    ps.setTime(4, end.getHorariofinal());
		    ps.setDate(5, end.getDia());
		    
		    // Executa a consulta
		    ps.executeUpdate(); 
		    
		    // Obtém as chaves primárias geradas
		    ResultSet generatedKeys = ps.getGeneratedKeys();
		    if (generatedKeys.next()) {
		        chavePrimariaGerada = generatedKeys.getInt(1);
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    con.fecharConexao();
		}

		return chavePrimariaGerada;


}
	public ArrayList<LimpezaEspacos> inserirLimpeza() {

		// Arraylist para armazenar resultado do select
		
		ArrayList<LimpezaEspacos> limpeza = new ArrayList<LimpezaEspacos>();

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
				
				LimpezaEspacos end = new LimpezaEspacos();

				// Pega os valores de cada coluna do registro
				
				Integer idlimpeza = rs.getInt("idlimpeza");
				String tipolimpeza = rs.getString("tipolimpeza");
				Time horarioinicio = rs.getTime("horarioinicio");
				Time horariofinal = rs.getTime("horariofinal");
				Date dia = rs.getDate("dia");
				
			

				
				// Seta os valores no obj java
	
				end.setIdlimpeza(idlimpeza);
				end.setTipolimpeza(tipolimpeza);
				end.setHorarioinicio(horarioinicio);
				end.setHorariofinal(horariofinal);
				end.setDia(dia);
				
				
				// Adiciona obj no arraylist
				limpeza.add(end); 

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		 return limpeza; 
	}
	
	public ArrayList<LimpezaEspacos> listarLimpezaEspacos() {
	    ArrayList<LimpezaEspacos> listaLimpezaEspacos = new ArrayList<LimpezaEspacos>();
	    
	    // Comando SQL para selecionar os dados da tabela LimpezaEspacos
	    String SQL = "SELECT * FROM LimpezaEspacos";
	    
	    // Cria a "ponte de conexão" com o banco de dados MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            LimpezaEspacos limpezaEspacos = new LimpezaEspacos();
	            limpezaEspacos.setIdlimpeza(rs.getInt("idlimpeza"));
	            limpezaEspacos.setTipolimpeza(rs.getString("tipolimpeza"));
	            limpezaEspacos.setHorarioinicio(rs.getTime("horarioinicio"));
	            limpezaEspacos.setHorariofinal(rs.getTime("horariofinal"));
	            limpezaEspacos.setDia(rs.getDate("dia"));
	            
	            listaLimpezaEspacos.add(limpezaEspacos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return listaLimpezaEspacos;
	}

	
	public boolean atualizarLimpezaEspacos(LimpezaEspacos end) {
	    String SQL = "UPDATE LimpezaEspacos SET tipolimpeza = ?, horarioinicio = ?, horariofinal = ?, dia = ? WHERE idlimpeza = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setString(1, end.getTipolimpeza());
	        ps.setTime(2, end.getHorarioinicio());
	        ps.setTime(3, end.getHorariofinal());
	        ps.setDate(4, end.getDia());
	        ps.setInt(5, end.getIdlimpeza());
	        
	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return retorno != 0;
	}

	public boolean removerLimpezaEspacos(LimpezaEspacos end) {
	    String SQL = "DELETE FROM LimpezaEspacos WHERE idlimpeza = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setInt(1, end.getIdlimpeza());
	        
	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return retorno != 0;
	}

	
}
