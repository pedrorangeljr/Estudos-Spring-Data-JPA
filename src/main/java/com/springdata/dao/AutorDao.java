package com.springdata.dao;

import java.util.List;

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

	@Transactional(readOnly = true)
	public Autor findById(Long id) {

		return this.manager.find(Autor.class, id);
	}

	@Transactional(readOnly = true)
	public List<Autor> findAll() { // pesquisa todos

		String query = "select a from Autor a";

		return this.manager.createQuery(query, Autor.class).getResultList();
	}

	@Transactional(readOnly = true)
	public List<Autor> findAllByNomeOrSobrenome(String termo) { // pesquisa por parte da String

		String query = "select a from Autor a where a.nome like :termo OR a.sobrenome like :termo";
		return this.manager.createQuery(query, Autor.class).setParameter("termo", "%" + termo + "%").getResultList();

	}
	
	@Transactional(readOnly = true)
	public Long getTotalElements() { // conta a quantidade de autores no banco de dados
		
		String query = "select count(1) from Autor a ";
		return this.manager.createQuery(query, Long.class).getSingleResult();
	}
}
