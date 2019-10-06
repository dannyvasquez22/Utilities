package com.admin.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception objException;
	private String codError;
	private String msjError;
	private String nombreSP;
	private String nombreBD;
	private String nombreWS;
    private String nombreQueue;

	public String getNombreQueue() {
		return nombreQueue;
	}

	public void setNombreQueue(String nombreQueue) {
		this.nombreQueue = nombreQueue;
	}

	public BaseException(String codError, String msjError, Exception objException, String nombreSP, String nombreBD) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
		this.objException = objException;
		this.nombreSP = nombreSP;
		this.nombreBD = nombreBD;
	}

	public BaseException(String codError, String msjError, Exception objException, String nombreWS) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
		this.objException = objException;
		this.nombreWS = nombreWS;
	}

	public BaseException(String codError, String msjError, Exception objException) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
		this.objException = objException;
	}

	public BaseException(String codError, String msjError) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
	}

	/**
	 * Constructores
	 */
	public BaseException(String codError, String message, Throwable exception) {
		super(message, exception);
		this.codError = codError;
	}

	/**
	 * Constructores
	 */
	public BaseException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Constructores
	 */
	public BaseException(Exception exception) {
		super(exception);
	}

	public BaseException(String msjError) {
		super(msjError);
		this.msjError = msjError;
	}

	public Exception getObjException() {
		return objException;
	}

	public void setObjException(Exception objException) {
		this.objException = objException;
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	public String getNombreSP() {
		return nombreSP;
	}

	public void setNombreSP(String nombreSP) {
		this.nombreSP = nombreSP;
	}

	public String getNombreBD() {
		return nombreBD;
	}

	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}

	public String getNombreWS() {
		return nombreWS;
	}

	public void setNombreWS(String nombreWS) {
		this.nombreWS = nombreWS;
	}


}
