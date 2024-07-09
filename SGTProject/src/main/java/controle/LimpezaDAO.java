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
import modelo.ManutencaoEspacos;

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
	
	public int inserirLimpeza(LimpezaEspacos limp) {

		String SQL = "INSERT INTO limpeza_espaco ( tipolimpeza, horarioinicio, horariofinal, dia, espacos_hotel_id_espacos, funcionarios_id_funcionario, descricao_Limpeza) VALUES (?, ?, ?, ?, ?, ?, ?)";

		//Abre conexao e cria a "ponte de conexao" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
		    PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
		    
		    ps.setString(1,limp.getTipoManutencao());
		    ps.setTime(2, Time.valueOf(limp.getHoraInicio()));
		    ps.setTime(3,Time.valueOf( limp.getHoraFinal()));	    
		    ps.setDate(4, Date.valueOf(limp.getDiaManutencao()));
		    ps.setInt(5, limp.getEspacos().getId());
		    ps.setInt(6, limp.getFuncionario().getIdFuncionario());
		    ps.setString(7,limp.getDescricao());
		    
		    
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
		
		String SQL = "INSERT INTO limpeza_espaco (idManutencaoEspacos, tipo_Manutencao, diaManutencao, hora_inicio, hora_final ) VALUES ( ?, ?, ?, ?, ?)";

		// Cria a "ponte de conexao" com MYSQL
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				// Criar objeto
				
				LimpezaEspacos limp = new LimpezaEspacos();

				// Pega os valores de cada coluna do registro
				Integer idManutencaoEspacos = rs.getInt("idManutencaoEspacos");
				String TipoManutencao = rs.getString("tipoManutencao");
				Date DiaManutencao = rs.getDate("DiaManutencao");
				Time horaIncio = rs.getTime("hora_inicio");
				Time horaFinal = rs.getTime("hora_final");
						
				// Seta os valores no obj java
				limp.setTipoManutencao(SQL);
				limp.setDiaManutencao(null);
				limp.setHoraInicio(null);
				limp.setHoraFinal(null);
				limp.setFuncionario(null);
			
				
				// Adiciona obj no arraylist
				limpeza.add(limp); 
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
	    String SQL = "SELECT * FROM limpeza_espaco";
	    
	    // Cria a "ponte de conexão" com o banco de dados MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            LimpezaEspacos limpezaEspacos = new LimpezaEspacos();
	            
	            limpezaEspacos.setTipolimpeza(rs.getString("tipolimpeza"));
	            limpezaEspacos.setHorarioinicio(rs.getTime("horarioinicio"));
	            limpezaEspacos.setHorariofinal(rs.getTime("horariofinal"));
	            limpezaEspacos.setDia(rs.getDate("dia"));
	            
	          /*  limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setHoraInicio(rs.setDate());
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));
	            limpezaEspacos.setTipoManutencao(rs.getString("tipoManutencao"));*/
	            
	            
	            listaLimpezaEspacos.add(limpezaEspacos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return listaLimpezaEspacos;
	}

	
	public boolean atualizarLimpezaEspacos(LimpezaEspacos limp) {
	    String SQL = "UPDATE limpeza_espaco SET tipolimpeza = ?, horarioinicio = ?, horariofinal = ?, dia = ? WHERE idlimpeza = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setString(1,limp.getTipoManutencao());
		    ps.setTime(2, Time.valueOf(limp.getHoraInicio()));
		    ps.setTime(3,Time.valueOf( limp.getHoraFinal()));	    
		    ps.setDate(4, Date.valueOf(limp.getDiaManutencao()));
		    ps.setInt(5, limp.getEspacos().getId());
		    ps.setInt(6, limp.getFuncionario().getIdFuncionario());
		    ps.setString(7,limp.getDescricao());
	        
	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return retorno != 0;
	}

	public boolean removerLimpezaEspacos(LimpezaEspacos end) {
	    String SQL = "DELETE FROM limpeza_espaco WHERE idlimpeza = ?";
	    
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
