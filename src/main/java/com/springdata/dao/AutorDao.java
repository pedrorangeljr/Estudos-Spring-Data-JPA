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
}
