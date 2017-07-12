package cn.lk.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.lk.ssm.po.ItemsCustom;
import cn.lk.ssm.po.ItemsQueryVo;
import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.service.ItemsService;
import net.sf.json.JSONObject;
 /**
 * 
 * Title: ItemsController
 * Description:商品的controller
 */
@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

/*	//商品信息的页面显示
	@RequestMapping("/editItems")
	public ModelAndView editItems() throws Exception{
		
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		
		ModelAndView modelAndView = new ModelAndView();
		//将商品信息放到model
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		//商品修改页面
		modelAndView.setViewName("items/editItems");
		
		return modelAndView;
	}*/
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id)throws Exception {
		
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom", itemsCustom);
		
		return "items/editItems";
	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom)throws Exception {
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		
		//重定向到商品查询列表
//		return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		return "success";
	}
	
	//获取商品列表
	@RequestMapping("/getItemList")
	public void getItemList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		try{
			list = itemsService.findItemsList(null);
			if (list.size()>0) {
				//get到Items的数据了
				msg="SUCCESS";
			}else{
				msg="0";
			}
			jsonObject.put("msg", msg);
			jsonObject.put("list", list);
		}catch(Exception o)	{
			o.printStackTrace();
		}
		try {
			om.writeValue(response.getWriter(), jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/findItemsBy")
	public void findItemsBy(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		String itemname = request.getParameter("itemname");
		String class_id = request.getParameter("class_id");
		String itemsId = request.getParameter("itemsId");
		
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setName(itemname);
		itemsCustom.setClass_id(Integer.parseInt(class_id));
		itemsCustom.setId(Integer.parseInt(itemsId));
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		try {
			list = itemsService.findItemsList(itemsQueryVo);
			if(list.size()>0){
				msg="SUCCESS";
			}else{
				msg="0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("msg", msg);
		jsonObject.put("list", list);
		om.writeValue(response.getWriter(), jsonObject);
	}
	@RequestMapping("/findItemsByName")
	public void findItemsByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		String itemname = request.getParameter("itemname");
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setName(itemname);
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		try {
			list = itemsService.findItemsListByName(itemsQueryVo);
			if(list.size()>0){
				msg="SUCCESS";
			}else{
				msg="0";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("msg", msg);
		jsonObject.put("list", list);
		om.writeValue(response.getWriter(), jsonObject);
	}
	@RequestMapping("/findMyItems")
	public void findMyItems(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		String username = request.getParameter("username");
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername(username);
		
		list = itemsService.findMyItems(userCustom);
		if (list.size()>0) {
			msg="SUCCESS";
		}else {
			msg="0";
		}
		jsonObject.put("msg", msg);
		jsonObject.put("list", list);
		om.writeValue(response.getWriter(), jsonObject);
	}
	@RequestMapping("/insertItems")
	public void insertItems(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		String pic = request.getParameter("pic");
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String class_id = request.getParameter("class_id");
		String user_id = request.getParameter("user_id");
		String createtime = request.getParameter("createtime");
		
		
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setClass_id(Integer.parseInt(class_id));
		itemsCustom.setDetail(detail);
		itemsCustom.setName(name);
		itemsCustom.setPic(pic);
		itemsCustom.setPrice(Float.parseFloat(price));
		itemsCustom.setUser_id(Integer.parseInt(user_id));
		itemsCustom.setCreatetime(createtime);
		
		boolean a = itemsService.insertItems(itemsCustom);
		if (a) {
			msg="SUCCESS";
		}else{
			msg="0";
		}
		jsonObject.put("msg", msg);
		om.writeValue(response.getWriter(), jsonObject);
	}
}
