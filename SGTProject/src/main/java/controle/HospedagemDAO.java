package controle;

import java.util.ArrayList;

import modelo.Hospedagem;

public class HospedagemDAO {

	private static HospedagemDAO instancia;
	
	public static HospedagemDAO getInstancia() {
		if (instancia == null) {
			instancia = new HospedagemDAO();
		}
		return instancia;
	}
	
	public int insertHospedagem(Hospedagem end) {}

	public ArrayList<Hospedagem> listarHospedagem() {}
	
	public boolean atualizarHospedagem(Hospedagem end) {}
	
	public boolean removerHospedagem (Hospedagem end) {}
}
