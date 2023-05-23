package ptithcm.controller.admin;

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

import ptithcm.model.product.Product;
import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.ProductItem;
import ptithcm.model.promotion.Promotion;
import ptithcm.model.promotion.PromotionCategory;
import ptithcm.service.ProductCategoryService;
import ptithcm.service.ProductService;
import ptithcm.service.UserService;
import ptithcm.service.admin.LoginService;
import ptithcm.util.SessionUtil;
import ptithcm.model.user.User;
import ptithcm.model.user.UserPermission;

@Transactional
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {


	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	LoginService service;

	@Autowired
	UserService userService;

	

	@Autowired
	ProductService productService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showAdminLogin() {
		return "admin/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String handleAdminLoginRequest(@RequestParam String username, @RequestParam String password, ModelMap model,
			HttpServletRequest request) {
		User user = userService.findByUserNameAndPasswordAndStatus(username, password, true);
		if (user != null) {
			SessionUtil.getInstance().putValue(request, "USER_MODEL", user);
			if (user.getUserPermission().getValue().equals("ROLE_USER")) {
				return "redirect:/e-commerce/shop.htm";
			} else if (user.getUserPermission().getValue().equals("ROLE_ADMIN")
					|| user.getUserPermission().getValue().equals("ROLE_SUPER_ADMIN")) {
				return "redirect:/e-commerce/shop.htm";
			}
		}
		return "redirect:/e-commerce/shop.htm";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String deleteProduct(@RequestParam Integer productId) {
		
		return "redirect:/";
				
	}
	
	

}
