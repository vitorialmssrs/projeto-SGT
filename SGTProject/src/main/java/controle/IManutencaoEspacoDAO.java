package controle;

import java.util.ArrayList;
import modelo.ManutencaoEspacos;

public interface IManutencaoEspacoDAO {
	
	public int inserirManutencao (ManutencaoEspacos end);
	public ArrayList<ManutencaoEspacos> listarManutencaoEspacos();
	public boolean atualizarLManutencaoEspacos(ManutencaoEspacos end);
	public boolean removerManutencaoEspacos(ManutencaoEspacos end);
	

}
