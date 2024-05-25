package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

	
	@Query("select e from Autor e where e.nombres like ?1")
	public List<Autor> listaPorNombre(String nombre);


	@Query("select e from Autor e where e.nombres like ?1") 

    public List<Autor> listaAutorPorNombre(String nombre); 

 
 

    @Query("select e from Autor e where e.nombres = ?1 and e.apellidos = ?2") 

    public List<Autor> listaPorNombreApellidoIgual(String nombre, String apellido); 

 

}
