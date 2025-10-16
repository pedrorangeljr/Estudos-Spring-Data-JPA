package com.springdata.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.entity.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional(readOnly = false)
	public void save(Autor autor) {

		this.manager.persist(autor); // salvar no banco de dados
	}

	@Transactional(readOnly = false)
	public void update(Autor autor) {

		this.manager.merge(autor); // edita no banco
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {

		this.manager.remove(this.manager.getReference(Autor.class, id)); // edita no banco
	}
}
