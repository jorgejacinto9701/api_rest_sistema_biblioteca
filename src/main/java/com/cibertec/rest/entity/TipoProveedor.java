package com.cibertec.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
