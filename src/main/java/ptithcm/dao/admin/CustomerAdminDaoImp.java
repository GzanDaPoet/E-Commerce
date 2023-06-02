package ptithcm.dao.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.model.customer.Customer;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;

@Repository
public class CustomerAdminDaoImp implements CustomerAdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getListCustomers() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}

}
