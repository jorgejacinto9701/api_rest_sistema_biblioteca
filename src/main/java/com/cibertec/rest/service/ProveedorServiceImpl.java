package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Proveedor;
import com.cibertec.rest.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository repositorio; 
	
	@Override
	public Proveedor insertaActualizaProveedor(Proveedor obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Proveedor> buscarProveedorPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaProveedor(int idProveedor) {
		repositorio.deleteById(idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedor() {
		return repositorio.findAll();
	}

	

}


