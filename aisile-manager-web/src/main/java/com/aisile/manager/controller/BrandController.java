package com.aisile.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbBrand;
import com.aisile.pojo.entity.PageResult;
import com.aisile.sellergoods.service.SellerGoodsService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private SellerGoodsService sellerGoodsService;
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		List<TbBrand> list=sellerGoodsService.findBrandList();
		return list;
	}
	@RequestMapping("/findPage")
	public PageResult findPage(int Index,int pageSize){
		PageResult list=sellerGoodsService.findAllByPage(Index, pageSize);
		return list;
	}
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int Index,int pageSize){
		PageResult list=sellerGoodsService.search(Index, pageSize,tbBrand);
		return list;
	}
	@RequestMapping("/add")
	public boolean add(@RequestBody TbBrand tbBrand){
		System.out.println(tbBrand);
		boolean flag=false;
		try {
			if(tbBrand.getId()!=null){
				sellerGoodsService.update(tbBrand);
				return true;
			}
			sellerGoodsService.insert(tbBrand);
			flag=true;
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
			sellerGoodsService.delete(ids);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("/show")
	public TbBrand show(long id){
		TbBrand tbBrand=sellerGoodsService.findOne(id);
		return tbBrand;
	}
	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return sellerGoodsService.selectOptionList();
	}
	
}
