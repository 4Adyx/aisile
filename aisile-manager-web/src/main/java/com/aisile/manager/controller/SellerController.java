package com.aisile.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbBrand;
import com.aisile.pojo.TbSeller;
import com.aisile.pojo.entity.PageResult;
import com.aisile.sellergoods.service.SellerGoodsService;
import com.aisile.sellergoods.service.SellerService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference
	private SellerService sellerService;
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSeller tbSeller,int Index,int pageSize){
		PageResult list=sellerService.search(Index, pageSize,tbSeller);
		return list;
	}
	@RequestMapping("/add")
	public boolean add(@RequestBody TbSeller tbSeller){
		boolean flag=false;
		try {
			if(tbSeller.getSellerId()!=null){
				sellerService.update(tbSeller);
				return true;
			}
			sellerService.insert(tbSeller);
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
			sellerService.delete(ids);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@RequestMapping("/show")
	public TbSeller show(String id){
		TbSeller tbSeller=sellerService.findOne(id);
		return tbSeller;
	}
	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return sellerService.selectOptionList();
	}
	@RequestMapping("/updateStatus")
	public boolean updateStatus(String id,String status){
		return sellerService.updateStatus(id, status);
		
	}
}
