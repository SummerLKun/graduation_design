package cn.lk.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.po.UserQueryVo;
import cn.lk.ssm.service.UserService;
import net.sf.json.JSONObject;


/**
 * @author Summer
 * 用户controller
 */
@Controller
@RequestMapping(value="/users")
public class userController {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/userLogin")
	public void userLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg="";
		
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername(username);
		userCustom.setPassword(password);
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		
		UserCustom reword = userService.userLogin(userQueryVo);

		if (reword != null) {
			session.setAttribute("username", username);
			session.setAttribute("id", reword.getId());
			msg="SUCCESS";
		}else {
			msg="0";
		}
		jsonObject.put("msg", msg);
		om.writeValue(response.getWriter(), jsonObject);
	}
	@RequestMapping(value="/insertUser")
	public void insertUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		String msg="";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");


		Map<String, Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		map.put("phone", phone);
		//先检查用户名是否存在
		UserCustom reword = userService.findUserByName(username);
		if (reword != null) {
			//如果返回值非空，表示该用户已经存在，不可以注册
			msg="NAME_EXISTS";
		}else {
			//返回值为空，表示用户名不存在，可以注册(insert into )
			boolean a = userService.insertUser(map);
			if(a){
				//插入用户成功
				System.out.println("插入用户成功");
				msg="插入用户成功";
				session.setAttribute("username", username);
			}else {
				System.out.println("插入用户失败");
				msg="插入用户失败";
			}
		}
		jsonObject.put("msg", msg);
		om.writeValue(response.getWriter(), jsonObject);
	}
	//通过用户名查用户所有信息
	@RequestMapping(value="/findUserByName")
	public void findUserByName(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");
		String msg="";
		String username = request.getParameter("username");
		UserCustom reword = userService.findUserByName(username);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if (reword != null) {
			//用户存在,获取用户信息并传前台
			msg="SUCCESS";
		}else {
			msg="USER_NOT_EXIST";
		}
		jsonObject.put("msg", msg);
		jsonObject.put("username", reword.getUsername());
		jsonObject.put("birthday", sdf.format(reword.getBirthday()));
		jsonObject.put("sex", reword.getSex());
		jsonObject.put("address", reword.getAddress());
		jsonObject.put("password", reword.getPassword());
		jsonObject.put("phone", reword.getPhone());
		om.writeValue(response.getWriter(), jsonObject);
	}
	@RequestMapping(value="/updateUser")
	public void updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject jsonObject = new JSONObject();
		ObjectMapper om = new ObjectMapper();
		String msg="";
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		map.put("birthday", birthday);
		map.put("sex", sex);
		map.put("phone", phone);
		map.put("address", address);
		
		boolean a = userService.updateUser(map);
		if (a) {
			//修改成功
			msg="SUCCESS";
		}else{
			//修改失败
			msg="0";
		}
		jsonObject.put("msg", msg);
		om.writeValue(response.getWriter(), jsonObject);
	}
}
