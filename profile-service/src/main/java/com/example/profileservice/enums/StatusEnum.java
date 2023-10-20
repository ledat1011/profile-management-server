package com.example.profileservice.enums;

public enum StatusEnum {

	NA("NA",0),
	SUCCESS("Success",1),
	FAIL("Fail",2);
	
	
	private Integer status;
	private String statusText;
	
	StatusEnum(String statusText,Integer status){
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public String getStatusText() {
		return this.statusText;
	}
}
