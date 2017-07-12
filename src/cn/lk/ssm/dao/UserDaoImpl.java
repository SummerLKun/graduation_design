package cn.lk.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.lk.ssm.po.User;

public class UserDaoImpl implements UserDao{

	//��Ҫ��daoʵ������ע��sqlsessionFactory
	//����ͨ���캯��ע��
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById", id);
		
		//�ͷ���Դ
		sqlSession.close();
		
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName",name);

		// �ͷ���Դ
		sqlSession.close();

		return list;
	}
	
	
	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ�в���Ĳ��� 
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		
		//�ͷ���Դ
		sqlSession.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ִ�в���Ĳ���
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();

		// �ͷ���Դ
		sqlSession.close();
	}


	
	
	
	
}
