package controle;

import java.util.ArrayList;

import modelo.EspacoHotel;

public interface IEspacosDAO {
	
	public int inserirEspacos (EspacoHotel end);
	
	public ArrayList<EspacoHotel> listarEnderecos();

	public boolean atualizarEndereco(EspacoHotel end);

	public boolean removerEndereco(EspacoHotel end);

	public EspacoHotel buscarEnderecoPorCep(int cep);
	


}
