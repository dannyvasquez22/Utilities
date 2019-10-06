package com.admin.client.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor @ToString
public class ClienteRequest {
	
	private String razonSocial;
	@NonNull
	private String ruc;

}
