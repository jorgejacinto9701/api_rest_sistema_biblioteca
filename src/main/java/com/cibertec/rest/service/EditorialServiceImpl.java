package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Editorial;
import com.cibertec.rest.repository.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepository repository;

	@Override
	public Editorial insertaActualizaEditorial(Editorial obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Editorial> buscarEditorialPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaEditorial(int idEditorial) {
		repository.deleteById(idEditorial);
	}

	@Override
	public List<Editorial> listaEditorial() {
		return repository.findAll();
	}

	@Override
	public List<Editorial> listaEditorialPorNombre(String nombre) {
		return repository.listaEditorialPorNombre(nombre);
	}

	@Override
	public List<Editorial> listaEditorialPorNombreIgual(String nombre) {
		return repository.listaEditorialPorNombreIgual(nombre);
	}

}
