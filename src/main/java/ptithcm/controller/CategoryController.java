package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parent;
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
	public String handleGetListCategory(ModelMap modelMap) {
		List<ProductCategory> allCategories = categoryService.getAllCategory();
		List<ProductCategoryDTO> categoryDTOs = new ArrayList<ProductCategoryDTO>();
		try {
			for (int i = 0; i < allCategories.size(); i++) {
				String parentName = "";
				if (allCategories.get(i).getParentCategoryId() != null) {
					parentName = allCategories.get(allCategories.get(i).getParentCategoryId()).getCategoryName();
				}
				ProductCategoryDTO temProductCategoryDTO = new ProductCategoryDTO(allCategories.get(i), parentName);
				categoryDTOs.add(temProductCategoryDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("loi fen oi!");
		}
		modelMap.addAttribute("listCategory", categoryDTOs);
		return "product/category/listCategory";
	}
}
