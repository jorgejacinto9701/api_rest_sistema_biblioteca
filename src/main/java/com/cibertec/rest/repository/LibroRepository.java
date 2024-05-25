package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	@Query("select e from Libro e where e.titulo like ?1")
	public List<Libro> listaLibroPorTitulo(String nombre);

	@Query("select e from Libro e where e.titulo = ?1")
	public List<Libro> listaLibroPorTituloIgual(String nombre);

}
