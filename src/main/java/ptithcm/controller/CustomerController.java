package ptithcm.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.customer.Customer;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.ProductItem;
import ptithcm.model.promotion.Promotion;
import ptithcm.model.promotion.PromotionCategory;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductCategoryService;
import ptithcm.service.ProductService;
import ptithcm.service.UserService;
import ptithcm.service.admin.LoginService;
import ptithcm.util.SessionUtil;
import ptithcm.model.user.User;

@Transactional
@Controller
@RequestMapping(value = "/e-commerce/")
public class CustomerController {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	LoginService service;

	@Autowired
	UserService userService;
	
	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin() {
		return "e-commerce/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String handleAdminLoginRequest(@RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		Customer customer = customerService.getCustomerByUsernamePassword(username, password);
		if (customer != null) {
			SessionUtil.getInstance().putValue(request, "CUSTOMER_MODEL", customer);
			System.out.println(customer.getUserName());
			return "redirect:/e-commerce/shop.htm";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam Integer productId) {

		return "redirect:/";

	}

}
