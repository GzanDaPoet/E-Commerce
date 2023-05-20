package ptithcm.dao.address;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ptithcm.model.address.Address;
import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.product.ProductItem;


public interface AddressDao {
	//public List<Address> getAddressByID(int addressId);
	public List<CustomerAddress> getAddressListByID(int addressId);
	public int deleteAddress(int addressId);
	public int deleteCustomerAddress(int addressId);
	public CustomerAddress getAddressById(int addressId);
		
}
