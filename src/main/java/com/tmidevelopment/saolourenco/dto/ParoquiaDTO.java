package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.tmidevelopment.saolourenco.domain.Paroquia;

public class ParoquiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	public ParoquiaDTO() {
	}

	public ParoquiaDTO(Paroquia obj) {
		id = obj.getId();
		nome = obj.getNome();
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

}
