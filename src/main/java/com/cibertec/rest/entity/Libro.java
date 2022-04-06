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
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date fechacreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date fechaRegistro;
	
	private int estado;
}
