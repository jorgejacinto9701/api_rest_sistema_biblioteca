package com.cibertec.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libro")
@Getter
@Setter
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idLibro;
	private String titulo;
	private int anio;
	private String categoria;
	private String serie;
	
	
}
