package com.cibertec.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idProveedor;
	private String nombres;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private String correo;
	private String pais;


}
