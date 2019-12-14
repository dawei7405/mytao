package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

/**
 * 商品controller
 * @author Administrator
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	@RequestMapping(value = "/item/list" ,method = RequestMethod.GET)
	@ResponseBody
	public  EasyUIDataGridResult getItemList(Integer page,Integer rows) {
		//1.ItemServerImpl 注入
		//2.调用方法返回数据
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
		
	}

}
