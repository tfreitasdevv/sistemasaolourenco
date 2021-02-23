package com.tmidevelopment.saolourenco.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PrimeiraEucaristia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String livro;
	private String folha;

	@OneToOne
	private Pessoa sacramentado;

	@ManyToOne
	@JoinColumn(name = "celebrante_id")
	private Celebrante celebrante;

	@ElementCollection
	@CollectionTable(name = "CATEQUISTA")
	private Set<String> catequistas = new HashSet<>();

	public PrimeiraEucaristia() {
	}

	public PrimeiraEucaristia(Integer id, Date data, String livro, String folha, Pessoa sacramentado,
			Celebrante celebrante) {
		super();
		this.id = id;
		this.data = data;
		this.livro = livro;
		this.folha = folha;
		this.sacramentado = sacramentado;
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

	public Pessoa getSacramentado() {
		return sacramentado;
	}

	public void setSacramentado(Pessoa sacramentado) {
		this.sacramentado = sacramentado;
	}

	public Celebrante getCelebrante() {
		return celebrante;
	}

	public void setCelebrante(Celebrante celebrante) {
		this.celebrante = celebrante;
	}

	public Set<String> getCatequistas() {
		return catequistas;
	}

	public void setCatequistas(Set<String> catequistas) {
		this.catequistas = catequistas;
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
		PrimeiraEucaristia other = (PrimeiraEucaristia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
