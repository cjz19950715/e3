package com.itheima.e3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.Service.ItemService;

import cn.itheima.e3.pojo.TbItem;

@Controller
public class ItemController {
	@Autowired
	private ItemService service;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,Long id){
		List<TbItem> list = service.getId(id);
		HttpSession session = request.getSession();
		if(list!=null && list.size()>0){
			TbItem item = list.get(0);
			session.setAttribute("item", item);
		}
		
		
		return "index";
	}
	
}
