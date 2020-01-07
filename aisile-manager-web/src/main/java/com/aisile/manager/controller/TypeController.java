package com.aisile.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbBrand;
import com.aisile.pojo.TbSpecification;
import com.aisile.pojo.TbTypeTemplate;
import com.aisile.pojo.entity.PageResult;
import com.aisile.pojogroup.Specification;
import com.aisile.sellergoods.service.SellerGoodsService;
import com.aisile.sellergoods.service.SpecificationService;
import com.aisile.sellergoods.service.TypeService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/type")
public class TypeController {

	@Reference
	private TypeService typeService;
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbTypeTemplate tbTypeTemplate,int Index,int pageSize){
		PageResult list=typeService.search(Index, pageSize,tbTypeTemplate);
		return list;
	}
	@RequestMapping("/add")
	public boolean add(@RequestBody	TbTypeTemplate tbTypeTemplate){
		boolean flag=false;
		try {
			boolean insert = typeService.insert(tbTypeTemplate);
			flag=insert;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("/del")
	public boolean del(long[] ids){
		boolean flag=false;
		try {
			typeService.deleteSpec(ids);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("/show")
	public TbTypeTemplate show(long id){
		TbTypeTemplate tbTypeTemplate=typeService.findOne(id);
		return tbTypeTemplate;
	}
	
}
