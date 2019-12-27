package com.jswl.portal.service;

import com.jswl.portal.dto.MenuTreeNodeDto;

public interface MenuService {
	MenuTreeNodeDto findMenusInfo(Integer userId);

}
