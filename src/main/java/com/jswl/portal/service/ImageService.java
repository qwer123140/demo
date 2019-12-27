package com.jswl.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.entity.Image;

public interface ImageService {
	List<Image> findAllImages();
	
	/**
	 * 分页查询返回值
	 */
	Page<Image> getListPage(Integer page,Integer pageSize);
	
	
	//保存
	void saveImage(Image image);
	
	//删除
	void deleteImages(Integer[] ids);

}
