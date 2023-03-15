package ptithcm.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ptithcm.model.admin.User;

public class UserImp implements UserDao {
	@Autowired
	SessionFactory factory;
	
	@Override
	public User findUserByName(String username) {
		Session session = factory.getCurrentSession();
		String hql ="FROM Product where username = " + username;
		Query query = session.createQuery(hql);
		User user = (User) query.list();
		return user;
	}
	
}
