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
				
				ps.setInt(1, end.getCPF());
				ps.setString(2, end.getPrimeiroNome());
				ps.setString(3, end.getSobrenome());
				ps.setDate(4, end.getData_nascimento());
				ps.setString(5, end.getEmail());
				ps.setInt(6, end.getTelefone());
				ps.setInt(7, end.getCep());
				ps.setInt(8, end.getNumero());
				ps.setInt(9, end.getUsuario_id_usuario());
				
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
					
					f.setCPF(rs.getInt("CPF"));
					f.setPrimeiroNome(rs.getString("PrimeiroNome"));
					f.setSobrenome(rs.getString("Sobrenome"));
					f.setData_nascimento(rs.getDate("data_de_nascimento"));
					f.setEmail(rs.getString("Email"));
					f.setTelefone(rs.getInt("Telefone"));
					f.setCep(rs.getInt("Cep"));
					f.setNumero(rs.getInt("Numero"));
					f.setUsuario_id_usuario(rs.getInt("Usuario_id_usuario"));
				
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
