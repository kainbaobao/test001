package com.sxt.service;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		float s=1.22f;
		double ss=22;
		System.out.println(1.22+22.0);
		
		BigDecimal bigDecimal=new BigDecimal(Double.toString(s));
		
		BigDecimal bigDecimal2=new BigDecimal(Double.toString(ss));
		
		
		System.out.println(bigDecimal.add(bigDecimal2));
		


	}

}
