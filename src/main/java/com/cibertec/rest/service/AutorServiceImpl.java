package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Autor;
import com.cibertec.rest.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository repositorio; 
	
	@Override
	public Autor insertaActualizaAutor(Autor obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Autor> buscarAutorPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaAutor(int idAutor) {
		repositorio.deleteById(idAutor);
	}

	@Override
	public List<Autor> listaAutor() {
		return repositorio.findAll();
	}

	

}


