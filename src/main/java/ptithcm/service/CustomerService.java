package ptithcm.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.customer.CustomerDao;
import ptithcm.model.customer.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	public Customer getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		if (customer != null) {
			return  customer;
		}
		return null;
	}
	
	public List<Integer> getListAddressById(int id){
		List<Integer> listAdressID = customerDao.getListAddressById(id);
		if(listAdressID != null) {
			return listAdressID;
		}
		return null;
	}
	
}
