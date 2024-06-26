package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

	
	@Query("select e from Proveedor e where e.razonsocial like ?1")
	public List<Proveedor> listaProveedorPorRazonSocial(String nombre);

	@Query("select e from Proveedor e where UPPER(e.razonsocial) = UPPER(?1)")
	public List<Proveedor> listaProveedorPorRazonSocialIgual(String nombre);

	@Query("select e from Proveedor e where e.ruc = ?1")
	public List<Proveedor> listaProveedorPorRuc(String ruc);

}
