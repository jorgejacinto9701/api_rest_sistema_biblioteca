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
	private RevistaRepository repositorio; 
	
	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Revista> buscarRevistaPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaRevista(int idRevista) {
		repositorio.deleteById(idRevista);
	}

	@Override
	public List<Revista> listaRevista() {
		return repositorio.findAll();
	}

	

}


