package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

	@Query("select e from Sala e where e.numero like ?1")
	public List<Sala> listaSalaPorNumero(String nombre);

	@Query("select e from Sala e where UPPER(e.numero) = UPPER(?1) ")
	public List<Sala> listaSalaPorNumeroIgual(String nombre);
	
}
