package com.cibertec.rest.controller;

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

import com.cibertec.rest.entity.Revista;
import com.cibertec.rest.service.RevistaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/revista")
public class RevistaRestController {

	@Autowired
	private RevistaService servicio;

	@GetMapping()
	public ResponseEntity<List<Revista>> listaRevista() {
		log.info("METODO --> listaRevista");
		return ResponseEntity.ok(servicio.listaRevista());
	}
	
	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Revista>> listaRevistaPorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaRevistaPorNombre");
		return ResponseEntity.ok(servicio.listaRevistaPorNombre("%"+nombre+"%"));
	}
	

	@PostMapping
	public ResponseEntity<Revista> registrar(@RequestBody Revista obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(servicio.insertaActualizaRevista(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Revista> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Revista> obj = servicio.buscarRevistaPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Revista> actualiza(@RequestBody Revista Revista) {
		log.info("METODO --> actualiza " + Revista.getIdRevista());
		Optional<Revista> obj = servicio.buscarRevistaPorId(Revista.getIdRevista());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaRevista(Revista));
		} else {
			log.error("Id " + Revista.getIdRevista() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Revista> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Revista> obj = servicio.buscarRevistaPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaRevista(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

}
