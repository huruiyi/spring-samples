package com.example.demo.service;

import java.util.List;

import com.example.demo.po.ItemsCustom;
import com.example.demo.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	public ItemsCustom findItemsById(Integer id) throws Exception;

	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

}
