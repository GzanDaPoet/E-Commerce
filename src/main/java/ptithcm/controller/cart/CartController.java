package ptithcm.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import ptithcm.service.CartService;


@RequestMapping("/e-commerce/")
@Controller
public class CartController{
	
	@Autowired
	CartService cartService;
	
	

	@RequestMapping(value = "cart")
	public String showAdminLogin(ModelMap model) {
		model.addAttribute("cart",cartService.dsCart());
		return "e-commerce/cart";
	}
}