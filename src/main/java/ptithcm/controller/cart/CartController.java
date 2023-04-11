package ptithcm.controller.cart;

import java.lang.reflect.Method;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.service.AddressService;
import ptithcm.service.CartService;


@RequestMapping("/e-commerce/")
@Controller
@Transactional
public class CartController{
	
	@Autowired
	CartService cartService;
	@Autowired
	AddressService addressService;
//	@RequestMapping(value = "cart")
//	public String showCart(ModelMap model) {
//		model.addAttribute("cart",cartService.dsCart());
//		return "e-commerce/cart";
//	}
	@RequestMapping(value = "cart")
	public String showCart(ModelMap model) {
		List<ShoppingCartItem> listCart = cartService.getAllCartItemsById(3);
		model.addAttribute("shoppingCart",listCart);
		return "e-commerce/cart";
	}
	
	@RequestMapping(params = "checkOut")
	public String showAddress(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressByID(1);
		model.addAttribute("customerAddress",addressList);
		return "e-commerce/address";
	}
	
	
}