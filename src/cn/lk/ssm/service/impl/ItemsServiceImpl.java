package cn.lk.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lk.ssm.mapper.ItemsMapper;
import cn.lk.ssm.mapper.ItemsMapperCustom;
import cn.lk.ssm.po.Items;
import cn.lk.ssm.po.ItemsCustom;
import cn.lk.ssm.po.ItemsQueryVo;
import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.service.ItemsService;


public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Map<String, String>> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemsMapperCustom查询数据库
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
		//业务校验，对重要参数进行校验  id  如果为空抛出异常
			
		//更新商品的信息
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
	}

	@Override
	public List<Map<String, String>> findItemsListByName(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsListByName(itemsQueryVo);
	}

	@Override
	public List<Map<String, String>> findMyItems(UserCustom userCustom) throws Exception {
		
		return itemsMapperCustom.findMyItems(userCustom);
	}

	@Override
	public boolean insertItems(ItemsCustom itemsCustom) throws Exception{
		
		return itemsMapperCustom.insertItems(itemsCustom);
	}


}
