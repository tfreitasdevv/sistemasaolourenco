package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tmidevelopment.saolourenco.domain.Pessoa;

public class PessoaBasicUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private String nomeDoPai;
	private String nomeDaMae;
	private String email;

	public PessoaBasicUpdateDTO() {
	}

	public PessoaBasicUpdateDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		nomeDoPai = obj.getNomeDoPai();
		nomeDaMae = obj.getNomeDaMae();
		email = obj.getEmail();
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
