package ptithcm.controller.cart;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	public static ShoppingCartItem shoppingCartItem;
	public static ProductItem productItem;
	
	@RequestMapping(value = "cart")
	public String showCart(ModelMap model,HttpSession ss) {
		int sum = 0;
		List<ShoppingCartItem> listCart = cartService.getAllCartItemsById(1);
		model.addAttribute("shoppingCart",listCart);
		for (ShoppingCartItem item : listCart ) {
			sum +=item.getProductItem().getPrice() * item.getQuantity(); 
			
		}
		ss.setAttribute("sum", sum);
		return "e-commerce/cart";
	}
	
	@RequestMapping(params = "checkOut")
	public String showAddress(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressListByID(1);
		model.addAttribute("customerAddress",addressList);
		return "e-commerce/address";
	}
	
	@RequestMapping(value ="cart/increase",method = RequestMethod.POST)
	public String increaseCartItem(@RequestParam("productId") int productId) {
		cartService.increaseQty(productId);
		return "redirect:/e-commerce/cart.htm";
	}
	
	@RequestMapping(value ="cart/decrease",method = RequestMethod.POST)
	public String decreaseCartItem(@RequestParam("productId") int productId) {
		cartService.decreaseQty(productId);
		return "redirect:/e-commerce/cart.htm";
	}

    @RequestMapping(value = "cart/delete", method = RequestMethod.POST)
    public String deleteCartItem(@RequestParam("productId") int productId) {
        cartService.deleteCartItem(productId);
		 return "redirect:/e-commerce/cart.htm";
    }
	
	
}