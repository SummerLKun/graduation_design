package cn.lk.ssm.service;

import java.util.List;
import java.util.Map;

import cn.lk.ssm.po.OrderCustom;

public interface OrderService {

	//插入订单
	public boolean insertOrder(Map<String, Object> map) throws Exception;
	////查询用户订单
	public List<Map<String, String>> findOrdersByName(OrderCustom orderCustom) throws Exception;
}
