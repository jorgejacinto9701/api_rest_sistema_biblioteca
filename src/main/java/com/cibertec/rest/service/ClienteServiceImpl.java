package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Cliente;
import com.cibertec.rest.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository; 
	
	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Cliente> buscarClientePorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaCliente(int idCliente) {
		repository.deleteById(idCliente);
	}

	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}

	@Override
	public List<Cliente> listaClientePorNombre(String nombre) {
		return repository.listaPorNombre(nombre);
	}

	

}


