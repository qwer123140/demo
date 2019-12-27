package com.jswl.portal.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.dto.ColumnTreeNodeDto;
import com.jswl.portal.entity.Article;
import com.jswl.portal.entity.Image;
import com.jswl.portal.service.ArticleService;
import com.jswl.portal.service.ColumnService;
import com.jswl.portal.service.ImageService;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Autowired
	private ImageService imageService;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	@GetMapping("/index")
	public String index(Model model) {
		//查询所有图片讯息
		List<Image> images = imageService.findAllImages();
		//上中下图片集合
		List<Image> pic1List=new ArrayList<>();
		List<Image> pic2List=new ArrayList<>();
		List<Image> pic3List=new ArrayList<>();
		for (Image image : images) {
			switch (image.getType()) {
			case 1:
				pic1List.add(image);				
				break;
			case 2:
				pic2List.add(image);				
				break;

			default:
				pic3List.add(image);
				break;
			}
		}
		model.addAttribute("pic1List", pic1List);
		model.addAttribute("pic2List", pic2List);
		model.addAttribute("pic3List", pic3List);
		//查询最新动态
		ColumnTreeNodeDto topColumn = columnService.findColumnInfo(19, 4);
		model.addAttribute("topColumn", topColumn);
		
		
		List<ColumnTreeNodeDto> mainColumn = columnService.findColumnInfoByType(2, 5);
		model.addAttribute("mainColumnList", mainColumn);
		
		List<ColumnTreeNodeDto> bottomColumn = columnService.findColumnInfoByType(3, 5);
		model.addAttribute("bottomColumnList", bottomColumn);
		
		
		return "front/index";
	}
	//查询文章详情
	@RequestMapping("/articleDetailById")
	public String findArticleDetails(Integer articleId,Model model) {
		ArticleDto articleDto = articleService.findArticleDetailById(articleId);
		//查询Redis数据库，没有读取设置为1，否则加1
		Double score = stringRedisTemplate.opsForZSet().score("article_read-num", articleId+"");
		if (score==null) {
			//设置到Redis数据库中值为1
			score=1d;
			stringRedisTemplate.opsForZSet().add("article_read-num", articleId+"", score);		
		}else {
			score+=1;
			stringRedisTemplate.opsForZSet().add("article_read-num", articleId+"", score);
		}
		articleDto.setReadNum(score.longValue());
		//查询上一篇
		Article preArticle = articleService.findPreArticle(articleDto);
		//查询下一篇
		Article nextArticle = articleService.findNextArticle(articleDto);
		
		model.addAttribute("pre", preArticle);
		model.addAttribute("next", nextArticle);
		model.addAttribute("detail", articleDto);
		return "front/article-detail";
	}
	@RequestMapping("/articleMore")
	public String articleMore(Integer columnId,Model model) {
		ColumnTreeNodeDto dto = columnService.findMoreColumns(columnId);
		model.addAttribute("column", dto);
		List<ColumnTreeNodeDto> nodes = dto.getChildNode();
		if (nodes==null || nodes.size()==0) {
			//没有子栏目返回article-more.html
			return "front/article-more";
		} 		
		return "front/article-column";
		
	}
	@RequestMapping("/articleSearch")
	public String articleSearch(String word,Model model) {
		//调取查询的方法
		List<Article> list = articleService.findArticleByTitle(word);
		//传递给前台
		model.addAttribute("list", list);
		//返回页面
		return "front/article-search";
	}
	
	@RequestMapping("/companyProfile")
	public String companyProfile() {
		return "front/company-profile";
	}
	
	
	
	
	
	
	
	
	
	

}
