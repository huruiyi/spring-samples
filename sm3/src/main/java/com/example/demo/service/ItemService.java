package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Items;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
	
	public Items selectItemsById(Integer id);
	
	
	//修改
	public void updateItemsById(Items items);

}
