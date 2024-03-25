package controle;

import java.sql.Date;

public class Funcionario{
	
	
	public int num_identificacao;
	public String primeiro_nome;
	public String sobrenome;
	public Date data_nascimento;
	//public String email;
	public int telefone;
	public int cep;
	public int num_casa;
	public int id_usuarios;
//	public String rua;
//	public String bairro;
	
	/*public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	private int  usuario_id_usuario;
	
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;	
	}
	
	*/
	public String getPrimeiroNome() {
		return primeiro_nome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		primeiro_nome = primeiroNome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		sobrenome = sobrenome;
	}
/*	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;	
	}  */
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
		return num_casa;
	}
	public void setNumero(int numero) {
		this.num_casa = numero;
	}
	public int getid_usuarios() {
		return id_usuarios;
	}
	public void setid_usuarioso(int id_usuarios) {
	    this.id_usuarios = id_usuarios;
	}
	public void setData_nascimento(Date date){
		this.data_nascimento = date;
	}
	
	public Date getData_nascimento() {
        return this.data_nascimento;
    }
	public void id_usuarios(int int1) { /*  Ver se isso deve estar aqui   */ 
		// TODO Auto-generated method stub
		
	}
	
	public int getnum_identificacao() {
		return num_identificacao;
	}
	public void setCPF(int Num_identificacao) {
		num_identificacao = Num_identificacao;	
	}
	
	

	
}
	
	