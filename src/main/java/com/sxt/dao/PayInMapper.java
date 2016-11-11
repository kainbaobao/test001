package com.sxt.dao;

import java.util.Map;

import com.sxt.dto.PayIn;

public interface PayInMapper extends BaseMapper<PayIn>{
	@SuppressWarnings("rawtypes")
	public int delPayInBatch(Map map);//批量删除账户记录
}