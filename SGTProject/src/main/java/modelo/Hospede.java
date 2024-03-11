package modelo;

import java.util.Date;

public class Hospede {
	
	//alt shift r muda todas as variaveis 
	
	public String primeiro_nome;
	public String sobrenome;
	public int cpfClientes;
	public Date dataNascimento;
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
	public int getCpf_clientes() {
		return cpfClientes;
	}
	public void setCpf_clientes(int cpf_clientes) {
		this.cpfClientes = cpf_clientes;
	}
	public Date getData_de_nascimento() {
		return dataNascimento;
	}
	public void setData_de_nascimento(Date i) {
		this.dataNascimento = i;
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
	public void checkin(Date date) {
		// TODO Auto-generated method stub
		
	}
	

}
