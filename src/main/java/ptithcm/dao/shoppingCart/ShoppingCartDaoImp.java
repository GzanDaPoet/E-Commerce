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
		Query query = session.createQuery(hql);
		query.setParameter("cartId", cartId);
		List<ShoppingCartItem> list = query.list();
		return list;
	}

	@Override
	public int deleteCartItem(int idCartItem) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM ShoppingCartItem WHERE id = " + idCartItem;
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int increaseQty(int shoppingCartItemId) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE ShoppingCartItem s SET s.quantity = s.quantity + 1 : WHERE s.id = :itemId";
		Query query = session.createQuery(hql);
		query.setParameter("itemId", shoppingCartItemId);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int decreaseQty(int shoppingCartItemId) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE ShoppingCartItem s SET s.quantity = s.quantity - 1 : WHERE s.id = :itemId";
		Query query = session.createQuery(hql);
		query.setParameter("itemId", shoppingCartItemId);
		int result = query.executeUpdate();
		return result;
	}

}
