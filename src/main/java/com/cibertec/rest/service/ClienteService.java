package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Cliente;

public interface ClienteService {

	public Cliente insertaActualizaCliente(Cliente obj);
	public Optional<Cliente> buscarClientePorId(int id);
	public void eliminaCliente(int idCliente);
	public List<Cliente> listaCliente();
	public List<Cliente> listaClientePorNombre(String nombre);
	public List<Cliente> listaClientePorNombreIgual(String nombre);
}
