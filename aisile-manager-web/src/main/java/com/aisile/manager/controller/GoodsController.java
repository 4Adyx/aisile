package com.aisile.manager.controller;

import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.pojo.TbGoods;
import com.aisile.pojo.TbItem;
import com.aisile.pojo.TbItemCat;
import com.aisile.pojo.entity.PageResult;
import com.aisile.sellergoods.service.GoodsService;
import com.aisile.sellergoods.service.ItemService;
import com.aisile.sellergoods.service.TbItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;

@RequestMapping("/goods")
@RestController
public class GoodsController {
	@Reference
	private GoodsService goodsService;
	@Autowired
	private Destination queueSolrDestination;
	@Autowired
	private Destination queueSolrDeleteDestination;
	@Reference
	private ItemService itemService;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination topicPageDestination;
	@Autowired
	private Destination topicPageDeleteDestination;
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		//获取商家ID
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		//添加查询条件 
		goods.setSellerId(sellerId);		
		return goodsService.findPage(goods, page, rows);		
	}
	@RequestMapping("/show")
	public TbGoods show(long id){
		return goodsService.show(id);
	}
	@RequestMapping("/examine")
	public boolean examine(long[] ids){
		return goodsService.examine(ids);
	}
	@RequestMapping("/reject")
	public boolean reject(long[] ids){
		return goodsService.reject(ids);
	}
	@RequestMapping("/del")
	public boolean del(long[] ids){
		return goodsService.delete(ids);
	}
	
	@RequestMapping("/updateStatus")
	public void updateStatus(final Long id,String status){
		List<TbItem> list=itemService.findItemListByGoodsIdandStatus(id, status);
		if(list!=null&&list.size()>0){
			final String jsonString = JSON.toJSONString(list);		
			System.out.println(jsonString);
			jmsTemplate.send(queueSolrDestination, new MessageCreator() {	
				@Override
				public Message createMessage(Session session) throws JMSException {							
						return session.createTextMessage(jsonString);
				}
			});
		}
		//同步静态页面
		jmsTemplate.send(topicPageDestination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(id+"");
			}
		});
	}
	@RequestMapping("/delete")
	public void delete(Long id){
		itemService.deleteItemListByGoodsId(id);
		final Long ids=id;
		jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {	
			@Override
			public Message createMessage(Session session) throws JMSException {							
					return session.createTextMessage(ids+"");
			}
		});
		jmsTemplate.send(topicPageDeleteDestination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(ids+"");
			}
		});
	}
}
