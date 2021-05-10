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
	private EditorialRepository repositorio;

	@Override
	public Editorial insertaActualizaEditorial(Editorial obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Editorial> buscarEditorialPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaEditorial(int idEditorial) {
		repositorio.deleteById(idEditorial);
	}

	@Override
	public List<Editorial> listaEditorial() {
		return repositorio.findAll();
	}

}
