package cn.lk.ssm.mapper;

import cn.lk.ssm.po.ItemsCustom;
import cn.lk.ssm.po.ItemsQueryVo;
import cn.lk.ssm.po.UserCustom;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<Map<String, String>> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

	public List<Map<String, String>> findItemsListByName(ItemsQueryVo itemsQueryVo) throws Exception;

	public List<Map<String, String>> findMyItems(UserCustom userCustom) throws Exception;

	public boolean insertItems(ItemsCustom itemsCustom) throws Exception;
	
	
}