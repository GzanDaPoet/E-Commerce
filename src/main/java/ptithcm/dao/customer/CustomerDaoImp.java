package ptithcm.dao.customer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.customer.Customer;

@Service
public class CustomerDaoImp implements CustomerDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Customer c where c.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (Customer) query.uniqueResult();
	}


}
