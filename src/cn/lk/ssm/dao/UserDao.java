package cn.lk.ssm.dao;

import java.util.List;

import cn.lk.ssm.po.User;

public interface UserDao {

	//���id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	//����û���Ʋ�ѯ�û��б�
	public List<User> findUserByName(String name) throws Exception;

	//����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;
	
}
