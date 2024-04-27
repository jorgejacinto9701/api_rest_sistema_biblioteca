package com.cibertec.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.rest.entity.Categoria;
import com.cibertec.rest.entity.Grado;
import com.cibertec.rest.entity.Modalidad;
import com.cibertec.rest.entity.Pais;
import com.cibertec.rest.entity.Sede;
import com.cibertec.rest.entity.TipoProveedor;
import com.cibertec.rest.service.CategoriaService;
import com.cibertec.rest.service.GradoService;
import com.cibertec.rest.service.ModalidadService;
import com.cibertec.rest.service.PaisService;
import com.cibertec.rest.service.SedeService;
import com.cibertec.rest.service.TipoProveedorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/servicio/util")
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private GradoService gradoService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private TipoProveedorService tipoProveedorService;

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		log.info("METODO --> listaPais");
		return paisService.listaTodos();
	}

	
	
	@GetMapping("/listaCategoriaDeLibro")
	@ResponseBody
	public List<Categoria> listaCategoriaDeLibro() {
		log.info("METODO --> listaCategoriaDeLibro");
		return categoriaService.listaTodosPorTipo(1);
	}
	
	@GetMapping("/listaCategoriaDeEditorial")
	@ResponseBody
	public List<Categoria> listaCategoriaDeEditorial() {
		log.info("METODO --> listaCategoriaDeEditorial");
		return categoriaService.listaTodosPorTipo(2);
	}
	
	@GetMapping("/listaGrado")
	@ResponseBody
	public List<Grado> listaGrado() {
		log.info("METODO --> listaGrado");
		return gradoService.listaTodos();
	}


	@GetMapping("/listaModalidad")
	@ResponseBody
	public List<Modalidad> listaModalidad() {
		log.info("METODO --> listaModalidad");
		return modalidadService.listaTodos();
				
	}
	
	@GetMapping("/listaSede")
	@ResponseBody
	public List<Sede> listaSede() {
		log.info("METODO --> listaSede");
		return sedeService.listaTodos();
				
	}
	
	@GetMapping("/listaTipoProveedor")
	@ResponseBody
	public List<TipoProveedor> listaTipoProveedor() {
		log.info("METODO --> listaTipoProveedor");
		return tipoProveedorService.listaTodos();
				
	}
	
	@PostMapping("/registraPais")
	public ResponseEntity<Pais> registrar(@RequestBody Pais obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(paisService.registra(obj));
	}

	
	@PostMapping("/registraGrado")
	public ResponseEntity<Grado> registrar2(@RequestBody Grado obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(gradoService.registra(obj));
	}

	
	@PostMapping("/registraModalidad")
	public ResponseEntity<Modalidad> registrar3(@RequestBody Modalidad obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(modalidadService.registra(obj));
	}
	
	@PostMapping("/registraSede")
	public ResponseEntity<Sede> registrar4(@RequestBody Sede obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(sedeService.registra(obj));
	}
	
	@PostMapping("/registraTipoProveedor")
	public ResponseEntity<TipoProveedor> registrar5(@RequestBody TipoProveedor obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(tipoProveedorService.registra(obj));
	}
	
	@PostMapping("/registraCategoria")
	public ResponseEntity<Categoria> registrar6(@RequestBody Categoria obj) {
		log.info("METODO --> registrar");
		return ResponseEntity.ok(categoriaService.registra(obj));
	}
	
}
