package com.jswl.portal.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.entity.Article;

public interface ArticleService {
	ArticleDto findArticleDetailById(Integer articleId);
	/**
	 * 查询上一篇文章
	 */
	Article findPreArticle(ArticleDto articleDto);
	
	/**
	 * 查询上一篇文章
	 */
	Article findNextArticle(ArticleDto articleDto);
	
	//模糊查询
	List<Article> findArticleByTitle(String title);
	
	/**
	 * 分页查询返回值
	 */
	Page<ArticleDto> findArticleDtoPage(Integer page,Integer pageSize);
	
	/**
	 * 保存文章信息
	 * @param article
	 */
	void saveArticleInfo(Article article);
	
	
	/**
	 * 修改文章信息
	 */
	void updateArticle(Article article);
	
	/**
	 * 删除
	 */

	void deleteArticleByIds(Integer[] ids);
}
