package modelo;

public class Hospede {
	
	public String primeiro_nome;
	public String sobrenome;
	public int cpf_clientes;
	public int data_de_nascimento;
	public int checkin;
	public int checkout;
	
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
		return cpf_clientes;
	}
	public void setCpf_clientes(int cpf_clientes) {
		this.cpf_clientes = cpf_clientes;
	}
	public int getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(int data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	public int getCheckin() {
		return checkin;
	}
	public void setCheckin(int checkin) {
		this.checkin = checkin;
	}
	public int getCheckout() {
		return checkout;
	}
	public void setCheckout(int checkout) {
		this.checkout = checkout;
	}
	

}
