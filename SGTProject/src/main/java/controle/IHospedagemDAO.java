package controle;

import java.util.ArrayList;
import modelo.Hospedagem;

public interface IHospedagemDAO {

	public int inserirHospedagem(Hospedagem end);
	
	public ArrayList<Hospedagem> listarHospedagem();
	
	public boolean atualizarHospedagem(Hospedagem end);
	
	public boolean removerHospedagem (Hospedagem end);
	
}
