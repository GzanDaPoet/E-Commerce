package ptithcm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.product.ProductCategory;
import ptithcm.service.CategoryService;

@Controller
@RequestMapping("/admin/product/")
public class AdminProductController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String showFormCreateNewProduct(ModelMap modelMap) {
		List<ProductCategory> allCategories = categoryService.getAllCategory();
		modelMap.addAttribute("listCategory", allCategories);
		return "product/manage-product/createNewProduct";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String handleSubmitFormCreateProduct(
			@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "categoryId", required = true) String categoryId,
			@RequestParam(value = "description", required = true) String productDescription,
			@RequestParam("SKU") List<String> SKU) {
		System.out.println(productName);
		System.out.println(categoryId);
		System.out.println(productDescription);
		return "redirect:/admin/product/category/new.htm";
	}

}
