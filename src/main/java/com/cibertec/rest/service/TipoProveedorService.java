package com.cibertec.rest.service;


import java.util.List;


import com.cibertec.rest.entity.TipoProveedor;

public interface TipoProveedorService {

	public abstract List<TipoProveedor> listaTodos();
	public abstract TipoProveedor registra(TipoProveedor obj);
}
