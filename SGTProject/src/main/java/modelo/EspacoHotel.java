package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class EspacoHotel {
	//colocar todas as informações dos espaços(informações das tabelas do banco de dados para listar em manutenção)
	//e fazer os get e sets 
	
	private int id; 
	private String nome;
	private LocalDate dataAbertura;
	private LocalDate dataFechamento; 
	private LocalTime horarioAbertura;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}
	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}
	public LocalTime getHorarioFechamento() {
		return horarioFechamento;
	}
	public void setHorarioFechamento(LocalTime horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	private LocalTime horarioFechamento;
	private int capacidade; 
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return nome;
}
}
