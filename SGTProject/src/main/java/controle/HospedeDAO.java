package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;


import modelo.Hospede;

public class HospedeDAO {

	private static HospedeDAO instancia;


	public static HospedeDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedeDAO();
		}
		return instancia;
	}

	public int insertHospede(Hospede end) {
		String SQL = "INSERT INTO hospede (primeiroNome, sobrenome, cpf, dataNascimento, checkIn, checkOut) VALUES (?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(chavePrimariaGerada, end.getPrimeironome());
			ps.setString(chavePrimariaGerada, end.getSobrenome());
			ps.setInt(chavePrimariaGerada, end.getCpfClientes());
			ps.setDate(chavePrimariaGerada, end.getDatanascimento());
			ps.setDate(chavePrimariaGerada, end.getDataEntrada());
			ps.setDate(chavePrimariaGerada, end.getDataSaida());
			ps.setFloat(chavePrimariaGerada, end.getHoraEntrada());
			ps.setFloat(chavePrimariaGerada, end.getHoraSaida());
			

			
			int ra = ps.executeUpdate();
			
			if(ra > 0) {
				ResultSet gk = ps.getGeneratedKeys();
				if(gk.next()) {
					chavePrimariaGerada = gk.getInt(1);
					
				}
				
			}

					
		} catch (SQLException e) {

			e.printStackTrace();
			
		}finally {
			con.fecharConexao();
			
		}

		return chavePrimariaGerada;
	}
	
	public ArrayList<Hospede> listarHospede(){
		
		//ArrayList para armazenar o resultado do select
		
		ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
		
		//Comando SQL a ser executado
		
		String SQL = "SELECT * FROM hospedes";
		
		//Cria a "ponta de conexão" com o MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		
		try {
			
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//Cria o objeto
				Hospede end = new Hospede();
				
				//Pega os valores de cada coluna do registro 
				String PrimeiroNome = rs.getString("primeiroNome");
				String Sobrenome = rs.getString("sobrenome");
				Date Datanascimento = rs.getDate("dataNascimento");				
				int cpf = rs.getInt("cpf");
				Date DataEntrada = rs.getDate("DataEntrada");
				Date DataSaida = rs.getDate("DataSaida");
				Float horaEntrada = rs.getFloat("horaEntrada");
				Float horaSaida = rs.getFloat("horaSaida");
				
				//localdate ==> mais indicado para utilizar
				//LocalTime
				//LocalDateTime
				
				//seta oa valores no objeto java 
				end.setPrimeironome(PrimeiroNome);
				end.setSobrenome(Sobrenome);
				end.setCpfClientes(cpf);
				end.setDatanascimento(Datanascimento);
				end.setDataEntrada(DataEntrada);
				end.setDataSaida(DataSaida);
				end.setHoraEntrada(horaEntrada);
				end.setHoraSaida(horaSaida);
				
				hospedes.add(end);		
			//precisa acrescentar a tela de confimação 
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return hospedes;
	}

	public boolean atualizarHospede(Hospede end) {
		
		String SQL = "UPDATE hospedes SET nome = ?, sobrenome = ?, cpf = ?, dataNascimento = ?, dataEntrada = ?, dataSaida = ?, horaEntrada = ?, horaSaida = ?, WHERE cpf = ?";
		
		//Abre conexão e cria a "ponte de conexão" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ps.setString(1, end.getPrimeironome());
			ps.setString(2, end.getSobrenome());
			ps.setInt(3, end.getCpfClientes());
			ps.setDate(4, end.getDatanascimento());
			ps.setDate(5, end.getDataEntrada());
			ps.setDate(6, end.getDataSaida());
			ps.setFloat(7, end.getHoraEntrada());
			ps.setFloat(8, end.getHoraSaida());
			
			
			retorno = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		//IF Ternário: se o retorno for zero é pra considerar esse valor falso, senão é pra considerar verdadeiro 
		return retorno != 0;
	}
	
	public boolean removerHospede (Hospede end) {
		
		String SQL = "DELETE FROM hospedes SET nome = ?, sobrenome = ?, cpf = ?, dataNascimento = ?, dataEntrada = ?, dataSaida = ?, horaEntrada = ?, horaSaida = ?, WHERE cpf = ?"; //verificar qual sera usado para excluir id ou cpf
		
		Conexao con = Conexao.getInstancia();
		
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
				
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getId());
			
			retorno = ps.executeUpdate();
			
			/*int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				con.fecharConexao();
				return true;}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return retorno != 0;
	}
	
	
	
}
