package com.cibertec.rest.service;


import java.util.List;

import com.cibertec.rest.entity.Pais;

public interface PaisService {

	public abstract List<Pais> listaTodos();
	public abstract Pais registra(Pais obj);
	

}
