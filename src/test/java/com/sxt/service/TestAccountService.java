//package com.shsxt.service;
//
//import static org.junit.Assert.*;
//
//import java.util.Date;
//
//import javax.annotation.Resource;
//import javax.management.Query;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.github.pagehelper.PageInfo;
//import com.shsxt.po.Account;
//import com.shsxt.po.User;
//import com.shsxt.query.BaseQuery;
//import com.shsxt.service.impl.AccountServiceImpl;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
//public class TestAccountService {
//	
//	@Resource
//	private AccountServiceImpl accountService;
//
//	@Test
//	public void test01() {
//	Account account=accountService.queryAccountById(5);
//	
//	System.err.println(account);
//	}
//	
//	
//	@Test
//	public void test02() {
//		BaseQuery baseQuery=new BaseQuery();
//		
//		baseQuery.setPageNum(1);
//		baseQuery.setPageSize(2);
//		
//		PageInfo<Account> pageInfo=accountService.queryForPage(baseQuery);
//
//		
//		for(Account account:pageInfo.getList()){
//			
//			System.err.println(account);
//		}
//
//		
//	}
//	
//	
//	@Test
//	public void test03(){	
//		Account account=new Account("test02", "1", 100.0, 1, new Date(), new Date(), "test02");
//		System.out.println("影响行数:"+accountService.insert(account));
//	}
//	
//	
//	
//	
//
//	
//	
//	
//	
//} 
