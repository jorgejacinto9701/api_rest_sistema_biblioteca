package com.cibertec.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.rest.entity.Categoria;
import com.cibertec.rest.entity.Grado;
import com.cibertec.rest.entity.Modalidad;
import com.cibertec.rest.entity.Pais;
import com.cibertec.rest.service.CategoriaService;
import com.cibertec.rest.service.GradoService;
import com.cibertec.rest.service.ModalidadService;
import com.cibertec.rest.service.PaisService;

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
	

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		log.info("METODO --> listaPais");
		return paisService.listaTodos();
	}

	@GetMapping("/listaCategoria")
	@ResponseBody
	public List<Categoria> listaCategoria() {
		log.info("METODO --> listaCategoria");
		return categoriaService.listaTodos();
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
}
