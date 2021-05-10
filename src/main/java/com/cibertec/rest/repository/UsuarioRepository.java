package com.cibertec.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	

}
