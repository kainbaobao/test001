package com.sxt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sxt.constant.WacaiConstant;
import com.sxt.dao.AccountMapper;
import com.sxt.model.MessageModel;
import com.sxt.po.Account;
import com.sxt.query.AccountQuery;
import com.sxt.service.BaseService;


@Service
public class AccountServiceImpl extends BaseService<Account>{
	
	@Resource
	private AccountMapper accountMapper;
	
	public Account queryAccountById(int id){
		Account account =null;
		account = queryById(id);
		return account;
	}

	public MessageModel saveOrUpdateAccount(Account account) {
		MessageModel messageModel = new MessageModel();
		int result = 0;
		account.setUpdateTime(new Date());
		if(null==account.getId()){
			account.setUserId(1);
			account.setCreateTime(new Date());
			result=insert(account);
			if(result>0){
				messageModel.setMsg("添加账户成功！");
			}else{
				messageModel.setCode(WacaiConstant.FAILED_CODE);
				messageModel.setMsg("添加账户失败！");
			}
		}else{
			if(null==queryById(account.getId())){
				messageModel.setCode(WacaiConstant.FAILED_CODE);
				messageModel.setMsg("待更新的记录不存在");
				return messageModel;
			}else{			
			  result=	update(account);
			  
			  if(result>0){
				  messageModel.setMsg("账户记录更新成功!");
			  }else{
				  messageModel.setMsg("账户信息更新失败");
				  messageModel.setCode(WacaiConstant.FAILED_CODE);
			  }
			}			
		}
		return messageModel;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map queryAccountByParams(AccountQuery accountQuery) {
		Map map = new HashMap();
		
		PageInfo<Account> pageInfo = queryForPage(accountQuery);
		
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		return map;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MessageModel delAccountBatch(Integer[] ids){
		MessageModel messageModel = new MessageModel();
		if(null==ids||ids.length==0){
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("待删除记录不存在！");
			return messageModel;
		}
		
		Map map = new HashMap();
		map.put("ids", ids);
		int result = accountMapper.delAccountBatch(map);
		
		if(result>0){
			messageModel.setMsg("账户记录删除成功!");
		}else {
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("账户记录删除失败！");
		}
		
		
		
		return messageModel;
	}





}
