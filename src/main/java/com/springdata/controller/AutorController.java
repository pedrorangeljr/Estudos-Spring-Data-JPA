package com.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.dao.AutorDao;
import com.springdata.entity.Autor;

@RestController
@RequestMapping("autores")
public class AutorController {

	@Autowired
	private AutorDao dao;

	@PostMapping
	public Autor salvar(@RequestBody Autor autor) {

		dao.save(autor);
		return autor;
	}
	
	@PutMapping
	public Autor atualizar(@RequestBody Autor autor) {

		dao.update(autor);
		return autor;
	}
	
	@DeleteMapping("{id}")
	public String remover(@PathVariable Long id) {

		dao.delete(id);
		return "Autor deletado com sucesso";
	}
	
	@GetMapping("{id}")
	public Autor getById(@PathVariable Long id) {

		return dao.findById(id);
	}
	
	@GetMapping
	public List<Autor> getAll() { // lista todos os Autores

		return dao.findAll();
	}
}
