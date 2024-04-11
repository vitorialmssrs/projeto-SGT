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
import modelo.LimpezaEspacos;
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

public int inserirManutencao (ManutencaoEspacos end) {

	String SQL = "INSERT INTO ManutencaoEspacos (idManutencaoEspacos, tipoManutencao, diaManutencao) VALUES ( ?, ?, ?)";

	//Abre conexao e cria a "ponte de conexao" com o MySQL
	Conexao con = Conexao.getInstancia();
	Connection conBD = con.conectar();

	int chavePrimariaGerada = Integer.MIN_VALUE;
	

	try {
	    PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

	    ps.setString(1,end.getIdManutencaoEspacos());
	    ps.setString(2,end.getTipoManutencao());
	    ps.setDate(5, end.getDiaManutencao());
	    
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
	
	String SQL = "SELECT * FROM ManutencaoEspacos";

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
			String TipoManutencao = rs.getString("TipoManutencao");
			Time DiaManutencao = rs.getTime("DiaManutencao");
					
			// Seta os valores no obj java
			end.setDiaManutencao(null);
			end.setIdManutencaoEspacos(SQL);
			end.setTipoManutencao(SQL);
			
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
	    ArrayList<ManutencaoEspacos> listaManutencaoEspacos = new ArrayList<ManutencaoEspacos>();
	    
	    // Comando SQL para selecionar os dados da tabela LimpezaEspacos
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
	        	manutencaoEspacos.setIdManutencaoEspacos(SQL);
	        	manutencaoEspacos.setTipoManutencao(SQL);
	       
	            
	            listaManutencaoEspacos.add(manutencaoEspacos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return listaManutencaoEspacos;
	}
	
	public boolean atualizarLManutencaoEspacos(ManutencaoEspacos end) {
	    String SQL = "UPDATE ManutencaoEspacos SET idManutencaoEspacos, tipoManutencao, diaManutencao WHERE idManutencaoEspacos = ?";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        
	        ps.setString(1, end.getIdManutencaoEspacos());
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
	

}