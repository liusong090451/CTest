package dao;

import biz.Users;

public interface UsersDao {
	public void addUser(Users user);
	public Users hasUser(String username, String password);
	public boolean hasSameName(String username);
}
