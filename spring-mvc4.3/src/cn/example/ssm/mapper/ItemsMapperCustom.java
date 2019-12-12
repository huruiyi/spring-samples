package cn.example.ssm.mapper;

import java.util.List;

import cn.example.ssm.po.ItemsCustom;
import cn.example.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}