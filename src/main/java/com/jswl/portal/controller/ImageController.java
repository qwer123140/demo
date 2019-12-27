package com.jswl.portal.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.jswl.portal.common.util.ResultUtil;
import com.jswl.portal.dto.ResultDto;
import com.jswl.portal.entity.Image;
import com.jswl.portal.service.ImageService;

@Controller
@RequestMapping("/admin/image")
public class ImageController {
	@Autowired
	 private ImageService imageService;
	
	@RequestMapping("/toImageManagePage")
	public String toImageManagePage() {
		
		return "admin/image/image-manage";
	}
	@RequestMapping("/toImageAddPage")
	public String toImageAddPage() {
		
		return "admin/image/image-add";
	}
	@RequestMapping("/getListPage")
	@ResponseBody
	public ResultDto<Map<String, Object>> getListPage(Integer page,Integer pageSize){
		Page<Image> listPage = imageService.getListPage(page, pageSize);
		Map<String, Object> map=new HashMap<>();
		map.put("total", listPage.getTotal());
		map.put("rows", listPage.getResult());
		return ResultUtil.success(map);
		
	}
	
	//图片上传
	@RequestMapping("/upload")
	@ResponseBody
	public ResultDto<String> upload(MultipartFile file) throws IllegalStateException, IOException {
		// 设置上传路径
		Long mi = System.currentTimeMillis();
		String path = "D:/images/" + mi + "/";
		File newFile = new File(path);
		// 如果没有该文件夹就创建
		if (!newFile.exists()) {
			newFile.mkdirs();
		}
		String originalName = file.getOriginalFilename();
		File trueFile = new File(path + originalName);
		file.transferTo(trueFile);
		String viewPath = "http://localhost:9090/admin/upload/"+mi+"/"+originalName;
		System.out.println(viewPath);
		ResultDto<String> pathDto = ResultUtil.success("上传成功");
		pathDto.setData(viewPath);
		return pathDto;
	}
	
	//图片保存
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto<String> saveImage(Image image){
		try {
			imageService.saveImage(image);
			return ResultUtil.success("保存成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResultUtil.fail("保存失败");
		}
	}
	//删除
	@RequestMapping("/delByIds")
	@ResponseBody
	public ResultDto<String> deleteImage(@RequestParam("ids[]")Integer[] ids){
		try {
			imageService.deleteImages(ids);
			return ResultUtil.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.fail("删除失败");
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
