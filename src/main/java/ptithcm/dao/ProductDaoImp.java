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

	public int getOrderID(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select Order_Line.order_id FROM Product_Item , Order_Line where Product_Item.id = :productId and Product_Item.id = Order_Line.product_item_id";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (int) query.uniqueResult();
	}
	
	public List<String> getAllCommentsById(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select Customer_Review.comment FROM Order_Line , Customer_Review where Order_Line.id = 1 and Order_Line.id = Customer_Review.ordered_product_id";
		Query query = session.createQuery(hql);
		query.setParameter("orderId", 1);
		List<String> comments = query.list();
		return comments;
	}
	
}
