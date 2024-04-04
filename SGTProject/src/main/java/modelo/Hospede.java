package modelo;

import java.time.LocalDate;

public class Hospede {
	
	//alt shift r muda todas as variaveis 
	
	private Integer idcliente;
	private Integer numidentificacao;
	private String primeironome;
	private String sobrenome;
	private LocalDate datanascimento;
	private Integer telefone;
	private String email;
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public Integer getNumidentificacao() {
		return numidentificacao;
	}
	public void setNumidentificacao(Integer numidentificacao) {
		this.numidentificacao = numidentificacao;
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
	public LocalDate getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
