package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Usuario;
import com.cibertec.rest.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository; 
	
	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaUsuario(int idUsuario) {
		repository.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public List<Usuario> listaUsuarioPorNombre(String numero) {
		return repository.listaUsuarioPorNombre(numero);
	}

	

}


