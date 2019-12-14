package com.taotao.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void testhelper() {
		//1.初始化spring 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//2.获取mapper的代理对象
		TbItemMapper itemMaper = context.getBean(TbItemMapper.class);
		//3.设置分页信息 ,紧跟着的第一个查询才用改分页
		PageHelper.startPage(1, 5);
		//4.调用mapper 的方法查询数据
		TbItemExample  example  = new TbItemExample();
		List<TbItem> list = itemMaper.selectByExample(example);
		List<TbItem> list2 = itemMaper.selectByExample(example);
		
		System.out.println("有分页的list长度："+list.size());
		System.out.println("没有分页的list长度："+list2.size());
		//取分页信息
		PageInfo< TbItem> info = new PageInfo<TbItem>(list);
		//5.显示结果集
		
		System.out.println("结果集长度"+info.getTotal());
		System.out.println("总页数"+info.getPages());
	}
}
