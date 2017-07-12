package cn.lk.ssm.mapper;

import java.util.List;
import java.util.Map;

import cn.lk.ssm.po.OrderCustom;

public interface OrdersMapperCustom {
	
	//插入用户订单
	public boolean insertOrder(Map<String, Object> map) throws Exception;
	//查询用户订单
	public List<Map<String, String>> findOrdersByName(OrderCustom orderCustom) throws Exception;
}
