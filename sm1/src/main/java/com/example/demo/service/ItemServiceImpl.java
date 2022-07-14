package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemsMapper;
import com.example.demo.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	public Items selectItemsById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	public void updateItemsById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
