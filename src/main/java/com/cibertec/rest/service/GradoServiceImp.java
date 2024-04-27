package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Grado;
import com.cibertec.rest.entity.Pais;
import com.cibertec.rest.repository.GradoRepository;

@Service
public class GradoServiceImp implements GradoService {

	@Autowired
	private GradoRepository Repository;

	@Override
	public List<Grado> listaTodos() {
		return Repository.findAll();

	}
	@Override
	public Grado registra(Grado obj) {
		return Repository.save(obj);
	}
}
