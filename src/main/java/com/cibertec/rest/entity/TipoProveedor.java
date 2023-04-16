package com.cibertec.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_proveedor")
public class TipoProveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoProveedor;
	private String descripcion;

}
