package com.cibertec.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Pais;
import com.cibertec.rest.repository.PaisRepository;

@Service
public class SedeServiceImp implements PaisService {

	@Autowired
	private PaisRepository Repository;

	@Override
	public List<Pais> listaTodos() {
		return Repository.findAll();

	}

}
