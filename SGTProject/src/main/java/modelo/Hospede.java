package modelo;

import java.util.Date;

public class Hospede {
	
	//alt shift r muda todas as variaveis 
	
	public String primeiro_nome;
	public String sobrenome;
	public int cpfClientes;
	public Date datanascimento;
	public Date checkin;
	public Date checkout;
	
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
	public int getCpfclientes() {
		return cpfClientes;
	}
	public void setCpfclientes(int cpfclientes) {
		this.cpfClientes = cpfclientes;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date i) {
		this.datanascimento = i;
	}
	public Date getCheckin() {
		return  checkin;
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
