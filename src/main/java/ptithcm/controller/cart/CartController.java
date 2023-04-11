package ptithcm.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.service.CartService;


@RequestMapping("/e-commerce/")
@Controller
public class CartController{
	
	@Autowired
	CartService cartService;

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
}