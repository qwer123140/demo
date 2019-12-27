package com.jswl.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jswl.portal.dao.ArticleMapper;
import com.jswl.portal.dao.ColumnMapper;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.dto.ColumnTreeNodeDto;
import com.jswl.portal.entity.Article;
import com.jswl.portal.entity.Column;
import com.jswl.portal.entity.ColumnExample;
import com.jswl.portal.entity.ColumnExample.Criteria;
import com.jswl.portal.service.ColumnService;
@Service
public class ColumnServiceImpl implements ColumnService{
	@Autowired
	private ColumnMapper columnMapper;
	@Autowired
	private ArticleMapper articleMapper;
	

	@Override
	
	public ColumnTreeNodeDto findColumnInfo(Integer columnId, Integer num) {
		//声明返回结果
		ColumnTreeNodeDto columnTreeNodeDto=new ColumnTreeNodeDto();
		//栏目信息放到返回结果中
		Column column = columnMapper.selectByPrimaryKey(columnId);
		BeanUtils.copyProperties(column, columnTreeNodeDto);
		//查询对应文章信息
		List<Article> articles = articleMapper.findTopArticles(columnId, num);
		List<ArticleDto> articleDtos=articlesToArticleDtos(articles,column);
		
		columnTreeNodeDto.setArticleList(articleDtos);
		
		return columnTreeNodeDto;
	}
	private List<ArticleDto> articlesToArticleDtos(List<Article> articles,Column column){
		List<ArticleDto> articleDtos=new ArrayList<ArticleDto>();
		for (Article article : articles) {
			ArticleDto articleDto =new ArticleDto();
			BeanUtils.copyProperties(article, articleDto);
			articleDto.setColumnCode(column.getCode());
			articleDto.setColumnTitle(column.getName());
			articleDtos.add(articleDto);
		}
		return articleDtos;
		
		
		
		
	}
	@Override
	public List<ColumnTreeNodeDto> findColumnInfoByType(Integer type, Integer num) {
		//封装一个返回对象
		List<ColumnTreeNodeDto> columnTreeNodeDtos=new ArrayList<>();
		ColumnExample example=new ColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		example.setOrderByClause("sort");
		List<Column> columns = columnMapper.selectByExample(example);
		for (Column column : columns) {
			if (column.getPid()==0) {
				ColumnTreeNodeDto columnTreeNodeDto=new ColumnTreeNodeDto();
				BeanUtils.copyProperties(column, columnTreeNodeDto);
				//获取栏目下文章信息
				List<Article> articles = articleMapper.findTopArticles(column.getId(), num);
				//将文章实体转换成dto
				List<ArticleDto> articleDtos=articlesToArticleDtos(articles,column);
				//设置返回体中文章列表
				columnTreeNodeDto.setArticleList(articleDtos);
				columnTreeNodeDto.setChildNode(childColumns(column.getId(), columns, num));
				columnTreeNodeDtos.add(columnTreeNodeDto);
				

			}
		}

		return columnTreeNodeDtos;
	}
	//查询子栏目信息
	private List<ColumnTreeNodeDto> childColumns(Integer id,List<Column> columns,Integer num){
		List<ColumnTreeNodeDto> childDtos = new ArrayList<>();
		for (Column column : columns) {
			if(column.getPid()==id) {
				ColumnTreeNodeDto dto = new ColumnTreeNodeDto();
				BeanUtils.copyProperties(column, dto);
				//获取栏目下文章信息
				List<Article> articles = articleMapper.findTopArticles(column.getId(), num);
				//将文章实体转换成dto
				List<ArticleDto> articleDtos=articlesToArticleDtos(articles,column);
				dto.setArticleList(articleDtos);
				//设置子栏目信息
				dto.setChildNode(childColumns(column.getId(), columns, num));
				childDtos.add(dto);
			}
		}
		return childDtos;
	}
	@Override
	public ColumnTreeNodeDto findMoreColumns(Integer columnId) {
		ColumnTreeNodeDto columnTreeNodeDto=new ColumnTreeNodeDto();
		//查询栏目信息
		Column column = columnMapper.selectByPrimaryKey(columnId);
		BeanUtils.copyProperties(column, columnTreeNodeDto);
		List<Article> articles = articleMapper.findTopArticles(columnId, null);
		List<ArticleDto> articleDtos=articlesToArticleDtos(articles, column);
		columnTreeNodeDto.setArticleList(articleDtos);
		//封装子栏目信息
		ColumnExample example=new ColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(columnId);
		List<Column> columns = columnMapper.selectByExample(example);
		
		List<ColumnTreeNodeDto> columnTreeNodeDtos=new ArrayList<>();
		for (Column c : columns) {
			ColumnTreeNodeDto dto=new ColumnTreeNodeDto();
			BeanUtils.copyProperties(c, dto);
			//获取栏目下文章信息
			List<Article> a_s = articleMapper.findTopArticles(c.getId(), null);
			//将文章实体转换成dto
			List<ArticleDto> a_dtos=articlesToArticleDtos(a_s,c);
			//设置返回体中的文章的列表
			dto.setArticleList(a_dtos);
			dto.setChildNode(childColumns(c.getId(), columns, null));
			columnTreeNodeDtos.add(dto);
		}
		columnTreeNodeDto.setChildNode(columnTreeNodeDtos);
		
		return columnTreeNodeDto;
	}
	
	@Override
	public List<ColumnTreeNodeDto> getColumnTreeList() {
		List<ColumnTreeNodeDto> list=new ArrayList<>();
		//获取list的值
		List<ColumnTreeNodeDto> list1 = findColumnInfoByType(1, null);
		List<ColumnTreeNodeDto> list2 = findColumnInfoByType(2, null);
		List<ColumnTreeNodeDto> list3 = findColumnInfoByType(3, null);
		//将值放入list集合,显示到页面
		list.addAll(list1);
		list.addAll(list2);
		list.addAll(list3);
		
		return list;
	}
	@Override
	public Integer saveOrUpdate(Column column) {
		if (column.getId()==null) {
			//新增
			columnMapper.insertSelective(column);
			return column.getId();
		}else {
			//更新
			columnMapper.updateByPrimaryKeySelective(column);
			return column.getId();
		}
		
	}
	@Override
	public void delColumn(Integer id) {
		columnMapper.deleteByPrimaryKey(id);
		
	}
	
	

}

	
	
	
	
	
	
	
	
	
	


