package cn.lk.ssm.service;

import java.util.Map;

import cn.lk.ssm.po.User;
import cn.lk.ssm.po.UserCustom;
import cn.lk.ssm.po.UserQueryVo;

/**
 * @author Summer
 *用户管理service
 */
public interface UserService {
	
	//查询用户id
	public User findUserById(int id) throws Exception;
	//检查用户名和密码是否一致
	public UserCustom userLogin(UserQueryVo userQueryVo) throws Exception;
	//检查用户名是否已经存在
	public UserCustom findUserByName(String username) throws Exception;
	//插入用户
	public boolean insertUser(Map<String, Object> map) throws Exception;
	
	public boolean updateUser(Map<String, Object> map) throws Exception;
	
	
}
