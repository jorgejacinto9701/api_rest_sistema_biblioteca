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

import com.cibertec.rest.entity.Cliente;
import com.cibertec.rest.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService servicio;

	@GetMapping()
	public ResponseEntity<List<Cliente>> listaCliente() {
		log.info("METODO --> listaCliente");
		return ResponseEntity.ok(servicio.listaCliente());
	}
	
	@GetMapping("/porNombre")
	public ResponseEntity<List<Cliente>> listaClientePorNombre() {
		log.info("METODO --> listaClientePorNombre");
		return ResponseEntity.ok(servicio.listaCliente());
	}

	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Cliente>> listaClientePorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaClientePorNombre");
		return ResponseEntity.ok(servicio.listaClientePorNombre("%"+nombre+"%"));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaCliente(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Cliente> obj = servicio.buscarClientePorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Cliente> actualiza(@RequestBody Cliente Cliente) {
		log.info("METODO --> actualiza " + Cliente.getIdCliente());
		Optional<Cliente> obj = servicio.buscarClientePorId(Cliente.getIdCliente());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaCliente(Cliente));
		} else {
			log.error("Id " + Cliente.getIdCliente() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Cliente> obj = servicio.buscarClientePorId(id);
		if (obj.isPresent()) {
			servicio.eliminaCliente(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/porNombreIgual/{nombre}")
	public ResponseEntity<List<Cliente>> listaClientePorNombreLike(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaClientePorNombreLike");
		return ResponseEntity.ok(servicio.listaClientePorNombre(nombre));
	}

}
