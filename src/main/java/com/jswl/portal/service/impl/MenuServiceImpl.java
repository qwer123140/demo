package com.jswl.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jswl.portal.dao.MenuMapper;
import com.jswl.portal.dto.MenuTreeNodeDto;
import com.jswl.portal.entity.Menu;
import com.jswl.portal.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public MenuTreeNodeDto findMenusInfo(Integer userId) {
		//封装返回对象
		MenuTreeNodeDto dto=new MenuTreeNodeDto();
		//获取userId，传入list集合中
		List<Menu> menus = menuMapper.findMenusByUserId(userId);
		//循环输出
		for (Menu menu : menus) {
			if (menu.getPid()==0) {
				BeanUtils.copyProperties(menu, dto);
				dto.setChildNode(childMenus(menu.getId(), menus));
			}
		}
		return dto;				
	}
	//递归查询
	public List<MenuTreeNodeDto> childMenus(Integer id,List<Menu> menus){
		List<MenuTreeNodeDto> dtos=new ArrayList<>();
		for (Menu menu : menus) {
			if (menu.getPid()==id) {
				MenuTreeNodeDto dto=new MenuTreeNodeDto();
				//将menu中的值传给dto
				BeanUtils.copyProperties(menu, dto);
				//查询子菜单
				dto.setChildNode(childMenus(menu.getId(), menus));
				dtos.add(dto);
			}
		}
	
		return dtos;
		
		
	}
	
	
	
	
	
	
	
	
}



