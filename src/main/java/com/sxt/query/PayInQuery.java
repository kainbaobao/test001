package com.sxt.query;

public class PayInQuery extends BaseQuery{
	private String p_name;
	
	private String p_type;
	
	private String p_time;

	public String getp_name() {
		return p_name;
	}

	public void setp_name(String p_name) {
		this.p_name = p_name;
	}

	public String getp_type() {
		return p_type;
	}

	public void setp_type(String p_type) {
		this.p_type = p_type;
	}

	public String getp_time() {
		return p_time;
	}

	public void setp_time(String p_time) {
		this.p_time = p_time;
	}
	
	

}
