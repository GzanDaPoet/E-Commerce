package ptithcm.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.address.AddressDao;
import ptithcm.model.address.Address;
import ptithcm.model.customer.CustomerAddress;



@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
//	public  List<Address> getAddressByID(int id){
//		List<Address> addressList = addressDao.getAddressByID(id);
//		if (addressList == null) {
//			return null;
//		}
//		return addressList;
//	}
	public  List<CustomerAddress> getAddressByID(int id){
		List<CustomerAddress> addressList = addressDao.getAddressByID(id);
		if (addressList == null) {
			return null;
		}
		return addressList;
	}
	
}
