package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Funcionario;

//import controle.ControleFuncionario.IFuncionarioDAO;

public class FuncionarioDAO {

	private static FuncionarioDAO instancia;

	private FuncionarioDAO() {
	}

	public static FuncionarioDAO getInstancia() {

		if (instancia == null) {

			instancia = new FuncionarioDAO();

		}
		return instancia;
	}

	public int inserirFuncionario(Funcionario fun) {

		String SQL = "INSERT INTO funcionarios (login, senha, num_identificacao, nome_completo, data_nascimento, telefone, cep, num_casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, end.getLogin());
			ps.setString(2, end.getSenha());
			ps.setInt(3, end.getNumIndentificacao());
			ps.setString(4, end.getNomeCompleto());
			ps.setDate(5, Date.valueOf(end.getDataNascismento()));
			ps.setString(6, end.getTelefone());
			ps.setInt(7, end.getCep());
			ps.setInt(8, end.getNumCasa());


			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<Funcionario> listarFuncionario() {

		ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();

		String SQL = "SELECT * FROM funcionarios";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Funcionario f = new Funcionario();

				String Login = rs.getNString("login");
				String Senha = rs.getNString("senha");
				Integer NumIndentificacao = rs.getInt("num_identificacao");
				String NomeCompleto = rs.getNString("nome_completo");
				String Telefone = rs.getString("telefone");
				Integer Cep = rs.getInt("cep");
				Integer NumCasa = rs.getInt("num_casa");
				LocalDate DataNascismento = rs.getDate("data_nascimento").toLocalDate();

				f.setLogin(Login);
				f.setSenha(Senha);
				f.setNumIndentificacao(NumIndentificacao);
				f.setNomeCompleto(NomeCompleto);
				f.setDataNascimento(DataNascismento);
				f.setTelefone(Telefone);
				f.setCep(Cep);
				f.setNumCasa(NumCasa);


				funcionario.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return funcionario;
	}

	public boolean atualizarFuncionario(Funcionario end) {

		String SQL = "UPDATE funcionario Set Login = ?, Senha = ?, Num_Identificacao  = ?, NomeCompleto = ?, Data_nascimento = ?, Telefone = ?, Cep = ?, NumCasa = ?  ";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		int retorno = 0;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdFuncionario());
			ps.setString(2, end.getLogin());
			ps.setString(3, end.getSenha());
			ps.setInt(4, end.getNumIndentificacao());
			ps.setString(5, end.getNomeCompleto());
			ps.setDate(6, Date.valueOf(end.getDataNascismento()));
			ps.setString(7, end.getTelefone());
			ps.setInt(8, end.getCep());
			ps.setInt(9, end.getNumCasa());
	
			retorno = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return retorno != 0;

	}

	public Funcionario efetuaLogin(String login, String senha) {

		Funcionario f =  new Funcionario();

		String SQL = "SELECT * FROM funcionarios u WHERE u.login = ? AND u.senha = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Integer idFuncionario = rs.getInt("id_funcionario");
				String Login = rs.getNString("login");
				String Senha = rs.getNString("senha");
				Integer NumIndentificacao = rs.getInt("num_identificacao");
				String NomeCompleto = rs.getNString("nome_completo");
				String Telefone = rs.getString("telefone");
				Integer Cep = rs.getInt("cep");
				Integer NumCasa = rs.getInt("num_casa");
				LocalDate DataNascismento = rs.getDate("data_nascimento").toLocalDate();

				f.setIdFuncionario(idFuncionario);
				f.setLogin(Login);
				f.setSenha(Senha);
				f.setNumIndentificacao(NumIndentificacao);
				f.setNomeCompleto(NomeCompleto);
				f.setDataNascimento(DataNascismento);
				f.setTelefone(Telefone);
				f.setCep(Cep);
				f.setNumCasa(NumCasa);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return f;
	}

}
