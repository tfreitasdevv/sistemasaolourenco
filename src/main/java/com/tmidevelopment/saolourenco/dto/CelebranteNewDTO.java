package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;

public class CelebranteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String funcao;
	private Integer paroquiaId;

	public CelebranteNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getParoquiaId() {
		return paroquiaId;
	}

	public void setParoquiaId(Integer paroquiaId) {
		this.paroquiaId = paroquiaId;
	}

}
