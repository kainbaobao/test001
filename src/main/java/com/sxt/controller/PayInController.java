package com.sxt.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.constant.WacaiConstant;
import com.sxt.model.MessageModel;
import com.sxt.dto.PayIn;
import com.sxt.query.PayInQuery;
import com.sxt.service.impl.PayInServiceImpl;

@Controller
@RequestMapping("payIn")
public class PayInController extends BaseController{
	@Resource
	private PayInServiceImpl payInServiceImpl;
	
	@RequestMapping("queryPayInById")
	@ResponseBody
	public PayIn queryPayInById(int id){
		return payInServiceImpl.queryPayInById(id);
	}
	
	@RequestMapping("saveOrUpdatePayIn")
	@ResponseBody
	public MessageModel saveOrUpdatePayIn(PayIn payIn){
		MessageModel messageModel = new MessageModel();
		try {
			messageModel = payInServiceImpl.saveOrUpdatePayIn(payIn);
		} catch (Exception e) {
			e.printStackTrace();
			messageModel.setCode(WacaiConstant.FAILED_CODE);
			messageModel.setMsg("账户添加失败，请稍候再试！");
		}
		return messageModel;
	}

	@RequestMapping("index")
	public String index(){
		return "payIn";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("queryPayInByParams")
	@ResponseBody
	public Map queryPayInByParams(PayInQuery payInQuery){
		Map map = payInServiceImpl.queryPayInByParams(payInQuery);
		return map;
	}
	
//	@RequestMapping("delPayIn")
//	@ResponseBody
//	public MessageModel delPayIn(Integer[] ids){
//		MessageModel messageModel = new MessageModel();
//		try {
//			messageModel = payInServiceImpl.;
//		} catch (Exception e) {
//			e.printStackTrace();
//			messageModel.setCode(WacaiConstant.FAILED_CODE);
//			messageModel.setMsg("账户删除失败，请稍候再试！");
//		}
//		return messageModel;
//	}
}
