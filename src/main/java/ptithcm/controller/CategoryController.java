package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dto.ProductCategoryDTO;
import ptithcm.model.product.ProductCategory;
import ptithcm.service.CategoryService;

@Controller
@RequestMapping(value = "/admin/product/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "category/new", method = RequestMethod.GET)
	public String showFormNewCategory(ModelMap modelMap) {
		List<ProductCategory> allCategories = categoryService.getAllCategory();
		modelMap.addAttribute("listCategory", allCategories);
		return "product/category/newCategory";
	}

	@RequestMapping(value = "category/new", method = RequestMethod.POST)
	public String handleAddNewCategoryRequest(@RequestParam String categoryName, @RequestParam String parentCategoryId,
			ModelMap model, HttpServletRequest request) {
		ProductCategory newCategory = new ProductCategory();
		newCategory.setCategoryName(categoryName);
		List<ProductCategory> allCategories = categoryService.getAllCategory();
		try {
			for (int i = 0; i < allCategories.size(); i++) {
				if (allCategories.get(i).getId().equals(Integer.parseInt(parentCategoryId))) {
					newCategory.setParentCategoryId(Integer.parseInt(parentCategoryId));
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Convert loi!!");
		}
		if (newCategory.getCategoryName().trim().isEmpty()) {
			return "redirect:/admin/product/category/list.htm";
		}
		categoryService.insertCategory(newCategory);

		return "redirect:/admin/product/category/list.htm";
	}

	@RequestMapping(value = "category/list", method = RequestMethod.GET)
	public String handleGetListCategory(ModelMap modelMap, @RequestParam(defaultValue = "5") int limit,
			@RequestParam(defaultValue = "1") int page) {

		List<ProductCategory> listCategories = categoryService.getListPaginatedCategories(limit * (page - 1), limit);
		List<ProductCategoryDTO> listCategoryDTOs = new ArrayList<ProductCategoryDTO>();
		for (int i = 0; i < listCategories.size(); i++) {
			ProductCategoryDTO categoryDTO = new ProductCategoryDTO(categoryService, listCategories.get(i));
			listCategoryDTOs.add(categoryDTO);
		}
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("limit", limit);
		modelMap.addAttribute("listCategory", listCategoryDTOs);
		return "product/category/listCategory";
	}
}
