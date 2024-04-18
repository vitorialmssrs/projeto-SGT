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

		String SQL = "INSERT INTO funcionarios(num_identificacao,nome_completo,data_nascimento,telefone,cep,num_casa,login,senha) VALUES (?,?,?,?,?,?,?,?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, fun.getNumIndentificacao());
			ps.setString(2, fun.getNomeCompleto());
			ps.setDate(3, Date.valueOf(fun.getDataNascimento()));
			ps.setInt(4, fun.getTelefone());
			ps.setInt(5, fun.getCep());
			ps.setInt(6, fun.getNumCasa());
			ps.setString(7, fun.getLogin());
			ps.setString(8, fun.getSenha());

			int result = ps.executeUpdate();
			if (result != 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					chavePrimariaGerada = rs.getInt(1);
				}
			}

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
				Integer NumIndentificacao = rs.getInt("num_indentificacao");
				String NomeCompleto = rs.getNString("nome_completo");
				Integer Telefone = rs.getInt("telefone");
				Integer Cep = rs.getInt("cep");
				Integer NumCasa = rs.getInt("num_casa");
				LocalDate DataNascismento = rs.getDate("data_de_nascimento").toLocalDate();

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

		String SQL = "UPDATE funcionario Set Login = ?, Senha = ?, NumIndentificacao = ?, NomeCompleto = ?, DataNascismento = ?, Telefone = ?, Cep = ?, NumCasa = ? WHERE id_funcionario";
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
			ps.setDate(6, Date.valueOf(end.getDataNascimento()));
			ps.setInt(7, end.getTelefone());
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

		Funcionario f = null;

		String SQL = "SELECT * FROM usuarios u WHERE u.login = ? AND u.senha = ?";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = new Funcionario();
				Integer idFuncionario = rs.getInt("id_funcionario");
				String Login = rs.getNString("login");
				String Senha = rs.getNString("senha");
				Integer NumIndentificacao = rs.getInt("num_indentificacao");
				String NomeCompleto = rs.getNString("nome_completo");
				Integer Telefone = rs.getInt("telefone");
				Integer Cep = rs.getInt("cep");
				Integer NumCasa = rs.getInt("num_casa");
				LocalDate DataNascismento = rs.getDate("data_de_nascimento").toLocalDate();

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
