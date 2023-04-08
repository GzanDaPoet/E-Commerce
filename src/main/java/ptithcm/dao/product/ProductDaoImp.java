package ptithcm.dao.product;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shop.ShopOrder;

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

	public Integer getOrderID(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select ol.id FROM ProductItem pi, OrderLine ol where pi.id = :productId and pi.id = ol.productItem.id";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (int) query.uniqueResult();
	}

	public List<CustomerReview> getAllCommentsById(int productId) {
	    Session session = factory.getCurrentSession();
	    String hql = "SELECT cr FROM CustomerReview cr JOIN cr.orderLine ol JOIN ol.productItem pi WHERE pi.id = :productId";
	    Query query = session.createQuery(hql);
	    query.setParameter("productId", productId);
	    List<CustomerReview> comments = query.list();	
	    return comments;
	}
	
	public Double getRatingAverageProduct(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select AVG(cr.ratingValue) From CustomerReview cr JOIN cr.orderLine ol JOIN ol.productItem pi WHERE pi.id = :productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (Double) query.uniqueResult();
	}
	
	public OrderLine getOrderLineById(int productId) {
		Session session = factory.getCurrentSession();
		String hql = "Select cr.orderLine From CustomerReview cr JOIN cr.orderLine ol JOIN ol.productItem pi WHERE pi.id = :productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (OrderLine) query.uniqueResult();
	}
	
}
