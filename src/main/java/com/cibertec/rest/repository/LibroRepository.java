package com.cibertec.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	

}
