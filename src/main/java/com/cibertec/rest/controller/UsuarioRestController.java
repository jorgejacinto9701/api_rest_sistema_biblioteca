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

import com.cibertec.rest.entity.Usuario;
import com.cibertec.rest.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService servicio;

	@GetMapping()
	public ResponseEntity<List<Usuario>> listaUsuario() {
		log.info("METODO --> listaUsuario");
		return ResponseEntity.ok(servicio.listaUsuario());
	}

	@GetMapping("/porNombre")
	public ResponseEntity<List<Usuario>> listaUsuarioPorNombre() {
		log.info("METODO --> listaUsuarioPorNombre");
		return ResponseEntity.ok(servicio.listaUsuario());
	}
	
	@GetMapping("/porNombre/{nombre}")
	public ResponseEntity<List<Usuario>> listaUsuarioPorNombre(@PathVariable("nombre")String nombre) {
		log.info("METODO --> listaUsuarioPorNombre");
		return ResponseEntity.ok(servicio.listaUsuarioPorNombre("%"+nombre+"%"));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(servicio.insertaActualizaUsuario(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Usuario> obj = servicio.buscarUsuarioPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Usuario> actualiza(@RequestBody Usuario Usuario) {
		log.info("METODO --> actualiza " + Usuario.getIdUsuario());
		Optional<Usuario> obj = servicio.buscarUsuarioPorId(Usuario.getIdUsuario());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaUsuario(Usuario));
		} else {
			log.error("Id " + Usuario.getIdUsuario() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Usuario> obj = servicio.buscarUsuarioPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaUsuario(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

}
