package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Autor;

public interface AutorService {

	public Autor insertaActualizaAutor(Autor obj);
	public Optional<Autor> buscarAutorPorId(int id);
	public void eliminaAutor(int idAutor);
	public List<Autor> listaAutor();
	public List<Autor> listaAutorPorNombre(String nombre);
	public List<Autor> listaPorNombreApellidoIgual(String nombre, String apellidos);
}
