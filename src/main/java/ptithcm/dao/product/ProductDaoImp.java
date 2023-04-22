package ptithcm.dao.product;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.customer.CustomerReview;
import ptithcm.model.product.ProductItem;

@Service
public class ProductDaoImp implements ProductDao {
	@Autowired
	SessionFactory factory;

//	@PersistenceContext 
//	private EntityManager entityManager;

	public List<ProductItem> getAllProducts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductItem";
		Query query = session.createQuery(hql);
		List<ProductItem> list = query.list();
		return list;
	}

	public ProductItem getProductById(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductItem p WHERE p.id = :productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (ProductItem) query.uniqueResult();
	}

	@Override
	public int updateQty(int Id, int qty) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE ProductItem s SET s.quantityInStock = s.quantityInStock + :qty WHERE s.id  = :Id";
		Query query = session.createQuery(hql);
		query.setParameter("qty", qty);
		query.setParameter("Id" , Id);
		int result = query.executeUpdate();
		return result;
	}

//	public Integer getOrderID(int productId) {
//		Session session = factory.getCurrentSession();
//		String hql = "Select ol.id FROM ProductItem pi, OrderLine ol where pi.id = :productId and pi.id = ol.productItem.id";
//		Query query = session.createQuery(hql);
//		query.setParameter("productId", productId);
//		return (int) query.uniqueResult();
//	}
//
//	public List<CustomerReview> getAllCommentsById(int productId) {
//		Session session = factory.getCurrentSession();
//		System.out.println("Cart ID: " + getOrderID(productId));
//		String hql = "SELECT cr FROM CustomerReview cr, OrderLine ol WHERE ol.id = cr.orderLine.id AND ol.id = :orderId";
//		Query query = session.createQuery(hql);
//		query.setParameter("orderId", getOrderID(productId));
//		List<CustomerReview> comments = query.list();
//		return comments;
//	}

}
