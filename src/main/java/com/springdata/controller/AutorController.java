package com.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
