package cn.lk.ssm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lk.ssm.mapper.UserMapperCustom;
import cn.lk.ssm.po.User;
import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.po.UserQueryVo;
import cn.lk.ssm.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapperCustom userMapperCustom;
	@Override
	public User findUserById(int id) throws Exception {
		
		
		return userMapperCustom.findUserById(1);
	}
	@Override
	public UserCustom userLogin(UserQueryVo userQueryVo) throws Exception {
		return userMapperCustom.userLogin(userQueryVo);
	}
	@Override
	public UserCustom findUserByName(String username) throws Exception {
		return userMapperCustom.findUserByName(username);
	}
	@Override
	public boolean insertUser(Map<String, Object> map) throws Exception {
		
		return userMapperCustom.insertUser(map);
	}
	@Override
	public boolean updateUser(Map<String, Object> map) throws Exception {

		return userMapperCustom.updateUser(map);
	}

	
}
