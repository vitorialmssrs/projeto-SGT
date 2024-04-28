package modelo;
import java.time.LocalDate;
public class Funcionario{
	
	
	private Integer idFuncionario;
	private String login;
	private String senha;
	private Integer numIndentificacao;
	private String nomeCompleto;
	private LocalDate dataNascismento;
	private String telefone;
	private Integer cep;
	private Integer numCasa;
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getNumIndentificacao() {
		return numIndentificacao;
	}
	public void setNumIndentificacao(Integer numIndentificacao) {
		this.numIndentificacao = numIndentificacao;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public LocalDate getDataNascismento() {
		return dataNascismento;
	}
	public void setDataNascismento(LocalDate dataNascismento) {
		this.dataNascismento = dataNascismento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public Integer getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(Integer numCasa) {
		this.numCasa = numCasa;
	}
}
	
	

