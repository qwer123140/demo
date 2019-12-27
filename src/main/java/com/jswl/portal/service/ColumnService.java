package com.jswl.portal.service;

import java.util.List;

import com.jswl.portal.dto.ColumnTreeNodeDto;
import com.jswl.portal.entity.Column;

public interface ColumnService {
	/**
	 * 查询最新动态信息
	 * @param columnId:栏目的id
	 * @param num:查询文章数
	 * @return
	 */
	ColumnTreeNodeDto findColumnInfo(Integer columnId,Integer num);

	/**
	 * 	查询中部以及底部的栏目信息
	 * @param type:栏目分类
	 * @param num:查询该栏目下多少条文章
	 * @return
	 */
	List<ColumnTreeNodeDto> findColumnInfoByType(Integer type,Integer num);
	
	/**
	 * 查询更多
	 */
	ColumnTreeNodeDto findMoreColumns(Integer columnId);
	
	//查询树状结构
	List<ColumnTreeNodeDto> getColumnTreeList();
	
	
	//保存或者更新栏目信息
	Integer saveOrUpdate(Column column);
	
	//删除
	void delColumn(Integer id);


}
