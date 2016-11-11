package com.sxt.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.constant.WacaiConstant;
import com.sxt.model.MessageModel;
import com.sxt.po.Account;
import com.sxt.query.AccountQuery;
import com.sxt.service.impl.AccountServiceImpl;

@Controller
@RequestMapping("account")
public class AccountController extends BaseController{
	@Resource
	private AccountServiceImpl accountServiceImpl;
	
	@RequestMapping("queryAccountById")
	@ResponseBody
	public Account queryAccountById(int id){
		return accountServiceImpl.queryAccountById(id);
	}
	
	@RequestMapping("saveOrUpdateAccount")
	@ResponseBody
	public MessageModel saveOrUpdateAccount(Account account){
		MessageModel messageModel = new MessageModel();
		try {
			messageModel = accountServiceImpl.saveOrUpdateAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("账户添加失败，请稍候再试！");
		}
		return messageModel;
	}

	@RequestMapping("index")
	public String index(){
		return "account";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("queryAccountByParams")
	@ResponseBody
	public Map queryAccountByParams(AccountQuery accountQuery){
		Map map = accountServiceImpl.queryAccountByParams(accountQuery);
		return map;
	}
	
	@RequestMapping("delAccount")
	@ResponseBody
	public MessageModel delAccount(Integer[] ids){
		MessageModel messageModel = new MessageModel();
		try {
			messageModel = accountServiceImpl.delAccountBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("账户删除失败，请稍候再试！");
		}
		return messageModel;
	}
}
