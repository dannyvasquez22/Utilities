package com.admin.exception;

public class JmsException extends BaseException{
	
	private static final long serialVersionUID = 1L;
	
	public JmsException(String codError, String msjError,
			Exception objException) {
		super(codError, msjError, objException);

	}
	public JmsException(String codError, String msjError) {
		super(codError, msjError);

	}
	
	public JmsException(String msjError) {
		super(msjError);
	}

}
