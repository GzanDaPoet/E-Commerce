package ptithcm.dao.product;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Service;

import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;

@Service
public class ProductDaoImp implements ProductDao {
	@Autowired
	SessionFactory factory;

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
	
	public void deleteProductItem(int productId) {
		try {
			Session session = factory.getCurrentSession();
			String hql = "Delete From ProductItem pi where pi.id = :productId";
			Query query = session.createQuery(hql);
			query.setParameter("productId", productId);
			query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public List<ProductItem> searchProductItem(String name) {
		try {
			Session session = factory.getCurrentSession();
			String hql = "SELECT pi FROM ProductItem pi WHERE pi.product.name LIKE :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name + '%');
			List<ProductItem> list = query.list();
			return list;
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
	}
	
	public List<Product> getAllProductByCateId(int categoryId) {
		try {
			Session session = factory.openSession();
			String hql = "Select p FROM Product p, ProductCategory pc where :categoryId = p.productCategory.id and p.productCategory.id = pc.id";
			Query query = session.createQuery(hql);
			query.setParameter("categoryId", categoryId);
			List<Product> list = query.list();
			return list;
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
}
