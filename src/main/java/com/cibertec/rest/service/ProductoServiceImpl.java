package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Producto;
import com.cibertec.rest.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Producto> buscarProductoPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaProducto(int idProducto) {
		repository.deleteById(idProducto);
	}

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}



}
