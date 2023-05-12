package ptithcm.dao.address;


import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ptithcm.model.address.Address;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.product.ProductItem;

@Controller
@Transactional
public class AddressDaoImp implements AddressDao {
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<CustomerAddress> getAddressListByID(int addressId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerAddress s WHERE s.customer.id = :addressId";
		Query query = session.createQuery(hql);
		query.setParameter("addressId", addressId);
		List<CustomerAddress> addressList = query.list();
		return addressList;
	}

	@Override
	public int deleteAddress(int id) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM Address WHERE id = " + id;
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int deleteCustomerAddress(int id) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM CustomerAddress WHERE id = " + id;
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public CustomerAddress getAddressById(int addressId) {
			Session session = factory.getCurrentSession();
			String hql = "FROM CustomerAddress p WHERE p.id = :addressId";
			Query query = session.createQuery(hql);
			query.setParameter("addressId", addressId);
			return (CustomerAddress) query.uniqueResult();
		}

}
