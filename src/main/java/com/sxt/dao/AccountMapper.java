package com.sxt.dao;

import java.util.Map;

import com.sxt.po.Account;

public interface AccountMapper extends BaseMapper<Account>{
	@SuppressWarnings("rawtypes")
	public int delAccountBatch(Map map);//批量删除账户记录
}