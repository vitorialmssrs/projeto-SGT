package controle;

import java.util.ArrayList;

import modelo.LimpezaEspacos;
import modelo.ManutencaoEspacos;

public interface IManutencaoEspacoDAO {
	
	public int inserirManutencao (ManutencaoEspacos end);
	public ArrayList<LimpezaEspacos> inserirLimpeza();
	public ArrayList<ManutencaoEspacos> listarManutencaoEspacos();
	

}
