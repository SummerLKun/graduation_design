package cn.lk.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lk.ssm.mapper.OrdersMapperCustom;
import cn.lk.ssm.po.OrderCustom;
import cn.lk.ssm.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrdersMapperCustom ordersMapperCustom;
	@Override
	public boolean insertOrder(Map<String, Object> map) throws Exception {
		
		return ordersMapperCustom.insertOrder(map);
	}
	@Override
	public List<Map<String, String>> findOrdersByName(OrderCustom orderCustom) throws Exception {
		
		return ordersMapperCustom.findOrdersByName(orderCustom);
	}

}
