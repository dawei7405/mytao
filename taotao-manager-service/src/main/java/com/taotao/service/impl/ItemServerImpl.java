package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServerImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//1.设置分页信息
		if(page==null)page = 1;
		if(rows==null)page = 30;
		PageHelper.startPage(page, rows); 
		//2.注入itemMapper
		//3.mapper调用方法返回数据
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		//4.封装EasyUIDataGridResult 数据返回
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		PageInfo<TbItem> info = new PageInfo<TbItem>(list); 
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		
		return result;
		//5将服务发布
	}

}
