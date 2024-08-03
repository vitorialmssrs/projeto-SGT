package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class LimpezaEspacos {
	
	private  EspacoHotel espacos;
	private Funcionario funcionario;
	private String tipoManutencao;
	private LocalDate dia;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getTipoManutencao() {
		return tipoManutencao;
	}
	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
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


	
	
	
	

}
