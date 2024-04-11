package modelo;

import java.time.LocalDate;

public class ManutencaoEspacos {
	
	private Integer idManutencaoEspacos;
	private String tipoManutencao;
	private LocalDate diaManutencao;
	
	
	public Integer getIdManutencaoEspacos() {
		return idManutencaoEspacos;
	}
	public void setIdManutencaoEspacos(Integer idManutencaoEspacos) {
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
