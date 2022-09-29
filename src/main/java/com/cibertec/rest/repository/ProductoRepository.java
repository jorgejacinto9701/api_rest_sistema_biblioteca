package com.cibertec.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.rest.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {


}
