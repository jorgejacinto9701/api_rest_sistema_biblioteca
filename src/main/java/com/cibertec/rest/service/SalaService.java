package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Sala;

public interface SalaService {

	public Sala insertaActualizaSala(Sala obj);
	public Optional<Sala> buscarSalaPorId(int id);
	public void eliminaSala(int idSala);
	public List<Sala> listaSala();
	public List<Sala> listaSalaPorNumero(String numero);
	public LIst<Sala> listaSalaPorNumeroIgual(String numero);
}
