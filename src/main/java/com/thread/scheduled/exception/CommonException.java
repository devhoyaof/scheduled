package com.thread.scheduled.exception;

import com.thread.scheduled.log.OmsResultCode;

public class CommonException extends RuntimeException{

	private OmsResultCode omsResultCode;		// OMS Result Code
	private String logMsg = "";			// Service log message
	
	public OmsResultCode getOmsResultCode() {
		return omsResultCode;
	}
	public String getLogMsg() {
		return logMsg;
	}
	
	public CommonException(OmsResultCode resultCode, Throwable cause) {
		super(resultCode.logMsg(), cause);
		
		this.omsResultCode = resultCode;
		this.logMsg = resultCode.logMsg();
	}

	public CommonException(String msg, OmsResultCode resultCode, Throwable cause) {
		super(msg, cause);

		this.omsResultCode = resultCode;
		this.logMsg = msg;
	}


	public CommonException(OmsResultCode resultCode) {
		this.omsResultCode = resultCode;
		this.logMsg = resultCode.logMsg();
	}


	public CommonException(String resultCode){
		this.omsResultCode = OmsResultCode.valueOf(resultCode);
		this.logMsg = OmsResultCode.valueOf(resultCode).logMsg();
	}
	
}
