package ptithcm.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.admin.CustomerAdminDao;
import ptithcm.model.customer.Customer;

@Service
public class CustomerAdminService {
	@Autowired
	CustomerAdminDao customerAdminDao;
	
	public List<Customer> getListCustomers() {
		return customerAdminDao.getListCustomers();
	}

}
