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

import com.cibertec.rest.entity.Sala;
import com.cibertec.rest.service.SalaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/sala")
public class SalaRestController {

	@Autowired
	private SalaService servicio;

	@GetMapping()
	public ResponseEntity<List<Sala>> listaSala() {
		log.info("METODO --> listaSala");
		return ResponseEntity.ok(servicio.listaSala());
	}
	
	@GetMapping("/porNumero")
	public ResponseEntity<List<Sala>> listaSalaPorNumero() {
		log.info("METODO --> listaSalaPorNumero");
		return ResponseEntity.ok(servicio.listaSala());
	}
	
	@GetMapping("/porNumero/{numero}")
	public ResponseEntity<List<Sala>> listaSalaPorNumero(@PathVariable("numero")String numero) {
		log.info("METODO --> listaSalaPorNumero");
		return ResponseEntity.ok(servicio.listaSalaPorNumero("%"+numero+"%"));
	}

	@PostMapping
	public ResponseEntity<Sala> registrar(@RequestBody Sala obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaSala(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sala> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Sala> obj = servicio.buscarSalaPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Sala> actualiza(@RequestBody Sala Sala) {
		log.info("METODO --> actualiza " + Sala.getIdSala());
		Optional<Sala> obj = servicio.buscarSalaPorId(Sala.getIdSala());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaSala(Sala));
		} else {
			log.error("Id " + Sala.getIdSala() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Sala> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Sala> obj = servicio.buscarSalaPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaSala(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

}
