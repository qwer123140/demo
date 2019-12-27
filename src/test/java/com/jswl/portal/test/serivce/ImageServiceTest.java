package com.jswl.portal.test.serivce;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jswl.portal.dao.ImageMapper;
import com.jswl.portal.entity.Image;
import com.jswl.portal.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageServiceTest {
	@Autowired
	private ImageService imageService;
	@Test
	public void testfindAll() {
		List<Image> image = imageService.findAllImages();
		for (Image image2 : image) {
			System.out.println(image2);
		}
	}
	

}
