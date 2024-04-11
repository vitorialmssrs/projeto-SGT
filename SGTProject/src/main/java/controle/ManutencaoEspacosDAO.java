package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}