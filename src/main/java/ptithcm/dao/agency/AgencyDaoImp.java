package ptithcm.dao.agency;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.model.agency.Agency;
import ptithcm.model.customer.Customer;
import ptithcm.model.inventory.StatusReceiving;
import ptithcm.model.shoppingCart.ShoppingCartItem;

@Service
public class AgencyDaoImp implements AgencyDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Agency getAgencyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Agency c where c.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (Agency) query.uniqueResult();
	}

	
	public List<Agency> getListAgencies() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Agency";
		Query query = session.createQuery(hql);
		List<Agency> list = query.list();
		return list;
	}

	public StatusReceiving getStatusReceivingById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From StatusReceiving c where c.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (StatusReceiving) query.uniqueResult();
	}
}
