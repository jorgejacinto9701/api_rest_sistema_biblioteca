package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.rest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select e from Usuario e where e.nombre like ?1")
	public List<Usuario> listaUsuarioPorNombre(String nombre);

	
	@Query("select e from Usuario e where UPPER(e.nombre) = UPPER(?1)  and UPPER(e.apellido) = UPPER(?2)")
	public List<Usuario> listaUsuarioPorNombreApellido(String nombre, String apellido);
}
