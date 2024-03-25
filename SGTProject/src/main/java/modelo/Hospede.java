package modelo;

import java.sql.Date;

public class Hospede {
	
	//alt shift r muda todas as variaveis 
	
	private Integer id; 	
	private String primeironome;
	private String sobrenome;
	private int cpfClientes;
	private Date datanascimento;
	private Date dataEntrada;
	private Date dataSaida;
	private Date horaEntrada;
	private Date horaSaida;

	
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Date getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrimeironome() {
		return primeironome;
	}
	public void setPrimeironome(String primeironome) {
		this.primeironome = primeironome;
	}
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getCpfClientes() {
		return cpfClientes;
	}
	public void setCpfClientes(int cpfClientes) {
		this.cpfClientes = cpfClientes;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

}
