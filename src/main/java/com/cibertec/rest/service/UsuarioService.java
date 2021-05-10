package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Usuario;

public interface UsuarioService {

	public Usuario insertaActualizaUsuario(Usuario obj);
	public Optional<Usuario> buscarUsuarioPorId(int id);
	public void eliminaUsuario(int idUsuario);
	public List<Usuario> listaUsuario();

}
