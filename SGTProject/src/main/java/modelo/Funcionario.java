package modelo;

import java.time.LocalDate;

public class Funcionario {

	/*
	 * CREATE TABLE IF NOT EXISTS `mydb`.`funcionarios` ( `id_funcionario` INT(7)
	 * NOT NULL AUTO_INCREMENT, `login` VARCHAR(45) NOT NULL, `senha` VARCHAR(45)
	 * NOT NULL, `num_identificacao` INT(7) NOT NULL, `nome_completo` VARCHAR(100)
	 * NOT NULL, `data_nascimento` DATE NOT NULL, `telefone` INT(11) NOT NULL, `cep`
	 * INT(8) NOT NULL, `num_casa` INT(4) NOT NULL, PRIMARY KEY (`id_funcionario`));
	 */
	private Integer idFuncionario;
	private String nomeCompleto;
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

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getNumIndentificacao() {
		return numIndentificacao;
	}

	public void setNumIndentificacao(Integer numIndentificacao) {
		this.numIndentificacao = numIndentificacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
