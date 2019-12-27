package com.jswl.portal.test.serivce;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.jswl.portal.dao.ArticleMapper;
import com.jswl.portal.dto.ArticleDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
	@Autowired
	private  ArticleMapper articleMapper;
	
	@Test
	public void getarticle() {
		PageHelper.startPage(1, 3);
		List<ArticleDto> info = articleMapper.findArticleDtoInfo();
		System.out.println("----------------");
		for (ArticleDto articleDto : info) {
			System.out.println(articleDto);
		}		
		System.out.println("----------------");
	}
	

}
