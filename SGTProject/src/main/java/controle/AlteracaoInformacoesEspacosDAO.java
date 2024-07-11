package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import modelo.AlteracaoInformacoesEspacos;

public class AlteracaoInformacoesEspacosDAO implements IAlteracaoInformacoesEspaco {


	public int inserirAlteracao(AlteracaoInformacoesEspacos end) {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean atualizarAlteracao(AlteracaoInformacoesEspacos altE) {
		String SQL = "UPDATE espacos_hotel SET id_espacos =?, nome_espaco = ?, dia_semana_abertura = ?, dia_semana_fechamento = ?, horario_abertura = ?, horario_fechamento = ?, capacidade = ?, funcionarios_id_funcionario = ? WHERE id_espacos = ?";
					
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		boolean sucesso = false;
		 try { PreparedStatement ps = conBD.prepareStatement(SQL);

            ps.setInt(1, altE.getId_espacos()); // Supondo que getIdEspacoHotel() retorna uma String
           
            // Converter LocalDate para java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(altE.getDiaAbertura());
            ps.setDate(2, sqlDate);

            java.sql.Date sqlDate2 = java.sql.Date.valueOf(altE.getDiaFechamento());
            ps.setDate(3, sqlDate2);

            ps.setTime(4, Time.valueOf(altE.getHoraAbert()));
            ps.setTime(5, Time.valueOf(altE.getHoraFech()));
            ps.setInt(6, altE.getFuncionario().getIdFuncionario()); 
            ps.setInt(7, altE.getCapacidade());
          //  ps.setInt(8, altE.getId());

            // Executa a consulta
            
            int linhasAfetadas = ps.executeUpdate();
            sucesso = (linhasAfetadas > 0);
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
        	con.fecharConexao();
        }

        return sucesso;
	}
	

	
	public boolean removerAlteracao(AlteracaoInformacoesEspacos end) {
		// TODO Auto-generated method stub
		return false;
	}


	public static AlteracaoInformacoesEspacosDAO getInstancia() {
		// TODO Auto-generated method stub
		return null;
	}

}
