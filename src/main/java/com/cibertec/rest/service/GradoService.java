package com.cibertec.rest.service;


import java.util.List;

import com.cibertec.rest.entity.Grado;
import com.cibertec.rest.entity.Pais;

public interface GradoService {

	public abstract List<Grado> listaTodos();
	public abstract Grado registra(Grado obj);
}
