package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			String SQL = "INSERT INTO funcionarios (CPF, PrimeiroNome, Sobrenome, data_de_nascimento, email, telefone, cep, numero, usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				
				ps.setString(1, end.getPrimeiroNome());
				ps.setString(2, end.getSobrenome);
			}
			
			
			return 0;
			
		}
		
		public ArrayList <Funcionario> listarFuncionario(){
			
			ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
			
			String SQL = "SELECT * FROM funcionario";
			
			
			public boolean atualizarFuncionario(Funcionario end){}
				
			
			
			//Comando SQL a ser executado
			String SQL = "UPTADE funcionario Set PrimeiroNome = ?";
			
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				//ps.setString((1, end.getPrimeiroNome());
				
				retorno = ps.executeUpdate();
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Funcionario end = new Funcionario();
					
					String CPF = rs.getString("CPF");
					String ID = rs.getString("ID");
				

					//end.setCPF(CPF);
					//end.setID(ID);
					
					
					funcionario.add(end);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				con.fecharConexao();
			}
			
			
			 
			 return funcionario;	
		}
		
		
}
