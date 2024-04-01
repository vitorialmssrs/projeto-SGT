package controle;

import java.util.Date;

public class Funcionario{
	
	
	public int numidentificacao;
	public String primeironome;
	public String sobrenome;
	public Date datanascimento;
	//public String email;
	public int telefone;
	public int cep;
	public int numcasa;
	public int idusuarios;
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
		return primeironome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		primeironome = primeiroNome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String Sobrenome) {
		sobrenome = Sobrenome;
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
		return numcasa;
	}
	public void setNumero(int numero) {
		this.numcasa = numero;
	}
	public int getidusuarios() {
		return idusuarios;
	}
	public void setidusuarioso(int id_usuarios) {
	    this.idusuarios = id_usuarios;
	}
	public void setDatanascimento(Date date){
		this.datanascimento = date;
	}
	
	public Date getDatanascimento() {
        return this.datanascimento;
    }
	public void id_usuarios(int int1) { /*  Ver se isso deve estar aqui   */ 
		// TODO Auto-generated method stub
		
	}
	
	public int getNumIdentificacao() {
		return numidentificacao;
	}
	public void setIndentificacao(int Numidentificacao) {
		numidentificacao = Numidentificacao;	
	}
	
	

	
}
	
	