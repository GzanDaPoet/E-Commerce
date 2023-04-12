package ptithcm.dao.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.model.user.User;

@Repository
public class UserDaoImp implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findByUserNameAndPasswordAndStatus(String userName, String password, boolean status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User c where c.username = :username and c.password = :password and c.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		query.setParameter("status", status);
		return (User) query.uniqueResult();
	}
}
