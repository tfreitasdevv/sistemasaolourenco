package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParoquiaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String numero;
	private String complemento;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String bairro;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;

	@NotNull(message = "Preenchimento obrigatório")
	private Integer cidadeId;

	public ParoquiaNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

}
