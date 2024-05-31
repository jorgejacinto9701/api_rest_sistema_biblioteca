package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Revista;
import com.cibertec.rest.repository.RevistaRepository;

@Service
public class RevistaServiceImpl implements RevistaService{

	@Autowired
	private RevistaRepository repository; 
	
	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Revista> buscarRevistaPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaRevista(int idRevista) {
		repository.deleteById(idRevista);
	}

	@Override
	public List<Revista> listaRevista() {
		return repository.findAll();
	}

	@Override
	public List<Revista> listaRevistaPorNombre(String nombre) {
		return repository.listaRevistaPorNombre(nombre);
	}

	@Override
	public List<Revista> listaRevistaPorNombreIgual(String nombre) {
		return repository.listaRevistaPorNombreIgual(nombre);
	}

	

}


