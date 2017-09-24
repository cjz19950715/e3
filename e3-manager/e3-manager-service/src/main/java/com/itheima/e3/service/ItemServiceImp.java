package com.itheima.e3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.Service.ItemService;

import cn.itheima.e3.mapper.TbItemMapper;
import cn.itheima.e3.pojo.TbItem;
import cn.itheima.e3.pojo.TbItemExample;
import cn.itheima.e3.pojo.TbItemExample.Criteria;


@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	private TbItemMapper mapper;
	
	@Override
	public List<TbItem> getId(Long id) {
		
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		
		//mapper.selectByPrimaryKey(id);
		List<TbItem> list = mapper.selectByExample(example);
		
		
		return list;
	}

}
