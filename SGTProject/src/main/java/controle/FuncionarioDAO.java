package controle;

import java.sql.Connection;
import java.util.ArrayList;

//import controle.ControleFuncionario.IFuncionarioDAO;

public class FuncionarioDAO {

	private static FuncionarioDAO instancia;
	
	private FuncionarioDAO() {
	}
	
		
		public static FuncionarioDAO getInstancia() {
		
		if(instancia == null) {
			
			instancia = new FuncionarioDAO();
			
		}
		return instancia;
		}
		
		public int inserirFuncionario(Funcionario end) {
			String SQL = "INSERT INTO funcionarios (CPF, ID) VALUES (?, ?)";
			
			return 0;
			
		}
		
		public ArrayList <Funcionario> listarFuncionario(){
			
			ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
			
			String SQL = "SELECT * FROM funcionario";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			 
	        return funcionario;	
		}
		
		
}
