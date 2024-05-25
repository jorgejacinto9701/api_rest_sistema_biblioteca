package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Libro;
import com.cibertec.rest.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository repository; 
	
	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Libro> buscarLibroPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaLibro(int idLibro) {
		repository.deleteById(idLibro);
	}

	@Override
	public List<Libro> listaLibro() {
		return repository.findAll();
	}

	@Override
	public List<Libro> listaLibroPorTitulo(String nombre) {
		return repository.listaLibroPorTitulo(nombre);
	}

	//Sesión 8
	@Override
	public List<Libro> listaLibroPorTituloIgual(String nombre) {
		return repository.listaLibroPorTituloIgual(nombre);
	}

	

}


