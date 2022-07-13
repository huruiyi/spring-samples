package com.example.demo.mapper;

import java.util.List;

import com.example.demo.po.ItemsCustom;
import com.example.demo.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}