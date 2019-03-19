package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import biz.Users;

public class UserDaoImpl implements UsersDao {
	HibernateSessionFactory hsf = new HibernateSessionFactory();

	public void addUser(Users user) {
		Session session = hsf.getSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(user);
			ts.commit();
		} catch (Exception e) {
			System.out.println("UserDaoImpl.add() 方法发生异常:");
			e.printStackTrace();
		} finally {
			hsf.closeSession();
		}
	}

	public boolean hasSameName(String username) {
		Session session = hsf.getSession();

		try {
			String sql = "from Users u where u.username=?";
			Query query = session.createQuery(sql);
			query.setString(0, username);
			List list = query.list();
			Iterator itor = list.iterator();
			while (itor.hasNext()) {
				Users user = (Users) itor.next();
				String name = user.getUsername();
				if (name.equals(username)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("UserDaoImpl.hasSameName() 方法发生异常:");
			e.printStackTrace();
			return false;
		} finally {
			hsf.closeSession();
		}
		return false;
	}

	public Users hasUser(String username, String password) {
		Session session = hsf.getSession();
		try {
			String sql = "from Users as u where u.username=? and u.password=?";
			// String sql = "from Users";
			Query query = session.createQuery(sql);
			query.setString(0, username);
			query.setString(1, password);
			List list = query.list();
			if (list != null && list.size() != 0) {
				Iterator itor = list.iterator();
				Users user = (Users) itor.next();
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("UserDaoImpl.hasUser() 方法发生异常:");
			e.printStackTrace();
			return null;
		} finally {
			hsf.closeSession();
		}
	}

}
