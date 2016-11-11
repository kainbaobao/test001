package com.sxt.model;



import com.sxt.constant.WacaiConstant;

public class MessageModel {
	
	private int code=WacaiConstant.SUCCESS_CODE;
	
	private String msg=WacaiConstant.SUCCESS_MSG;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
