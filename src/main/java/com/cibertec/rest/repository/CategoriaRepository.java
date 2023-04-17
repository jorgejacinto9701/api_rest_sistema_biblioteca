package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	public List<Categoria> findByTipo(int tipo);

}
