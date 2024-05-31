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

import com.cibertec.rest.entity.Proveedor;
import com.cibertec.rest.service.ProveedorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/proveedor")
public class ProveedorRestController {

	@Autowired
	private ProveedorService servicio;

	@GetMapping()
	public ResponseEntity<List<Proveedor>> listaProveedor() {
		log.info("METODO --> listaProveedor");
		return ResponseEntity.ok(servicio.listaProveedor());
	}

	@GetMapping("/porRazonSocial")
	public ResponseEntity<List<Proveedor>> listaProveedorPorRazonSocial() {
		log.info("METODO --> listaProveedor");
		return ResponseEntity.ok(servicio.listaProveedor());
	}

	@GetMapping("/porRazonSocial/{razSoc}")
	public ResponseEntity<List<Proveedor>> listaProveedorPorRazonSocial(@PathVariable("razSoc") String nombre) {
		log.info("METODO --> listaProveedorPorRazonSocial");
		return ResponseEntity.ok(servicio.listaProveedorPorRazonSocial("%" + nombre + "%"));
	}

	@PostMapping
	public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor obj) {
		log.info("METODO --> registrar");
		obj.setFechaRegistro(new Date());
		return ResponseEntity.ok(servicio.insertaActualizaProveedor(obj));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> buscarPorId(@PathVariable int id) {
		log.info("METODO --> buscarPorId " + id);
		Optional<Proveedor> obj = servicio.buscarProveedorPorId(id);
		if (obj.isPresent()) {
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<Proveedor> actualiza(@RequestBody Proveedor Proveedor) {
		log.info("METODO --> actualiza " + Proveedor.getIdProveedor());
		Optional<Proveedor> obj = servicio.buscarProveedorPorId(Proveedor.getIdProveedor());
		if (obj.isPresent()) {
			return ResponseEntity.ok(servicio.insertaActualizaProveedor(Proveedor));
		} else {
			log.error("Id " + Proveedor.getIdProveedor() + " is no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Proveedor> elimina(@PathVariable int id) {
		log.info("METODO --> elimina " + id);
		Optional<Proveedor> obj = servicio.buscarProveedorPorId(id);
		if (obj.isPresent()) {
			servicio.eliminaProveedor(id);
			return ResponseEntity.ok(obj.get());
		} else {
			log.error("Id " + id + " no existe");
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/porRazonSocialIgual/{razSoc}")
	public ResponseEntity<List<Proveedor>> listaProveedorPorRazonSocialIgual(@PathVariable("razSoc") String nombre) {
		log.info("METODO --> listaProveedorPorRazonSocial");
		return ResponseEntity.ok(servicio.listaProveedorPorRazonSocialIgual(nombre));
	}

	@GetMapping("/porRucIgual/{ruc}")
	public ResponseEntity<List<Proveedor>> listaProveedorPorRuc(@PathVariable("ruc") String ruc) {
		log.info("METODO --> listaProveedorPorRuc");
		return ResponseEntity.ok(servicio.listaProveedorPorRuc(ruc));
	}

}
