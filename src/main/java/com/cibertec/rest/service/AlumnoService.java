package com.cibertec.rest.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.rest.entity.Alumno;

public interface AlumnoService {

	public Alumno insertaActualizaAlumno(Alumno obj);
	public Optional<Alumno> buscarAlumnoPorId(int id);
	public void eliminaAlumno(int idAlumno);
	public List<Alumno> listaAlumno();
	public List<Alumno> listaAlumnoPorNombre(String nombre);
}
