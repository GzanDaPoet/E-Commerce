package ptithcm.dao.address;



import java.util.List;

import ptithcm.model.address.Address;
import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerAddress;


public interface AddressDao {
	//public List<Address> getAddressByID(int addressId);
	public List<CustomerAddress> getAddressByID(int addressId);
}
