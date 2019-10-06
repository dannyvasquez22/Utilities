package com.admin.client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class UserSunat {

	private String numero_documento;
	private String tipo_documento;
	private String nombres;
	private String tipo_contribuyente;
	private String nombre_comercial;
	private String fecha_inscripcion;
	private String fecha_ini_actividades;
	private String estado_contribuyente;
	private String condicion_contribuyente;
	private String profesion;
}
