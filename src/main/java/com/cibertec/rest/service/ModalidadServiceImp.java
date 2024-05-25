package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Modalidad;
import com.cibertec.rest.repository.ModalidadRepository;

@Service
public class ModalidadServiceImp implements ModalidadService {

	@Autowired
	private ModalidadRepository Repository;

	@Override
	public List<Modalidad> listaTodos() {
		return Repository.findAll();

	}

	@Override
	public Modalidad registra(Modalidad obj) {
		return Repository.save(obj);
	}
}
