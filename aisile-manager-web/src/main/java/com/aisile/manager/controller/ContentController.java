package com.aisile.manager.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.content.service.ContentService;
import com.aisile.pojo.TbContent;
import com.aisile.pojo.entity.PageResult;
import com.aisile.pojo.entity.Result;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	@RequestMapping("/search")
	public PageResult search(int index,int pageSize,@RequestBody TbContent tbContent){
		return contentService.search(index, pageSize, tbContent);
	}
	@RequestMapping("/add")
	public Result add(@RequestBody TbContent tbContent){
		if(contentService.add(tbContent)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
	@RequestMapping("/show")
	public TbContent show(long id){
		return contentService.show(id);
	}
	@RequestMapping("/del")
	public Result del(long[] ids){
		if(contentService.del(ids)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
	@RequestMapping("/updateStatus1")
	public Result updateStatus1(long[] ids){
		if(contentService.updateStatus(ids)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
	@RequestMapping("/updateStatus2")
	public Result updateStatus2(long[] ids){
		if(contentService.updateStatus1(ids)){
			return new Result(true, 20000, "");
		}
		return new Result(false, 20001, "");
	}
}
