package com.tmidevelopment.saolourenco.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.domain.Pessoa;
import com.tmidevelopment.saolourenco.services.validation.PessoaUpdate;

@PessoaUpdate
public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private String sexo;
	private String nomeDoPai;
	private String nomeDaMae;
	private String cpf;
	private String email;

	private Endereco endereco;

	private Paroquia paroquia;

	private Set<String> telefones = new HashSet<>();

	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		sexo = obj.getSexo();
		nomeDoPai = obj.getNomeDoPai();
		nomeDaMae = obj.getNomeDaMae();
		cpf = obj.getCpf();
		email = obj.getEmail();
		telefones = obj.getTelefones();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Paroquia getParoquia() {
		return paroquia;
	}

	public void setParoquia(Paroquia paroquia) {
		this.paroquia = paroquia;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

}
