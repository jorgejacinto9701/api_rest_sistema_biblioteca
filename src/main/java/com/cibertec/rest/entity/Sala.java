package com.cibertec.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sala")
@Getter
@Setter
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idSala;
	private String numero;
	private int piso;
	private String capacidad;
	private String recursos;
	private int estado;


}
