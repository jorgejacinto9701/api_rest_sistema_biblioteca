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

import com.cibertec.rest.entity.Producto;
import com.cibertec.rest.service.ProductoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService servicio;

	@GetMapping()
	public ResponseEntity<List<Producto>> listaProducto() {
		log.info("METODO --> listaProducto");
		return ResponseEntity.ok(servicio.listaProducto());
	}

	@GetMapping("/porNombre")
	public ResponseEntity<List<Producto>> listaProductoPorNombre() {
		log.info("METODO --> listaProductoPorNombre");
		return ResponseEntity.ok(servicio.listaProducto());
	}
	
	
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(servicio.insertaActualizaProducto(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Producto> obj = servicio.buscarProductoPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Producto> actualiza(@RequestBody Producto Producto) {
		log.info("METODO --> actualiza " + Producto.getId());
		Optional<Producto> obj = servicio.buscarProductoPorId(Producto.getId());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaProducto(Producto));
		} else {
			log.error("Id " + Producto.getId() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Producto> obj = servicio.buscarProductoPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaProducto(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

}
