package com.cibertec.rest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	private int capacidad;
	private String recursos;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaSeparacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date fechaRegistro;

	private int estado;
}
