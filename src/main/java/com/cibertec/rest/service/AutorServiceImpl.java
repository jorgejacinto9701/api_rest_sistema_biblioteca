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
	private AutorRepository repository; 
	
	@Override
	public Autor insertaActualizaAutor(Autor obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Autor> buscarAutorPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaAutor(int idAutor) {
		repository.deleteById(idAutor);
	}

	@Override
	public List<Autor> listaAutor() {
		return repository.findAll();
	}

	@Override
	public List<Autor> listaAutorPorNombre(String nombre) {
		return repository.listaPorNombre(nombre);
	}

	
	@Override
	public List<Autor> listaPorNombreApellidoIgual(String nombre, String apellidos) {
		return repository.listaPorNombreApellidoIgual(nombre, apellidos);
	}
}


