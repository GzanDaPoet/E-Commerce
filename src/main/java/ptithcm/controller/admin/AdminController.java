package ptithcm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.service.admin.LoginService;

@Controller
public class AdminController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String showAdminLogin() {
		return "admin/login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String handleAdminLoginRequest(@RequestParam String username, @RequestParam String password,
			ModelMap model) {
		if (service.validateUser(username, password)) {
			model.put("password", password);
			model.put("username", username);
			return "shop/index";
		} else {
			return "admin/login";
		}

	}

}
