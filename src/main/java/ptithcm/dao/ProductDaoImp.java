package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.product.Product;



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
	
	public Product getProductById(int productId) {
	    Session session = factory.getCurrentSession();
	    String hql = "FROM Product p WHERE p.id = :productId";
	    Query query = session.createQuery(hql);
	    query.setParameter("productId", productId);
	    return (Product) query.uniqueResult();
	}

	public Integer getOrderID(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select ol.id FROM ProductItem pi, OrderLine ol where pi.id = :productId and pi.id = ol.productItem.id";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (int) query.uniqueResult();
	}
	
	public List<String> getAllCommentsById(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select cr.comment FROM OrderLine ol, CustomerReview cr where ol.id = :orderId and ol.id = cr.orderLine.id";
		Query query = session.createQuery(hql);
		query.setParameter("orderId", getOrderID(productId));
		List<String> comments = query.list();
		return comments;
	}
	
}
