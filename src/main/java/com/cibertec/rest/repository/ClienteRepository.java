package com.cibertec.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Alumno;

public interface ClienteRepository extends JpaRepository<Alumno, Integer> {

	

}
