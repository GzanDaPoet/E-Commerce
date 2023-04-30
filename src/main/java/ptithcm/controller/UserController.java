package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

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
import ptithcm.service.CategoryService;
import ptithcm.service.VariationService;

@Controller
@RequestMapping(value="/admin/")
public class UserController{
	
	@RequestMapping(value="adduser")
	public String  adduser () {
		return "admin/adduser";
	}
	
}