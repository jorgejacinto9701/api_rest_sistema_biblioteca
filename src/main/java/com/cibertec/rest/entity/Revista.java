package com.cibertec.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "revista")
@Getter
@Setter
public class Revista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idRevista;
	private String nombre;
	private String frecuencia;
	private String pais;
	private int estado;
	
}
