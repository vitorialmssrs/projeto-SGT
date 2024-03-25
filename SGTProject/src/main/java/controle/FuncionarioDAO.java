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
			
			/*
			 * num_identificacao, primeiro_nome, sobrenome, data_nascimento, telefone , cep, num_casa, id_usuarios
			 * Ver se realmente o campo CPF e Email serão necessarios, além dos campos rua e bairro
			 */
			String SQL = "INSERT INTO funcionarios (num_identificacao, primeiro_nome, sobrenome, data_nascimento, telefone, cep, num_casa, id_usuarios) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				
				ps.setInt(1, end.getnum_identificacao());
				ps.setString(2, end.getPrimeiroNome());
				ps.setString(3, end.getSobrenome());
				ps.setDate(4, end.getData_nascimento());
				//ps.setString(5, end.getEmail());
				ps.setInt(5, end.getTelefone());
				ps.setInt(6, end.getCep());
				ps.setInt(7, end.getNumero());
				ps.setInt(8, end.getid_usuarios());
				
				return ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			
			return 0;	
		}
		
		public ArrayList <Funcionario> listarFuncionario(){
			
			ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
			
			String SQL = "SELECT * FROM funcionarios";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
			
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Funcionario f = new Funcionario();
					
			        f.setCPF(rs.getInt("num_identificacao"));
					f.setPrimeiroNome(rs.getString("PrimeiroNome"));
					f.setSobrenome(rs.getString("Sobrenome"));
					f.setData_nascimento(rs.getDate("data_de_nascimento"));
				//	f.setEmail(rs.getString("Email"));
					f.setTelefone(rs.getInt("Telefone"));
					f.setCep(rs.getInt("Cep"));
					f.setNumero(rs.getInt("Numero"));
					f.id_usuarios(rs.getInt("id_usuarios"));
				
					funcionario.add(f);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				con.fecharConexao();
			}
			
			
			 
			 return funcionario;	
		}
		
		
			public boolean atualizarFuncionario(Funcionario end){
				
			
			String SQL = "UPTADE funcionario Set PrimeiroNome = ?";
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			int retorno = 0;
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				ps.setString(1, end.getPrimeiroNome());
				ps.setString(2, end.getSobrenome());
				retorno = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			return retorno != 0;
			
			}
		
}
