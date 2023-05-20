package ptithcm.dao.inventory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.inventory.StatusReceiving;
import ptithcm.model.shoppingCart.ShoppingCart;


@Service
public class InventoryDaoImp implements InventoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<StatusReceiving> getAllStatusReceivings(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM StatusReceiving";
		Query query = session.createQuery(hql);
		List<StatusReceiving> list = query.list();
		return list;
	}
}
