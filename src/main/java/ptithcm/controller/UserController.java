package ptithcm.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dto.ProductVariationDTO;
import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.Variation;
import ptithcm.model.user.User;
import ptithcm.model.user.UserPermission;
import ptithcm.service.CategoryService;
import ptithcm.service.UserService;
import ptithcm.service.VariationService;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value="new")
	public String  newUser (ModelMap model) {
		List<UserPermission> list = userService.getListUserPermissions();
		model.addAttribute("listPermission",list);
		return "user/new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String newUser (@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("permission") Integer permision,
			ModelMap model) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setUserPermission(userService.getPermissionById(permision));
		newUser.setStatus(true);
		System.out.println(newUser.getUsername());
		System.out.println(newUser.getPassword());
		System.out.println(newUser.getEmail());
		System.out.println(newUser.getUserPermission().getValue());
		Session session1 = sessionFactory.openSession();
		org.hibernate.Transaction t =  session1.beginTransaction();
				try {
			session1.save(newUser);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công! ");
			System.out.println("done");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại! ");
			System.out.println(e);
		} finally {
			session1.close();
		}
		return "redirect:/user/new.htm";
	}
	
	@RequestMapping(value="list")
	public String  listUser (ModelMap model) {
		List<User> list = userService.getAllUser();
		model.addAttribute("listUser",list);
		return "user/list";
	}
	
}