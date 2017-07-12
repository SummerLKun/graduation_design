package cn.lk.ssm.mapper;

import java.util.List;
import java.util.Map;

import cn.lk.ssm.po.User;
import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.po.UserQueryVo;

public interface UserMapperCustom {

	//用户查询列表
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//插入用户
	public boolean insertUser(Map<String, Object> map) throws Exception;
	
	public UserCustom userLogin(UserQueryVo userQueryVo) throws Exception;

	public UserCustom findUserByName(String username) throws Exception;
	
	public boolean updateUser(Map<String, Object> map) throws Exception;
	
}
