package controle;

import java.util.ArrayList;
import modelo.Hospede;

public interface IHospedeDao {
	
	//ASSINATURA DO METODO
	
	public int inserirHospede(Hospede end);
	
	public ArrayList<Hospede> listarHospede();
	
	public boolean atualizarHospede(Hospede end);
	
	public Hospede buscarHospedePorCpf(int cpf);
	
	public boolean removerHospede (Hospede end);
}
