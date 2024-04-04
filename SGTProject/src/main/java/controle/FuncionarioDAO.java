package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Funcionario;


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
			
			
			String SQL = "INSERT INTO funcionarios (id_funcionario, login, senha, num_indentificacao, nome_completo, data_nascismento, telefone, cep, num_casa, espacos_hotel_id_espacos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Conexao con = Conexao.getInstancia();
			Connection conBD = con.conectar();
			
			try {
				PreparedStatement ps = conBD.prepareStatement(SQL);
				
				ps.setInt(1, end.getIdFuncionario());
				ps.setString(2, end.getLogin());
				ps.setString(3, end.getSenha());
				ps.setInt(4, end.getNumIndentificacao());
				ps.setString(5, end.getNomeCompleto());
			    ps.setDate(6, end.getDataNascismento());
			    ps.setInt(7, end.getTelefone());
			    ps.setInt(8, end.getCep());
			    ps.setInt(9, end.getNumCasa());
			    ps.setInt(10, end.getEspacosHotelIdEspacos());
				
				
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
					
					f.setIdFuncionario(rs.getInt("id_funcionario"));
					f.setLogin(rs.getNString("login"));
					f.setSenha(rs.getNString("senha"));
					f.setNumIndentificacao(rs.getInt("num_indentificacao"));
					f.setNomeCompleto(rs.getNString("nome_completo"));
					f.setDataNascismento(rs.getDate("data_nascismento"));
					f.setTelefone(rs.getInt("telefone"));
					f.setCep(rs.getInt("cep"));
					f.setNumCasa(rs.getInt("num_casa"));
					f.setEspacosHotelIdEspacos(rs.getInt("espacos_hotel_id_espacos"));
				
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
				ps.setInt(1, end.getIdFuncionario());
				ps.setInt(1, end.getIdFuncionario());
				ps.setString(2, end.getLogin());
				ps.setString(3, end.getSenha());
				ps.setInt(4, end.getNumIndentificacao());
				ps.setString(5, end.getNomeCompleto());
			    ps.setDate(6, end.getDataNascismento());
			    ps.setInt(7, end.getTelefone());
			    ps.setInt(8, end.getCep());
			    ps.setInt(9, end.getNumCasa());
			    ps.setInt(10, end.getEspacosHotelIdEspacos());
				
				/*
				DAO                         Funcionario
				
				IdFuncionario               idFuncionario
				Login                       login
				Senha                       senha
				NumIndentificacao           numIndentificacao
				NomeCompleto                nomeCompleto
				DataNascismento             dataNascismento
			    Telefone                    telefone
			    Cep                         cep
			    NumCasa                     numCasa
			    EspacosHotelIdEspacos       espacosHotelIdEspacos
			    */
				retorno = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			return retorno != 0;
			
			}
		
}
