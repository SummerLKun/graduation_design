package cn.lk.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lk.ssm.po.OrderCustom;
import cn.lk.ssm.service.OrderService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/orders")
public class OrderController {
	 
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="/insertOrder")
	public void insertOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		String msg="";
		String username = request.getParameter("username");
		String number = request.getParameter("number");
		String createtime = request.getParameter("createtime");
		String items_id = request.getParameter("items_id");
		String counts = request.getParameter("counts");
		String totalcash = request.getParameter("totalcash");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("number", number);
		map.put("createtime", createtime);
		map.put("items_id", items_id);
		map.put("counts", counts);
		map.put("totalcash", totalcash);
		
		boolean a = orderService.insertOrder(map);
		if(a){
			msg="SUCCESS";
		}else{
			msg="0";
		}
		jsonObject.put("msg", msg);
		om.writeValue(response.getWriter(), jsonObject);
	}
	
	@RequestMapping(value="/findOrdersByName")
	public void findOrdersByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		String msg="";
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
		String username = request.getParameter("username");
		OrderCustom orderCustom = new OrderCustom();
		orderCustom.setUsername(username);
		list = orderService.findOrdersByName(orderCustom);
		if(list.size()>0){
			msg="SUCESS";
		}else{
			msg="0";
		}
		jsonObject.put("msg", msg);
		jsonObject.put("list", list);
		om.writeValue(response.getWriter(), jsonObject);
	}
}
