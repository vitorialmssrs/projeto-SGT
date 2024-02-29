package controle;
import java.util.ArrayList;
import modelo.Hospede;

public interface IHospedeDao {
	public int inserirHospede(Hospede end);
	public ArrayList<Hospede> listarHospede();
	public boolean atualizarHospede(Hospede end);
	public boolean removerHospede(Hospede end);
	public Hospede buscarHospedePorCpf(int cpf);
}
