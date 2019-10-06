package com.admin.client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class UserReniec {

	private String nombres;
	private String numero_documento;
	private String grupo_votacion;
	private String distrito;
	private String provincia;
	private String departamento;
}
