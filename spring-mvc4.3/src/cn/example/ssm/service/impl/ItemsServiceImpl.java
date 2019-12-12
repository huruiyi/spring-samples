package cn.example.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import cn.example.ssm.mapper.ItemsMapper;
import cn.example.ssm.mapper.ItemsMapperCustom;
import cn.example.ssm.po.Items;
import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;
import cn.example.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;

	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

}
