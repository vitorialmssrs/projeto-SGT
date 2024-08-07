package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ManutencaoEspacos {
	
	private EspacoHotel espacos;
	private Funcionario funcionario;
	private String tipoManutencao;
	private LocalDate diaManutencao;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private String descricao;
	private Integer idmanutencao;
	
	
	public Integer getIdmanutencao() {
		return idmanutencao;
	}
	public void setIdmanutencao(Integer idmanutencao) {
		this.idmanutencao = idmanutencao;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
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
	public EspacoHotel getEspacos() {
		return espacos;
	}
	public void setEspacos(EspacoHotel espacos) {
		this.espacos = espacos;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
