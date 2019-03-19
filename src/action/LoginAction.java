package action;

import java.util.Map;


import biz.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDaoImpl;
import dao.UsersDao;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UsersDao userDao = new UserDaoImpl();
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Users user = new Users();
		user = userDao.hasUser(username, password);
		if(user.getUsername() == null) {
			this.addFieldError(username, "用户或密码不正确！");
			return INPUT;
		} else {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("user", user.getUsername());
		}
		return SUCCESS;
	}

}
