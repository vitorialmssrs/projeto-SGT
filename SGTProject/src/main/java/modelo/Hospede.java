package modelo;

import java.util.Date;

public class Hospede {
	
	//alt shift r muda todas as variaveis 
	
	private Integer id; 	
	private String primeiro_nome;
	private String sobrenome;
	private int cpfClientes;
	private Date datanascimento;
	private Date checkin;
	private Date checkout;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrimeiro_nome() {
		return primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
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
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	
	

}
