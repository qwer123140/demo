package com.jswl.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.jswl.portal.common.util.ResultUtil;
import com.jswl.portal.dto.ArticleDto;
import com.jswl.portal.dto.ResultDto;
import com.jswl.portal.entity.Article;
import com.jswl.portal.entity.User;
import com.jswl.portal.service.ArticleService;
import com.jswl.portal.service.ColumnService;
@Controller
@RequestMapping("/admin/article")
public class ArticeController {
		@Autowired
		private  ArticleService articleService;
		@RequestMapping("/toArticleManagePage")
		public String toArticleManagePage() {
			
			return "admin/article/article-manage";
		}
		@RequestMapping("/getListPage")
		@ResponseBody
		public ResultDto<Map<String, Object>> getListPage(Integer page,Integer pageSize){
			//获取page, pageSize的值，并封装到page集合中
			Page<ArticleDto> articleDtoPage = articleService.findArticleDtoPage(page, pageSize);
			Map<String, Object> map=new HashMap<>();
			map.put("total", articleDtoPage.getTotal());
			map.put("rows", articleDtoPage.getResult());
			return ResultUtil.success(map);
		}
		//跳转到添加页面
		@RequestMapping("/toArticleAddPage")
		public String toArticleAddPage() {
			return "admin/article/article-add";
		}
		//保存文章
		@RequestMapping("/save")
		@ResponseBody
		public ResultDto<String> save(Article article,HttpSession session){
			
			User user =(User) session.getAttribute("user");
			if (user==null) {
				return ResultUtil.fail("需要登录");
			}
			
			try {
				//获取系统当前时间
				article.setCreateTime(System.currentTimeMillis());
				//获取发布时间
				article.setReleasTime(System.currentTimeMillis());
				//获取状态
				article.setStatus(new Byte("1"));
				//获取创建用户
				article.setCreateUserId(user.getId());
				articleService.saveArticleInfo(article);
				return ResultUtil.success("保存成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultUtil.fail("保存失败");
			}
			
		}
		//修改
		//跳转到修改页面
		@RequestMapping("/toArticleEditPage")
		public String toArticleEditPage(Integer id,Model model) {
			model.addAttribute("id", id);
			return "admin/article/article-edit";
		}
		@RequestMapping("/getDetailById")
		@ResponseBody
		public ResultDto<ArticleDto> getDetailById(Integer id){
			try {
				ArticleDto	dto = articleService.findArticleDetailById(id);
				return ResultUtil.success(dto);
			} catch (Exception e) {
				e.printStackTrace();
				return ResultUtil.fail("处理失败");
			}
						
		}
		@RequestMapping("/update")
		@ResponseBody
		public ResultDto<String> update(Article article){ 
			try {
				articleService.updateArticle(article);
				return ResultUtil.success("保存成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultUtil.fail("处理失败");
			}
		}
		//删除
		@RequestMapping("/delByIds")
		@ResponseBody
		public ResultDto<String> delByIds(@RequestParam("ids[]")Integer[] ids){
			try {
				articleService.deleteArticleByIds(ids);
				return ResultUtil.success("删除成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultUtil.fail("删除失败");
			}
			
			
		}
		
		
		
		
		
		
		
		
		

}
