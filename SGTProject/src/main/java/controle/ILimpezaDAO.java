package controle;

import java.util.ArrayList;

import modelo.LimpezaEspacos;

public interface ILimpezaDAO {
	 
	 public int inserirLimpeza(LimpezaEspacos end);
		
		public ArrayList <LimpezaEspacos> listarLimpezaEspacos();
		
		public boolean atualizarLimpezaEspacos(LimpezaEspacos end);
		
		public boolean removerLimpezaEspacos(LimpezaEspacos end);

}
