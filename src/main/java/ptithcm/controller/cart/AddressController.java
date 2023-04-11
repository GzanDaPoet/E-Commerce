package ptithcm.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.model.address.Address;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.service.AddressService;



@RequestMapping("/e-commerce/")
@Controller
public class AddressController{
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "address")
//	public String showCart(ModelMap model) {
//		List<Address> addressList = addressService.getAddressByID(1);
//		model.addAttribute("address",addressList);
//		return "e-commerce/address";
//	}
	public String showCart(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressByID(1);
		model.addAttribute("customerAddress",addressList);
		return "e-commerce/address";
	}
	
}