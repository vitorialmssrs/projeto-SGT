package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.AlteracaoInformacoesEspacos;

public class AlteracaoInformacoesEspacosDAO implements IAlteracaoInformacoesEspaco {
    private static AlteracaoInformacoesEspacosDAO instancia;

    private AlteracaoInformacoesEspacosDAO() {
        // Construtor privado para o padrão Singleton
    }

    public static AlteracaoInformacoesEspacosDAO getInstancia() {
        if (instancia == null) {
            instancia = new AlteracaoInformacoesEspacosDAO();
        }
        return instancia;
    }

    public int inserirAlteracao(AlteracaoInformacoesEspacos end) {
        // Implementação para inserir uma nova alteração
        return 0;
    }

    public boolean atualizarAlteracao(AlteracaoInformacoesEspacos altE) {
        String SQL = "UPDATE espacos_hotel SET id_espacos = ?, dia_semana_abertura = ?, dia_semana_fechamento = ?, horario_abertura = ?, horario_fechamento = ?, capacidade = ? WHERE id_espacos = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();
        
       int rowsAffected = 0;
        
        //boolean sucesso = false;
        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);

            ps.setInt(1, altE.getId_espacos()); // Supondo que getIdEspacoHotel() retorna uma String
            ps.setDate(2, java.sql.Date.valueOf(altE.getDiaAbertura()));
            ps.setDate(3, java.sql.Date.valueOf(altE.getDiaFechamento()));
            ps.setTime(4, Time.valueOf(altE.getHoraAbert()));
            ps.setTime(5, Time.valueOf(altE.getHoraFech()));
            ps.setInt(6, altE.getCapacidade());
            ps.setInt(7, altE.getId_espacos());

            //int linhasAfetadas = ps.executeUpdate();
            rowsAffected = ps.executeUpdate();
            //sucesso = (linhasAfetadas > 0);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return rowsAffected > 0;
        //return sucesso;
    }

    public boolean removerAlteracao(AlteracaoInformacoesEspacos end) {
        // Implementação para remover uma alteração
        return false;
    }

    public List<AlteracaoInformacoesEspacos> getAllEspacos() {
        List<AlteracaoInformacoesEspacos> espacos = new ArrayList<>();
        String SQL = "SELECT * FROM espacos_hotel"; // Ajuste conforme o nome da sua tabela

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        try (PreparedStatement ps = conBD.prepareStatement(SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AlteracaoInformacoesEspacos espaco = new AlteracaoInformacoesEspacos();
                espaco.setId_espacos(rs.getInt("id_espacos"));
                espaco.setNome(rs.getString("nome_espaco"));
                espaco.setDiaAbertura(rs.getDate("dia_semana_abertura").toLocalDate());
                espaco.setDiaFechamento(rs.getDate("dia_semana_fechamento").toLocalDate());
                espaco.setHoraAbert(rs.getTime("horario_abertura").toLocalTime());
                espaco.setHoraFech(rs.getTime("horario_fechamento").toLocalTime());
                espaco.setCapacidade(rs.getInt("capacidade"));
                // Se necessário, defina o funcionário associado ao espaço
                // espaco.setFuncionario(buscarFuncionarioPorId(rs.getInt("funcionarios_id_funcionario")));

                espacos.add(espaco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return espacos;
    }
}