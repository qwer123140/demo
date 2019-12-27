package com.jswl.portal.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jswl.portal.dao.ArticleMapper;
import com.jswl.portal.dao.ColumnMapper;
import com.jswl.portal.dao.ImageMapper;
import com.jswl.portal.entity.Article;
import com.jswl.portal.entity.Image;
import com.jswl.portal.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnMapperTest {
	@Autowired
	private ArticleMapper articleMapper ;
	@Test
	public void testfindAll() {
		List<Article> findTopArticles = articleMapper.findTopArticles(19, null);
		for (Article article : findTopArticles) {
			System.out.println(article);
		}
	}
	

}
