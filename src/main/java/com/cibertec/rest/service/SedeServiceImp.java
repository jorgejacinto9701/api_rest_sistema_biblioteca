package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Sede;
import com.cibertec.rest.repository.SedeRepository;

@Service
public class SedeServiceImp implements SedeService {

	@Autowired
	private SedeRepository Repository;

	@Override
	public List<Sede> listaTodos() {
		return Repository.findAll();

	}

	@Override
	public Sede registra(Sede obj) {
		return Repository.save(obj);
	}

}
