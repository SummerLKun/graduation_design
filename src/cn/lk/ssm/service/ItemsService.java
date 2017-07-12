package cn.lk.ssm.service;

import java.util.List;
import java.util.Map;

import cn.lk.ssm.po.ItemsCustom;
import cn.lk.ssm.po.ItemsQueryVo;
import cn.lk.ssm.po.UserCustom;

/**
 * @author Summer
 * 商品管理的service
 *
 */
public interface ItemsService {

	
	//商品查询列表
	public List<Map<String, String>> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//查询商品的id
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品的id
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	public List<Map<String, String>> findItemsListByName(ItemsQueryVo itemsQueryVo) throws Exception;
	
	public List<Map<String, String>> findMyItems(UserCustom userCustom) throws Exception;
	
	public boolean insertItems(ItemsCustom itemsCustom) throws Exception;
	
}
