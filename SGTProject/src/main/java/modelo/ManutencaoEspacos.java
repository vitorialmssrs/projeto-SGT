package modelo;

import java.time.LocalDate;

public class ManutencaoEspacos {
	
	private String idManutencaoEspacos;
	private String tipoManutencao;
	private LocalDate diaManutencao;
	
	
	public String getIdManutencaoEspacos() {
		return idManutencaoEspacos;
	}
	public void setIdManutencaoEspacos(String idManutencaoEspacos) {
		this.idManutencaoEspacos = idManutencaoEspacos;
	}
	public String getTipoManutencao() {
		return tipoManutencao;
	}
	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}
	public LocalDate getDiaManutencao() {
		return diaManutencao;
	}
	public void setDiaManutencao(LocalDate diaManutencao) {
		this.diaManutencao = diaManutencao;
	}

}
