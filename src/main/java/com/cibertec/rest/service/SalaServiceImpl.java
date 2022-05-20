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
	private SalaRepository repository; 
	
	@Override
	public Sala insertaActualizaSala(Sala obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Sala> buscarSalaPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaSala(int idSala) {
		repository.deleteById(idSala);
	}

	@Override
	public List<Sala> listaSala() {
		return repository.findAll();
	}

	@Override
	public List<Sala> listaSalaPorNumero(String numero) {
		return repository.listaSalaPorNumero(numero);
	}

	

}


