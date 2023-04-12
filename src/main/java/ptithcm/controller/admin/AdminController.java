package ptithcm.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.controller.ProductController;
import ptithcm.model.user.User;
import ptithcm.service.UserService;
import ptithcm.service.admin.LoginService;
import ptithcm.util.SessionUtil;

@Controller
@RequestMapping(value = "/admin/")
public class AdminController {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	LoginService service;

	@Autowired
	UserService userService;

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
			if (user.getUser_permission().getValue().equals("ROLE_USER")) {
				return "redirect:/e-commerce/shop.htm";
			} else if (user.getUser_permission().getValue().equals("ROLE_ADMIN")
					|| user.getUser_permission().getValue().equals("ROLE_SUPER_ADMIN")) {
				return "redirect:/e-commerce/list.htm";
			}
		}
		return "redirect:/";
	}

}
