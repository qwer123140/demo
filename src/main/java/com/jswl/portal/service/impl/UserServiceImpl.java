package com.jswl.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jswl.portal.dao.UserMapper;
import com.jswl.portal.entity.User;
import com.jswl.portal.entity.UserExample;
import com.jswl.portal.entity.UserExample.Criteria;
import com.jswl.portal.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User loginUser(String userCode, String password) {
		//创建查询实体
		UserExample example=new UserExample();
		//封装查询参数
		Criteria criteria = example.createCriteria();
		//
		criteria.andUserCodeEqualTo(userCode).andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(example);
		if (users!=null) {
			return users.get(0);
		}
		
		return null;
	}

}
