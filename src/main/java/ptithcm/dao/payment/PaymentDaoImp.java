package ptithcm.dao.payment;



import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ptithcm.model.pay.CustomerPaymentMethod;
import ptithcm.model.ship.ShippingMethod;



@Controller
@Transactional
public class PaymentDaoImp  implements PaymentDao{
	@Autowired
	SessionFactory factory;
	
	public List<CustomerPaymentMethod> getPaymentListById(int ctmID){
		Session session = 	factory.getCurrentSession();
		String hql = "FROM CustomerPaymentMethod s where s.customer.id = :ctmID";
		Query query = session.createQuery(hql);
		query.setParameter("ctmID", ctmID);
		List<CustomerPaymentMethod> list = query.list();
		return list;
	}
	
	public List<ShippingMethod> getListShippingMethods() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ShippingMethod";
		Query query = session.createQuery(hql);
		List<ShippingMethod> list = query.list();
		return list;
	}

}