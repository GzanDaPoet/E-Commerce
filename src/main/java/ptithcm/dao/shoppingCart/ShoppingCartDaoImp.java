package ptithcm.dao.shoppingCart;


import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ptithcm.model.shoppingCart.*;
import ptithcm.model.customer.*;

 


@Controller
@Transactional
public class ShoppingCartDaoImp  implements ShoppingCartDao{
	@Autowired
	SessionFactory factory;
	
	public List<ShoppingCart> dsCart(){
		Session session = 	factory.getCurrentSession();
		String hql = "FROM ShoppingCart";
		Query query = session.createQuery(hql);
		List<ShoppingCart> list = query.list();
		return list;
	}
	
	public List<ShoppingCartItem> getAllCartItemsById(int cartId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ShoppingCartItem s where s.cart.customer.id = :cartId";
		//String hql = "SELECT sci.productItemId, sci.qty, pi.price FROM ShoppingCartItem JOIN ShoppingCart sc ON sci.cartId = sc.id JOIN ProductItem pi ON sci.productItemId = pi.id WHERE sc.customerId = : address_id";
		//String hql = "SELECT sci FROM ShoppingCartItem sci JOIN sc.ShoppingCart sc WHERE sc.customerId = :cartId";
		Query query = session.createQuery(hql);
		query.setParameter("cartId", cartId);
		List<ShoppingCartItem> list = query.list();
		return list;
	}

}
