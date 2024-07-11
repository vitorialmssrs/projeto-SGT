package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlteracaoInformacoesEspacos {

	private Funcionario funcionario;
	private EspacoHotel espacos;
	private Integer id_espacos;
	private LocalDate diaAbertura;
	private LocalDate diaFechamento;
	private LocalTime horaAbert;
	private LocalTime horaFech;
	private Integer capacidade;

	
	
	public Integer getId_espacos() {
		return id_espacos;
	}
	public void setId_espacos(Integer id_espacos) {
		this.id_espacos = id_espacos;
	}
	
	public EspacoHotel getEspacos() {
		return espacos;
	} 
	public void setEspacos(EspacoHotel espacos) {
		this.espacos = espacos;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDiaAbertura() {
		return diaAbertura;
	}
	public void setDiaAbertura(LocalDate diaAbertura) {
		this.diaAbertura = diaAbertura;
	}
	public LocalDate getDiaFechamento() {
		return diaFechamento;
	}
	public void setDiaFechamento(LocalDate diaFechamento) {
		this.diaFechamento = diaFechamento;
	}
	public LocalTime getHoraAbert() {
		return horaAbert;
	}
	public void setHoraAbert(LocalTime horaAbert) {
		this.horaAbert = horaAbert;
	}
	public LocalTime getHoraFech() {
		return horaFech;
	}
	public void setHoraFech(LocalTime horaFech) {
		this.horaFech = horaFech;
	}
	

	
}
