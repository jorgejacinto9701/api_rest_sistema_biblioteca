package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Categoria;

import com.cibertec.rest.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listaTodos() {
		return repository.findAll();

	}

	@Override
	public List<Categoria> listaTodosPorTipo(int tipo) {
		return repository.findByTipo(tipo);
	}
	@Override
	public Categoria registra(Categoria obj) {
		return repository.save(obj);
	}
}
