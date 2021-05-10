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
	private AlumnoRepository repositorio; 
	
	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		return repositorio.save(obj);
	}

	@Override
	public Optional<Alumno> buscarAlumnoPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public void eliminaAlumno(int idAlumno) {
		repositorio.deleteById(idAlumno);
	}

	@Override
	public List<Alumno> listaAlumno() {
		return repositorio.findAll();
	}

	

}


