package com.tmidevelopment.saolourenco.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private String sexo;
	private String nomeDoPai;
	private String nomeDaMae;
	@Column(unique = true)
	private String cpf;
	private String email;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "paroquia_id")
	private Paroquia paroquia;

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@JsonIgnore
	@OneToOne
	private Batismo batismo;

	@JsonIgnore
	@OneToOne
	private Crisma crisma;

	@JsonIgnore
	@OneToOne
	private Casamento casamento;

	@JsonIgnore
	@OneToOne
	private PrimeiraEucaristia primeiraEucaristia;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, Date nascimento, String sexo, String nomeDoPai, String nomeDaMae, String cpf,
			String email, Endereco endereco, Paroquia paroquia, Batismo batismo, Crisma crisma, Casamento casamento,
			PrimeiraEucaristia primeiraEucaristia) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.nomeDoPai = nomeDoPai;
		this.nomeDaMae = nomeDaMae;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.paroquia = paroquia;
		this.batismo = batismo;
		this.crisma = crisma;
		this.casamento = casamento;
		this.primeiraEucaristia = primeiraEucaristia;
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

	public Batismo getBatismo() {
		return batismo;
	}

	public void setBatismo(Batismo batismo) {
		this.batismo = batismo;
	}

	public Crisma getCrisma() {
		return crisma;
	}

	public void setCrisma(Crisma crisma) {
		this.crisma = crisma;
	}

	public Casamento getCasamento() {
		return casamento;
	}

	public void setCasamento(Casamento casamento) {
		this.casamento = casamento;
	}

	public PrimeiraEucaristia getPrimeiraEucaristia() {
		return primeiraEucaristia;
	}

	public void setPrimeiraEucaristia(PrimeiraEucaristia primeiraEucaristia) {
		this.primeiraEucaristia = primeiraEucaristia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
