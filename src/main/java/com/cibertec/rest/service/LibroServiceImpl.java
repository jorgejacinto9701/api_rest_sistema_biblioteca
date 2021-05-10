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
	private LibroRepository repositorio; 
	
	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Libro> buscarLibroPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaLibro(int idLibro) {
		repositorio.deleteById(idLibro);
	}

	@Override
	public List<Libro> listaLibro() {
		return repositorio.findAll();
	}

	

}


