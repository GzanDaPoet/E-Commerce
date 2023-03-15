package ptithcm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String adminLoginDoGet() {
		return "admin/login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLoginDoPost() {
		return "admin/login";
	}

}
