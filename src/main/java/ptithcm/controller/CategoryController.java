package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {
	@RequestMapping(value = "/admin/product/category/new", method = RequestMethod.GET)
	public String handleAddNewCategory() {
		return "product/category/newCategory";
	}

	@RequestMapping(value = "/admin/product/category/list", method = RequestMethod.GET)
	public String handleGetListCategory() {
		return "product/category/listCategory";
	}
}
