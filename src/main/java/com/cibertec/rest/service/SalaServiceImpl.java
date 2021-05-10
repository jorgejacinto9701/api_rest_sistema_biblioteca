package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Sala;
import com.cibertec.rest.repository.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaRepository repositorio; 
	
	@Override
	public Sala insertaActualizaSala(Sala obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Sala> buscarSalaPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaSala(int idSala) {
		repositorio.deleteById(idSala);
	}

	@Override
	public List<Sala> listaSala() {
		return repositorio.findAll();
	}

	

}


