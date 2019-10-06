package com.admin.client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class ExchangeRate {

	private String tc_fecha;
	private double tc_compra;
	private double tc_venta;
}
