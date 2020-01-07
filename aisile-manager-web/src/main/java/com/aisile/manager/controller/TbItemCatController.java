package com.aisile.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbItemCat;
import com.aisile.sellergoods.service.TbItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/tbItemCat")
public class TbItemCatController {

	@Reference
	private TbItemCatService tbItemCatService;
	@RequestMapping("/findByParentId")
	public List<TbItemCat> findByParentId(long parentId){
		return tbItemCatService.findByParentId(parentId);
	}
	@RequestMapping("/add")
	public boolean add(@RequestBody TbItemCat tbItemCat){
		return tbItemCatService.add(tbItemCat);
	}
	@RequestMapping("/show")
	public TbItemCat show(long id){
		return tbItemCatService.show(id);
	}
	@RequestMapping("/del")
	public boolean del(long[] ids){
		return tbItemCatService.del(ids);
	}
	@RequestMapping("/findAll")
	public List<TbItemCat> findAll(){
		return tbItemCatService.findAll();
	}
}
