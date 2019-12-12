package cn.example.ssm.service;

import java.util.List;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	public ItemsCustom findItemsById(Integer id) throws Exception;

	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

}
