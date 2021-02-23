package com.tmidevelopment.saolourenco.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Crisma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String livro;
	private String folha;
	private String padrinho;

	@OneToOne
	private Pessoa crismado;

	@ManyToOne
	@JoinColumn(name = "celebrante_id")
	private Celebrante celebrante;

	public Crisma() {
	}

	public Crisma(Integer id, Date data, String livro, String folha, String padrinho, Pessoa crismado,
			Celebrante celebrante) {
		super();
		this.id = id;
		this.data = data;
		this.livro = livro;
		this.folha = folha;
		this.padrinho = padrinho;
		this.crismado = crismado;
		this.celebrante = celebrante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
	}

	public Pessoa getCrismado() {
		return crismado;
	}

	public void setCrismado(Pessoa crismado) {
		this.crismado = crismado;
	}

	public Celebrante getCelebrante() {
		return celebrante;
	}

	public void setCelebrante(Celebrante celebrante) {
		this.celebrante = celebrante;
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
		Crisma other = (Crisma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
