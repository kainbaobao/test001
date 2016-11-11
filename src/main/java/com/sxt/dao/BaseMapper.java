package com.sxt.dao;

import java.util.List;
import java.util.Map;

import com.sxt.query.BaseQuery;

public interface BaseMapper<T> {
	
	/**
	 * 添加方法
	 * @param entity
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 批量添加
	 * @param entries
	 * @return
	 */
	public int insertBatch(List<T> t);
	
	
	/**
	 * 查询记录通过id
	 * @param id
	 * @return
	 */
	public T queryById(int id);
	
	/**
	 * 查询分页记录
	 * @param baseQuery
	 * @return
	 */
	public  List<T> queryForPage(BaseQuery baseQuery);
	
	/**
	 * 查询记录  不分页
	 * @param baseQuery
	 * @return
	 */
	public List<T> queryAllByParams(BaseQuery baseQuery);
	
	
	/**
	 * 更新单条记录
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	
	/**
	 * 批量更新
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int updateBatch(Map map);
	
	/**
	 * 删除单条记录
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteBatch(int[] ids);
	
	
	
	
	
	
	
	
	
	
	
	

}
