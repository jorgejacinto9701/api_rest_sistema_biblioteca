package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.rest.entity.Alumno;
import com.cibertec.rest.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository repository; 
	
	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Alumno> buscarAlumnoPorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminaAlumno(int idAlumno) {
		repository.deleteById(idAlumno);
	}

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public List<Alumno> listaAlumnoPorNombre(String nombre) {
		return repository.listaPorNombre(nombre);
	}

	

}


