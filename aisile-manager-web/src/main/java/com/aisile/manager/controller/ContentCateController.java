package com.aisile.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.content.service.ContentCateService;
import com.aisile.pojo.TbContentCategory;
import com.aisile.pojo.entity.PageResult;
import com.aisile.pojo.entity.Result;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/contentCate")
public class ContentCateController {

	@Reference
	private ContentCateService contentCateService;
	@RequestMapping("/findAll")
	public List<TbContentCategory> findAll(){
		return contentCateService.findAll();
	}
	@RequestMapping("/search")
	public PageResult search(int index,int pageSize,@RequestBody TbContentCategory tbContentCategory){
		return contentCateService.search(index, pageSize, tbContentCategory);
	}
	@RequestMapping("/add")
	public Result add(@RequestBody TbContentCategory tbContentCategory){
		if(contentCateService.add(tbContentCategory)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
	@RequestMapping("/show")
	public TbContentCategory show(long id){
		return contentCateService.show(id);
	}
	@RequestMapping("/del")
	public Result del(long[] ids){
		if(contentCateService.del(ids)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
}
