package ptithcm.service;

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
	
}
