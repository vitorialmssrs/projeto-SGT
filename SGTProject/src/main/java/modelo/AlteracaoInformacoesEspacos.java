package modelo;

import java.time.LocalDate;

public class AlteracaoInformacoesEspacos {
	
	private Integer idManutencaoEspacos;
	private String espacos;
	private LocalDate diaAbertura;
	private Integer diaFechamento;
	private String horaAbert;
	private LocalDate horaFech;
	private Integer capacidade;

	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Integer getIdManutencaoEspacos() {
		return idManutencaoEspacos;
	}
	public void setIdManutencaoEspacos(Integer idManutencaoEspacos) {
		this.idManutencaoEspacos = idManutencaoEspacos;
	}
	public String getEspacos() {
		return espacos;
	}
	public void setEspacos(String espacos) {
		this.espacos = espacos;
	}
	public LocalDate getDiaAbertura() {
		return diaAbertura;
	}
	public void setDiaAbertura(LocalDate diaAbertura) {
		this.diaAbertura = diaAbertura;
	}
	public Integer getDiaFechamento() {
		return diaFechamento;
	}
	public void setDiaFechamento(Integer diaFechamento) {
		this.diaFechamento = diaFechamento;
	}
	public String getHoraAbert() {
		return horaAbert;
	}
	public void setHoraAbert(String horaAbert) {
		this.horaAbert = horaAbert;
	}
	public LocalDate getHoraFech() {
		return horaFech;
	}
	public void setHoraFech(LocalDate horaFech) {
		this.horaFech = horaFech;
	}

	
}
