package cn.lk.ssm.po;


/**
 * @author Summer
 * 用户包装对象
 */
public class UserQueryVo {

	//用户信息
	private User user;
	
	private UserCustom userCustom;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	
}
