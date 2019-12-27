package com.jswl.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jswl.portal.dao.ImageMapper;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.entity.Image;
import com.jswl.portal.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public List<Image> findAllImages() {
		
		return imageMapper.selectByExample(null);
	}

	@Override
	public Page<Image> getListPage(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		
		
		Page<Image> images = (Page<Image>) imageMapper.selectByExample(null);
		return images;
	}

	@Override
	public void saveImage(Image image) {
		imageMapper.insertSelective(image);
		
	}

	@Override
	public void deleteImages(Integer[] ids) {
		if(ids!=null) {
			for (Integer id : ids) {
				imageMapper.deleteByPrimaryKey(id);
			}
		}
		
	}

	
	
	

}
