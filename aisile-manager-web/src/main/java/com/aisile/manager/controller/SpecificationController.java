package com.aisile.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbBrand;
import com.aisile.pojo.TbSpecification;
import com.aisile.pojo.entity.PageResult;
import com.aisile.pojogroup.Specification;
import com.aisile.sellergoods.service.SellerGoodsService;
import com.aisile.sellergoods.service.SpecificationService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSpecification bSpecification,int Index,int pageSize){
		PageResult list=specificationService.search(Index, pageSize,bSpecification);
		return list;
	}
	@RequestMapping("/add")
	public boolean add(@RequestBody Specification specification){
		boolean flag=false;
		try {
			boolean insert = specificationService.insert(specification);
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
			specificationService.deleteSpec(ids);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("/show")
	public Specification show(long id){
		Specification tbBrand=specificationService.findOne1(id);
		return tbBrand;
	}
	@RequestMapping("/selectSpecList")
	public List<Map> selectSpecList(){
		return specificationService.selectSpecList();
	}
	
}
