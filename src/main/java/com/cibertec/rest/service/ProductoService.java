package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Producto;

public interface ProductoService {

	public Producto insertaActualizaProducto(Producto obj);
	public Optional<Producto> buscarProductoPorId(int id);
	public void eliminaProducto(int idProducto);
	public List<Producto> listaProducto();


}
