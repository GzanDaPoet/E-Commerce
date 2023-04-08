package ptithcm.dao.shoppingCart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;

@Service
public class ShoppingCartDaoImp implements ShoppingCartDao {
	@Autowired
	SessionFactory factory;

	public List<ShoppingCart> getAllShoppingCart() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ShoppingCart";
		Query query = session.createQuery(hql);
		List<ShoppingCart> list = query.list();
		System.out.println("List size: " + list.size());
		return list;
	}

	public List<ShoppingCartItem> getAllCartItemsById(int cartId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ShoppingCartItem s where s.cart.id = :cartId";
		Query query = session.createQuery(hql);
		query.setParameter("cartId", cartId);
		List<ShoppingCartItem> list = query.list();
		return list;
	}

}
