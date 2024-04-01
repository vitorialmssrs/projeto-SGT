package controle;

import java.sql.Connection;

import modelo.EspacoHotel;
import modelo.LimpezaEspacos;

public class LimpezaDAO implements ILimpezaDAO {
	
	
	private static LimpezaDAO instancia;
	
	private LimpezaDAO() {
		
	}
	
	public static LimpezaDAO getInstancia() {

		if (instancia == null) {
			instancia = new LimpezaDAO();
		}
		return instancia;
	}
	
	public int inserirLimpeza(LimpezaEspacos end) {

		String SQL = "INSERT INTO EspacoHotel (academia, quiosque, salao_festa, quadra_futebol, sala_jogos, quadra_volei, SPA, brinquedoteca, piscina ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		//Abre conexao e cria a "ponte de conexao" com o MySQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

}
	
}
