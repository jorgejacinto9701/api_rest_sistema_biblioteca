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

import com.cibertec.rest.entity.Editorial;
import com.cibertec.rest.service.EditorialService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/editorial")
public class EditorialRestController {

	@Autowired
	private EditorialService servicio;

	@GetMapping()
	public ResponseEntity<List<Editorial>> listaEditorial() {
		log.info("METODO --> listaEditorial");
		return ResponseEntity.ok(servicio.listaEditorial());
	}

	@GetMapping("/porNombre")
	public ResponseEntity<List<Editorial>> listaEditorialPorNombre() {
		log.info("METODO --> listaEditorialPorNombre");
		return ResponseEntity.ok(servicio.listaEditorial());
	}
	
	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Editorial>> listaEditorialPorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaEditorialPorNombre");
		return ResponseEntity.ok(servicio.listaEditorialPorNombre("%"+nombre+"%"));
	}

	
	@PostMapping
	public ResponseEntity<Editorial> registrar(@RequestBody Editorial obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaEditorial(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editorial> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Editorial> obj = servicio.buscarEditorialPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Editorial> actualiza(@RequestBody Editorial Editorial) {
		log.info("METODO --> actualiza " + Editorial.getIdEditorial());
		Optional<Editorial> obj = servicio.buscarEditorialPorId(Editorial.getIdEditorial());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaEditorial(Editorial));
		} else {
			log.error("Id " + Editorial.getIdEditorial() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Editorial> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Editorial> obj = servicio.buscarEditorialPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaEditorial(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}



@GetMapping("/porRazonSocialIgual/{razonSocial}")
	public ResponseEntity<List<Editorial>> listaEditorialPorNombre(@PathVariable("razonSocial")String razonSocial) {
		log.info("METODO --> listaEditorialPorRazonSocialigual");
		return ResponseEntity.ok(servicio.listaEditorialPorNombre("%"+nombre+"%"));
	}

	@GetMapping("/porRucIgual/{ruc}")
	public ResponseEntity<List<Editorial>> listaEditorialPorNombre(@PathVariable("ruc")String ruc) {
		log.info("METODO --> listaEditorialPorRucIgual");
		return ResponseEntity.ok(servicio.listaEditorialPorNombre("%"+nombre+"%"));
	}



}
