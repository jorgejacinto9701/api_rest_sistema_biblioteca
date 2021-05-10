package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Proveedor;

public interface ProveedorService {

	public Proveedor insertaActualizaProveedor(Proveedor obj);
	public Optional<Proveedor> buscarProveedorPorId(int id);
	public void eliminaProveedor(int idProveedor);
	public List<Proveedor> listaProveedor();

}
