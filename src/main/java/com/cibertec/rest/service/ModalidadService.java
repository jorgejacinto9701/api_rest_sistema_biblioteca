package com.cibertec.rest.service;


import java.util.List;


import com.cibertec.rest.entity.Modalidad;

public interface ModalidadService {

	public abstract List<Modalidad> listaTodos();
	public abstract Modalidad registra(Modalidad obj);
}
