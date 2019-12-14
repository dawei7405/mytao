package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

/**
 * 显示页面
 * @author Administrator
 *
 */


@Controller
public class Pagecontroller {
	
	
	
	//首页
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	//显示点击的左树菜单项
	@RequestMapping("/{page}")
	public String getMenu(@PathVariable(value = "page") String page) {
		
		return page;
		
	}


}
