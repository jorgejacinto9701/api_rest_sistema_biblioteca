package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Revista;

public interface RevistaService {

	public Revista insertaActualizaRevista(Revista obj);
	public Optional<Revista> buscarRevistaPorId(int id);
	public void eliminaRevista(int idRevista);
	public List<Revista> listaRevista();

}
