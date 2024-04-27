package com.cibertec.rest.service;


import java.util.List;

import com.cibertec.rest.entity.Pais;
import com.cibertec.rest.entity.Sede;

public interface SedeService {

	public abstract List<Sede> listaTodos();
	public abstract Sede registra(Sede obj);
}
