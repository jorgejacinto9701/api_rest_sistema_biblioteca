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

import com.cibertec.rest.entity.Autor;
import com.cibertec.rest.service.AutorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/autor")
public class AutorRestController {

	@Autowired
	private AutorService servicio;

	@GetMapping()
	public ResponseEntity<List<Autor>> listaAutor() {
		log.info("METODO --> listaAutor");
		return ResponseEntity.ok(servicio.listaAutor());
	}

	@GetMapping("/porNombre")
	public ResponseEntity<List<Autor>> listaAutorPorNombre() {
		log.info("METODO --> listaAutorPorNombre");
		return ResponseEntity.ok(servicio.listaAutor());
	}
	
	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Autor>> listaAutorPorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaAutorPorNombre");
		return ResponseEntity.ok(servicio.listaAutorPorNombre("%"+nombre+"%"));
	}
	
	@PostMapping
	public ResponseEntity<Autor> registrar(@RequestBody Autor obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaAutor(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Autor> obj = servicio.buscarAutorPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Autor> actualiza(@RequestBody Autor Autor) {
		log.info("METODO --> actualiza " + Autor.getIdAutor());
		Optional<Autor> obj = servicio.buscarAutorPorId(Autor.getIdAutor());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaAutor(Autor));
		} else {
			log.error("Id " + Autor.getIdAutor() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Autor> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Autor> obj = servicio.buscarAutorPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaAutor(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

}
