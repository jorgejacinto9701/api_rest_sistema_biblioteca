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
	private UsuarioRepository repositorio; 
	
	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaUsuario(int idUsuario) {
		repositorio.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return repositorio.findAll();
	}

	

}


