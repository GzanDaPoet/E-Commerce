package ptithcm.dao.address;

import ptithcm.model.address.Address;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ptithcm.model.address.Address;
import ptithcm.model.customer.CustomerAddress;

@Controller
@Transactional
public class AddressDaoImp implements AddressDao {
	@Autowired
	SessionFactory factory;
	
	
//	public List<Address> getAddressByID(int addressId) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Address s WHERE s.id = :addressId";
//		Query query = session.createQuery(hql);
//		query.setParameter("addressId", addressId);
//		List<Address> addressList = query.list();
//		return addressList;
//	}
	
	public List<CustomerAddress> getAddressByID(int addressId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerAddress s WHERE s.customer.id = :addressId";
		Query query = session.createQuery(hql);
		query.setParameter("addressId", addressId);
		List<CustomerAddress> addressList = query.list();
		return addressList;
	}

}
