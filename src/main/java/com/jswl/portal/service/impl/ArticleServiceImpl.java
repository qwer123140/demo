package com.jswl.portal.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jswl.portal.dao.ArticleMapper;
import com.jswl.portal.dao.ColumnMapper;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.entity.Article;
import com.jswl.portal.entity.ArticleExample;
import com.jswl.portal.entity.ArticleExample.Criteria;
import com.jswl.portal.entity.Column;
import com.jswl.portal.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ColumnMapper columnMapper;
	
	@Override
	public ArticleDto findArticleDetailById(Integer articleId) {
		ArticleDto articleDto=new ArticleDto();
		Article article = articleMapper.selectByPrimaryKey(articleId);
		BeanUtils.copyProperties(article, articleDto);
		Column column = columnMapper.selectByPrimaryKey(article.getColumnId());
		articleDto.setColumnCode(column.getCode());
		articleDto.setColumnCode(column.getName());
		
		return articleDto;
	}

	@Override
	public Article findPreArticle(ArticleDto articleDto) {
		
		return articleMapper.findPreArticle(articleDto);
	}

	@Override
	public Article findNextArticle(ArticleDto articleDto) {
		return articleMapper.findNextArticle(articleDto);
	}

	@Override
	public List<Article> findArticleByTitle(String title) {	
		ArticleExample example=new ArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%"+title+"%");
		
		
		return articleMapper.selectByExample(example);
		 
	}

	@Override
	public Page<ArticleDto> findArticleDtoPage(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		Page<ArticleDto> articleDtoInfo = (Page<ArticleDto>)articleMapper.findArticleDtoInfo();		
		return articleDtoInfo;
	}

	@Override
	public void saveArticleInfo(Article article) {
		//保存的方法
		articleMapper.insertSelective(article);
		
	}
	//修改
	@Override
	public void updateArticle(Article article) {
		articleMapper.updateByPrimaryKeySelective(article);
		
	}
	//删除
	@Override
	public void deleteArticleByIds(Integer[] ids) {
		
			for (Integer id : ids) {
				articleMapper.deleteByPrimaryKey(id);
			}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
