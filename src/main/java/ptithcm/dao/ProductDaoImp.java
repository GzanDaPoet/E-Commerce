package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.Product;

@Service
public class ProductDaoImp implements ProductDao{
	@Autowired
	SessionFactory factory;

	@Override
	public List<Product> getAllProducts() {
		Session session = factory.getCurrentSession();
		String hql ="FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		return list;
	}
	
}
