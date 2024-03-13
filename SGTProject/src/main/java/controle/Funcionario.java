package controle;

import java.sql.Date;

public class Funcionario{
	
	
	public int CPF;
	public String PrimeiroNome;
	public String Sobrenome;
	public Date data_nascimento;
	public String email;
	public int telefone;
	public int cep;
	public int numero;
	private int  usuario_id_usuario;
	
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}
	public String getPrimeiroNome() {
		return PrimeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		PrimeiroNome = primeiroNome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getUsuario_id_usuario() {
		return usuario_id_usuario;
	}
	public void setUsuario_id_usuario(int usuario_id_usuario) {
	    this.usuario_id_usuario = usuario_id_usuario;
	}
	public void setData_nascimento(Date date) {
		// TODO Auto-generated method stub
		
	}
	
	public Date getData_nascimento() {
        return this.data_nascimento;
    }
	
	

	
}
	
	