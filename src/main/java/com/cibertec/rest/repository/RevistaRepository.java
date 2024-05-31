package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer> {

	
	@Query("select e from Revista e where e.nombre like ?1")
	public List<Revista> listaRevistaPorNombre(String nombre);
	
	
	@Query("select e from Revista e where UPPER(e.nombre) = UPPER(?1)")
	public List<Revista> listaRevistaPorNombreIgual(String nombre);
}
