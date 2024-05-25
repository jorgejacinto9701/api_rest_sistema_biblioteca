package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Libro;

public interface LibroService {

	public Libro insertaActualizaLibro(Libro obj);
	public Optional<Libro> buscarLibroPorId(int id);
	public void eliminaLibro(int idLibro);
	public List<Libro> listaLibro();
	public List<Libro> listaLibroPorTitulo(String nombre);

	//Sesión 8
	public List<Libro> listaLibroPorTituloIgual(String titulo);
}
