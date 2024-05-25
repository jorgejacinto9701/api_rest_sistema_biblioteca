package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.TipoProveedor;
import com.cibertec.rest.repository.TipoProveedorRepository;

@Service
public class TipoProveedorServiceImp implements TipoProveedorService {

	@Autowired
	private TipoProveedorRepository Repository;

	@Override
	public List<TipoProveedor> listaTodos() {
		return Repository.findAll();

	}
	
	@Override
	public TipoProveedor registra(TipoProveedor obj) {
		return Repository.save(obj);
	}


}
