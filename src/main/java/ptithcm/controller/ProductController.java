package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.model.product.Product;
import ptithcm.service.ProductService;

@Transactional
@Controller
@RequestMapping("/shop/")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("index")
	public String index(ModelMap model) {
		List<Product> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		model.addAttribute("category", list.get(0).getCategory().getCategoryName());
		return "shop/index";
	}
}