package controle;

import java.util.ArrayList;

import modelo.EspacoHotel;

//criação dos esqueletos 
public interface IEspacosDAO {
	
	public int inserirEspacos (EspacoHotel end); //código feito
	
	public ArrayList<EspacoHotel> insertEspacos2(); // código feito
	
	public ArrayList<EspacoHotel> listarEspacos();

	public boolean atualizarEspaco(EspacoHotel end);

	public boolean removerEspaco(EspacoHotel end);


	


}
