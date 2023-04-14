package ptithcm.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.address.AddressDao;
import ptithcm.dao.order.OrderStatusDao;
import ptithcm.model.address.Address;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.order.OrderStatus;



@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private OrderStatusDao orderStatusDao;
	
	public  List<CustomerAddress> getAddressListByID(int id){
		List<CustomerAddress> addressList = addressDao.getAddressListByID(id);
		if (addressList == null) {
			return null;
		}
		return addressList;
	}
	
	public int deleteAddress(int addressID) {
		int delete = addressDao.deleteAddress(addressID);
		return delete;
	}
	
	public int deleteCustomerAddress(int addressID) {
		int delete = addressDao.deleteCustomerAddress(addressID);
		return delete;
	}
	
	public CustomerAddress getAddressById(int addressId) {
		CustomerAddress address = addressDao.getAddressById(addressId);
		return address;
	}
	public OrderStatus getOrderStatusById(int Id) {
		OrderStatus status = orderStatusDao.getOrderStatusById(Id);
		return status;
	}
}
