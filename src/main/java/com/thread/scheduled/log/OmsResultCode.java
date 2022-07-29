package com.thread.scheduled.log;

public enum OmsResultCode {

	SUCCESS("20000000", "OK")
	,SERVICE_DB_ERROR("40000001","내부 DB 오류입니다.")
	,SERVICE_KAFKA_ERROR("40000010", "KAFKA 전송 오류입니다.")
	,SERVICE_KAFKA_TIMEOUT("50000001", "KAFKA connection 연결 오류입니다.")
	,SERVICE_INTERNAL_ERROR("50009999", "정의되지 않는 오류입니다.");

	private String value;
	private String logMsg;

	OmsResultCode(String value, String logMsg){
		this.value = value;
		this.logMsg = logMsg;
	}
	
	public String value() {
		return this.value;
	}
	
	public String logMsg() {
		return this.logMsg;
	}
}
