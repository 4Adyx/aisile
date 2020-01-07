package com.aisile.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbBrand;
import com.aisile.pojo.TbUser;
import com.aisile.sellergoods.service.SellerGoodsService;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Reference
	private SellerGoodsService sellerGoodsService;
	@RequestMapping("/login")
	public boolean login(@RequestBody TbUser tbUser,HttpServletRequest request){
		boolean flag=false;
		TbUser u=sellerGoodsService.login(tbUser);
		if(u!=null){
			request.setAttribute("name", tbUser.getUsername());
			flag=true;
		}
		return flag;
	}
}
