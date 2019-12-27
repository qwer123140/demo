package com.jswl.portal.service;

import com.jswl.portal.entity.User;

public interface UserService {
	User loginUser(String userCode,String password);

}
