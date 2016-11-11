package com.sxt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sxt.constant.WacaiConstant;
import com.sxt.dao.PayInMapper;
import com.sxt.dto.PayIn;
import com.sxt.model.MessageModel;
import com.sxt.query.PayInQuery;
import com.sxt.service.BaseService;


@Service
public class PayInServiceImpl extends BaseService<PayIn>{
	
	@Resource
	private PayInMapper payInMapper;
	
	public PayIn queryPayInById(int id){
		PayIn account =null;
		account = queryById(id);
		return account;
	}

	public MessageModel saveOrUpdatePayIn(PayIn payIn) {
		MessageModel messageModel = new MessageModel();
		int result = 0;
		payIn.setUpdateTime(new Date());
		if(null==payIn.getId()){
			payIn.setAid(1);
			payIn.setCreateTime(new Date());
			result=insert(payIn);
			if(result>0){
				messageModel.setMsg("添加账户成功！");
			}else{
				messageModel.setCode(WacaiConstant.FAILED_CODE);
				messageModel.setMsg("添加账户失败！");
			}
		}else{
			if(null==queryById(payIn.getId())){
				messageModel.setCode(WacaiConstant.FAILED_CODE);
				messageModel.setMsg("待更新的记录不存在");
				return messageModel;
			}else{			
			  result=	update(payIn);
			  
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
	public Map queryPayInByParams(PayInQuery payInQuery) {
		Map map = new HashMap();
		
		PageInfo<PayIn> pageInfo = queryForPage(payInQuery);
		
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		return map;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MessageModel delAccountBatch(Integer[] ids){
		MessageModel messageModel = new MessageModel();
		if(null==ids||ids.length==0){
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("待删除记录不存在！");
			return messageModel;
		}
		
		Map map = new HashMap();
		map.put("ids", ids);
		int result = payInMapper.delPayInBatch(map);
		
		if(result>0){
			messageModel.setMsg("账户记录删除成功!");
		}else {
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("账户记录删除失败！");
		}
		
		
		
		return messageModel;
	}





}
