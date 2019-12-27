package com.jswl.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jswl.portal.common.util.ResultUtil;
import com.jswl.portal.dto.ColumnTreeNodeDto;
import com.jswl.portal.dto.ResultDto;
import com.jswl.portal.entity.Column;
import com.jswl.portal.service.ColumnService;

@Controller
@RequestMapping("/admin/column")
public class ColumnController {
	@Autowired
	private ColumnService columnService;
	
	
	@RequestMapping("/toColumnManagePage")
	public String toColumnManagePage() {
		
		return "admin/column/column-manage";
	}
	//更新
	@RequestMapping("/getColumnTreeList")
	@ResponseBody
	public ResultDto<List<ColumnTreeNodeDto>> getColumnTreeList(){
		//调用封装方法，返回list集合
		List<ColumnTreeNodeDto> list = columnService.getColumnTreeList();
		//将返回值放入dto中
		return   ResultUtil.success(list);
		
	}
	@RequestMapping("/saveColumn")
	@ResponseBody
	public ResultDto<Integer> saveColumn(Column column){
		//调用更新方法
		Integer id = columnService.saveOrUpdate(column);

		return ResultUtil.success(id);
	}
	//删除
	@RequestMapping("/delColumn")
	@ResponseBody
	public ResultDto<String> delColumn(Integer columnId){
		try {
			columnService.delColumn(columnId);
			return ResultUtil.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.fail("删除失败");

		}
		
		
	}
	
	
	
	
	
	
	

}
