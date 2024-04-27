package com.cibertec.rest.service;


import java.util.List;

import com.cibertec.rest.entity.Categoria;
import com.cibertec.rest.entity.TipoProveedor;

public interface CategoriaService {

	public abstract List<Categoria> listaTodos();
	public abstract List<Categoria> listaTodosPorTipo(int tipo);
	public abstract Categoria registra(Categoria obj);
}
