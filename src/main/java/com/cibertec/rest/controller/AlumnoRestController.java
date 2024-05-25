package com.cibertec.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.rest.entity.Alumno;
import com.cibertec.rest.service.AlumnoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/alumno")
public class AlumnoRestController {

	@Autowired
	private AlumnoService servicio;

	@GetMapping()
	public ResponseEntity<List<Alumno>> listaAlumno() {
		log.info("METODO --> listaAlumno");
		return ResponseEntity.ok(servicio.listaAlumno());
	}
	
	@GetMapping("/porNombre")
	public ResponseEntity<List<Alumno>> listaAlumnoPorNombre() {
		log.info("METODO --> listaAlumnoPorNombre");
		return ResponseEntity.ok(servicio.listaAlumno());
	}

	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Alumno>> listaAlumnoPorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaAlumnoPorNombre");
		return ResponseEntity.ok(servicio.listaAlumnoPorNombre("%"+nombre+"%"));
	}
	
	@PostMapping
	public ResponseEntity<Alumno> registrar(@RequestBody Alumno obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaAlumno(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Alumno> obj = servicio.buscarAlumnoPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Alumno> actualiza(@RequestBody Alumno alumno) {
		log.info("METODO --> actualiza " + alumno.getIdAlumno());
		Optional<Alumno> obj = servicio.buscarAlumnoPorId(alumno.getIdAlumno());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaAlumno(alumno));
		} else {
			log.error("Id " + alumno.getIdAlumno() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Alumno> obj = servicio.buscarAlumnoPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaAlumno(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/porNombreApellidoIgual/{nombre}{apellidos}")
	public ResponseEntity<List<Alumno>> listaPorNombreApellidoIgual(@PathVariable("nombre,apellidos")String nombre, String apellidos) {
		log.info("METODO --> listaPorNombreApellidoIgual");
		return ResponseEntity.ok(servicio.listaPorNombreApellidoIgual("%"+nombre+"%"+apellidos+"%"));
	}

}
