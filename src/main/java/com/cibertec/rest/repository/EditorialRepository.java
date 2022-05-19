package com.cibertec.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

	public List<Editorial> findByNombreLike(String nombre);

}
