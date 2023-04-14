package ptithcm.controller.cart;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;
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
	public static ShoppingCartItem shoppingCartItem;
	
	
	public static ProductItem productItem;
	@RequestMapping(value = "cart")
	public String showCart(ModelMap model,HttpSession ss) {
		int sum = 0;
		List<ShoppingCartItem> listCart = cartService.getAllCartItemsById(3);
		model.addAttribute("shoppingCart",listCart);
		for (ShoppingCartItem item : listCart ) {
			sum +=item.getProductItem().getPrice() * item.getQuantity(); 
			
		}
		ss.setAttribute("sum", sum);
		return "e-commerce/cart";
	}
	
	@RequestMapping(params = "checkOut")
	public String showAddress(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressByID(1);
		model.addAttribute("customerAddress",addressList);
		return "e-commerce/address";
	}
	
	@RequestMapping(value = "cart/delete",params = "idcart",method = RequestMethod.POST)
	public String deleteCart(@RequestParam(required = true) int idcart,  RedirectAttributes ra,ModelMap model) {
		int result = cartService.deleteCartItem(idcart);
		model.addAttribute("delete",result);
		ra.addFlashAttribute("delete_cart",0);
		System.out.println("kq");
		return "e-commerce/cart";
	}
	
}