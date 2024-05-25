package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("select e from Alumno e where e.nombres like ?1")
	public List<Alumno> listaPorNombre(String nombre);

	@Query("select e from Alumno e where e.nombres = ?1 and e.apellidos = ?2 ")
	public List<Alumno> listaPorNombreApellidoIgual(String nombre, String apellido);


}
