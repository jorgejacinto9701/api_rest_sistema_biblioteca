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

import com.cibertec.rest.entity.Libro;
import com.cibertec.rest.service.LibroService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/libro")
public class LibroRestController {

	@Autowired
	private LibroService servicio;

	@GetMapping()
	public ResponseEntity<List<Libro>> listaLibro() {
		log.info("METODO --> listaLibro");
		return ResponseEntity.ok(servicio.listaLibro());
	}

	@GetMapping("/porTitulo")
	public ResponseEntity<List<Libro>> listaLibroPorTitulo() {
		log.info("METODO --> listaLibroPorNombre");
		return ResponseEntity.ok(servicio.listaLibro());
	}
	
	@GetMapping("/porTitulo/{nombre}")
	public ResponseEntity<List<Libro>> listaLibroPorTitulo(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaLibroPorNombre");
		return ResponseEntity.ok(servicio.listaLibroPorTitulo("%"+nombre+"%"));
	}
	
	@PostMapping
	public ResponseEntity<Libro> registrar(@RequestBody Libro obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaLibro(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Libro> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Libro> obj = servicio.buscarLibroPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Libro> actualiza(@RequestBody Libro Libro) {
		log.info("METODO --> actualiza " + Libro.getIdLibro());
		Optional<Libro> obj = servicio.buscarLibroPorId(Libro.getIdLibro());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaLibro(Libro));
		} else {
			log.error("Id " + Libro.getIdLibro() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Libro> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Libro> obj = servicio.buscarLibroPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaLibro(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/porTituloIgual/{titulo}")
	public ResponseEntity<Libro> listaLibroPorTitulo(@PathVariable ("titulo")String titulo) {
		log.info("METODO --> listaLibroPorTitulo");
		return ResponseEntity.ok(service.listaLibroPorTitulo("%"+titulo+"%"))
	}
}
