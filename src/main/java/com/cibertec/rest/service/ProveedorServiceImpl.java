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
	private ProveedorRepository repository; 
	
	@Override
	public Proveedor insertaActualizaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Proveedor> buscarProveedorPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaProveedor(int idProveedor) {
		repository.deleteById(idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedor() {
		return repository.findAll();
	}

	@Override
	public List<Proveedor> listaProveedorPorRazonSocial(String razonSocial) {
		return repository.listaProveedorPorRazonSocial(razonSocial);
	}

	@Override
	public List<Proveedor> listaProveedorPorRazonSocialIgual(String razonSocial) {
		return repository.listaProveedorPorRazonSocialIgual(razonSocial);
	}

	@Override
	public List<Proveedor> listaProveedorPorRuc(String ruc) {
		return repository.listaProveedorPorRuc(ruc);
	}

	

}


