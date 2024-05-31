package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select e from Cliente e where e.nombre like ?1")
	public List<Cliente> listaPorNombre(String nombre);

	@Query("select e from Cliente e where UPPER(e.nombre) = UPPER(?1)")
	public List<Cliente> listaPorNombreIgual(String nombre);

}
