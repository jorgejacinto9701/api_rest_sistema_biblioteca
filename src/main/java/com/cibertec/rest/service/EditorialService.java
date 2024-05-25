package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Editorial;

public interface EditorialService {

	public Editorial insertaActualizaEditorial(Editorial obj);
	public Optional<Editorial> buscarEditorialPorId(int id);
	public void eliminaEditorial(int idEditorial);
	public List<Editorial> listaEditorial();
	public List<Editorial> listaEditorialPorNombre(String nombre);


	public List<Editorial> listaEditorialPorRazonSocialigual(String razonSocial);
	public List<Editorial> listaEditorialPorRucigual(String ruc);


}

