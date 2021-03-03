package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;

import com.tmidevelopment.saolourenco.domain.Celebrante;
import com.tmidevelopment.saolourenco.domain.Paroquia;

public class CelebranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String funcao;

	private Paroquia paroquia;

	public CelebranteDTO() {
	}

	public CelebranteDTO(Celebrante obj) {
		id = obj.getId();
		nome = obj.getNome();
		funcao = obj.getFuncao();
		paroquia = obj.getParoquia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Paroquia getParoquia() {
		return paroquia;
	}

	public void setParoquia(Paroquia paroquia) {
		this.paroquia = paroquia;
	}

}
