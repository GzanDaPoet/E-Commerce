package ptithcm.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.dto.ProductDTO;
import ptithcm.model.customer.Customer;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.ProductItem;
import ptithcm.service.CategoryService;
import ptithcm.service.VariationService;
import ptithcm.service.admin.CustomerAdminService;
import ptithcm.service.admin.ProductAdminService;

@Controller
@Transactional
@RequestMapping("/admin/customer/")
public class CustomerAdminController {


	@Autowired
	CustomerAdminService customerAdminService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listCustomer(ModelMap modelMap) {
		List<Customer> listCustomers = customerAdminService.getListCustomers();
		modelMap.addAttribute("listCustomers",listCustomers);
		return "admin/customer/list";
	}

	@RequestMapping(value = "delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		return "redirect:/admin/product/list.htm";
	}


}
