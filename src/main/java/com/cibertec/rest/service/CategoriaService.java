package com.cibertec.rest.service;


import java.util.List;

import com.cibertec.rest.entity.Categoria;

public interface CategoriaService {

	public abstract List<Categoria> listaTodos();
	public abstract List<Categoria> listaTodosPorTipo(int tipo);
}
