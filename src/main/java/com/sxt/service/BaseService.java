package com.sxt.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.dao.BaseMapper;
import com.sxt.query.BaseQuery;
import com.sxt.utils.AssertUtil;


public abstract class BaseService<T> {
	
	/**
	 * 按类型注入
	 */
	@Autowired
	private BaseMapper<T> baseMapper;
	
	
	public int insert(T t){	
		return baseMapper.insert(t);
	}
	
	
	public int insertBatch(List<T> t){
		return baseMapper.insertBatch(t);
	}
	
	
	
	public T queryById(int id){
		return baseMapper.queryById(id);
	}
	
	
	public PageInfo<T> queryForPage(BaseQuery baseQuery){
		PageHelper.startPage(baseQuery.getPage(), baseQuery.getRows());		
		List<T> list=baseMapper.queryForPage(baseQuery);		
		PageInfo<T> pageInfo=new PageInfo<T>(list);		
		return pageInfo;
	}
	
	
	
	public List<T> queryAllByParams(BaseQuery baseQuery){
		return baseMapper.queryAllByParams(baseQuery);
	}
	
	
	
	public int update(T t){
		return baseMapper.update(t);
	}
	
	
	@SuppressWarnings("rawtypes")
	public int updateBatch(Map map){
		return baseMapper.updateBatch(map);
	}
	
	
	
	public int delete(int id){
		AssertUtil.isNull(queryById(id), "查询记录不存在!");
		return baseMapper.delete(id);
		
	}
	
	
	
	public int deleteBatch(int[] ids){
		AssertUtil.isTrue(ids.length==0, "id 不能为空!");
		return baseMapper.deleteBatch(ids);
		
		
	}
 	
	

}
