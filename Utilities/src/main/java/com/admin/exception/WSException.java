package com.admin.exception;

public class WSException extends BaseException {

	private static final long serialVersionUID = 1L;
	private String nombreWS;
	private String nombreMetodo;

	public WSException(String codError, String nombreWS, String msjError, String nombreMetodo, Exception objException) {
		super(codError, msjError, objException);
		this.nombreWS = nombreWS;
		this.nombreMetodo = nombreMetodo;
	}

	public WSException(String codError, String nombreWS, String msjError, String nombreMetodo, Throwable objException) {
		super(codError, msjError, objException);
		this.nombreWS = nombreWS;
		this.nombreMetodo = nombreMetodo;
	}

	public WSException(String msjError, Exception objException) {
		super(msjError, objException);
	}

	public WSException(Exception objException) {
		super(objException);
	}

	public WSException(String msjError) {
		super(msjError);
	}

	public String getNombreWS() {
		return nombreWS;
	}

	public void setNombreWS(String nombreWS) {
		this.nombreWS = nombreWS;
	}

	public String getNombreMetodo() {
		return nombreMetodo;
	}

	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}

}
