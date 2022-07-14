package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Items;

public interface ItemService {

	public List<Items> selectItemsList();

	public Items selectItemsById(Integer id);

	public void updateItemsById(Items items);

}
