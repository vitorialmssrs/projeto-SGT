package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import modelo.EspacoHotel;
import modelo.ManutencaoEspacos;

	public class ManutencaoEspacosDAO implements IManutencaoEspacoDAO{
	//criar o DAO e fazer a conexão com banco de dados 
		/**
		 * DAO = Data access object objeto de acesso a dados
		 * 
		 * Serve para trocar dados com a tabela Endereco
		 **/

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
	private static ManutencaoEspacosDAO instancia;

/*
 * Construtor privado (padrao Singleton)
 */
	private ManutencaoEspacosDAO() {
}

/*
 * Metodo para instanciar (padrao Singleton)
 */

	public static ManutencaoEspacosDAO getInstancia() {

	if (instancia == null) {
		instancia = new ManutencaoEspacosDAO();
	}
	return instancia;
}

	public int inserirManutencao (ManutencaoEspacos manut) {

	String SQL =  "INSERT INTO manutencao_espaco ( tipo_Manutencao, dia, hora_inicio, hora_final, espacos_hotel_id_espacos, funcionarios_id_funcionario, descricaomanutencao ) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

	//Abre conexao e cria a "ponte de conexao" com o MySQL
	Conexao con = Conexao.getInstancia();
	Connection conBD = con.conectar();

	int chavePrimariaGerada = Integer.MIN_VALUE;
	

	try {
	    PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

	    
	    
	    ps.setString(1,manut.getTipoManutencao());
	    ps.setDate(2, Date.valueOf(manut.getDiaManutencao()));
	    ps.setTime(3, Time.valueOf(manut.getHoraInicio()));
	    ps.setTime(4,Time.valueOf( manut.getHoraFinal()));
	    ps.setInt(5, manut.getEspacos().getId());
	    ps.setInt(6, manut.getFuncionario().getIdFuncionario());
	    ps.setString(7,manut.getDescricao());
	    
	    
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
	
	public ArrayList<ManutencaoEspacos> inserirManutencao() {

	// Arraylist para armazenar resultado do select
	
	ArrayList<ManutencaoEspacos> manutencao = new ArrayList<ManutencaoEspacos>();

	// Comando SQL a ser executado
	
	String SQL = "INSERT INTO ManutencaoEspacos (idManutencaoEspacos, tipo_Manutencao, diaManutencao, hora_inicio, hora_final ) VALUES ( ?, ?, ?, ?, ?)";

	// Cria a "ponte de conexao" com MYSQL
	
	Conexao con = Conexao.getInstancia();
	Connection conBD = con.conectar();

	try {
		PreparedStatement ps = conBD.prepareStatement(SQL);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			
			// Criar objeto
			ManutencaoEspacos end = new ManutencaoEspacos();

			// Pega os valores de cada coluna do registro
			Integer idManutencaoEspacos = rs.getInt("idManutencaoEspacos");
			String TipoManutencao = rs.getString("tipoManutencao");
			Date DiaManutencao = rs.getDate("DiaManutencao");
			Time horaIncio = rs.getTime("hora_inicio");
			Time horaFinal = rs.getTime("hora_final");
					
			// Seta os valores no obj java
			end.setTipoManutencao(SQL);
			end.setDiaManutencao(null);
			end.setHoraInicio(null);
			end.setHoraFinal(null);
			end.setFuncionario(null);
		
			
			// Adiciona obj no arraylist
			manutencao.add(end); 

		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		con.fecharConexao();
	}

	 return manutencao; 
}

	
	public ArrayList<ManutencaoEspacos> listarManutencaoEspacos() {
		return null;
	}
	  //  ArrayList<ManutencaoEspacos> listaManutencaoEspacos = new ArrayList<ManutencaoEspacos>();
	    
	 /*   // Comando SQL para selecionar os dados da tabela LimpezaEspacos
	    String SQL = "SELECT * FROM ManutencaoEspacos";
	    
	    // Cria a "ponte de conexão" com o banco de dados MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	        	ManutencaoEspacos manutencaoEspacos = new ManutencaoEspacos();
	        	manutencaoEspacos.setDiaManutencao(null);
	        	manutencaoEspacos.set
	        	manutencaoEspacos.setTipoManutencao(SQL);
	       
	            
	            listaManutencaoEspacos.add(manutencaoEspacos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return listaManutencaoEspacos;
	}*/

	@Override
	public boolean atualizarLManutencaoEspacos(ManutencaoEspacos end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerManutencaoEspacos(ManutencaoEspacos end) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*public boolean atualizarLManutencaoEspacos(ManutencaoEspacos end) {
	    String SQL = "UPDATE ManutencaoEspacos SET idManutencaoEspacos = ?, tipoManutencao = ?, diaManutencao = ? WHERE idManutencaoEspacos = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setInt(1, end.getIdManutencaoEspacos());
	        ps.setDate(2, end.getDiaManutencao());
	        ps.setString(3, end.getTipoManutencao());

	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return retorno != 0;
	}
	
	public boolean removerManutencaoEspacos(ManutencaoEspacos end) {
	    String SQL = "DELETE FROM ManutencaoEspacos WHERE idManutencaoEspacos = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setInt(1, end.getIdManutencaoEspacos());
	        
	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return retorno != 0;
	}


	*/

}