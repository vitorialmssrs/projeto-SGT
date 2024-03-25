package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//(final) CONSTANTE ALGO CONSTANTE QUE NAO PODE MUDAR
//	private sera acessado apenas por dentro do codigo modificador de acesso 
//static consegue estanciar essa variavel de qualquer lugar do código sem ter que estanciar 

	//criação de variavel
	private static final String USERNAME = "root";
	private static final String SENHA = "Aluno";
	private static final String BD = "sgt";
	

	private Connection con; // jdbc
	private static Conexao instancia; // singleton
	
	
	private Conexao () {} // construtor privado 
	/**
	 * Metodo singleton
	 * 
	 * @return instancia
	 */ 
		
	//metodo de aplicação de projeto singleton torna a classe privade que n pode ser usado mais normal 
	public static Conexao getInstancia() {
		
		//verifica se a instancia é nula se n for instanciada ela instancia 
		
		if (instancia == null) {
			
			//só instancia dentro da classe se for nula vai instancia 
			
			instancia = new Conexao();
			
			//e ira retornar se n for nula pula o metodo e retorna 
			} return instancia; 
				
	}
		/**
		 * Metodo que faz a conexão com o MYSQL
		 * 
		 * @return con
		 */
	
	public Connection conectar() {
	 
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+ BD + "?serverTimezone=UTC", USERNAME, SENHA);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} return con; 

		
	}
	
	/**Fecha a conexão com o MySQL
	 * 
	 * 
	 * @return true ou false; dependendo do resultado 
	 */
	public boolean fecharConexao() {
		//executou a funcao (comando) fecha o sistema 
		try {
			con.close(); //chama metodo close que fecha
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false; 
	}
	

}
