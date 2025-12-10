package com.springdata.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor", nullable = false)
	private Long id_autor;

	@Column(name = "nome", length = 45, nullable = false)
	private String nome;

	@Column(name = "sobrenome", length = 45, nullable = false)
	private String sobrenome;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_info")
	private InfoAutor infoAutor;

	public InfoAutor getInfoAutor() {
		return infoAutor;
	}

	public void setInfoAutor(InfoAutor infoAutor) {
		this.infoAutor = infoAutor;
	}

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_autor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id_autor, other.id_autor);
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + "]";
	}

}
