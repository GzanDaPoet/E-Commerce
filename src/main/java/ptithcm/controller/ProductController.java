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
	@RequestMapping("/e-commerce/")
	public class ProductController {
		
		@Autowired
		ProductService productService;
		@RequestMapping("shop")
		public String shop(ModelMap model) {
			List<Product> list = productService.getListProducts();
			model.addAttribute("listProduct", list);
			return "e-commerce/shop";
		}
		
		@RequestMapping("product")
		public String product(ModelMap model) {
			List<Product> list = productService.getListProducts();
			model.addAttribute("listProduct", list);
			return "e-commerce/product";
		}
		
		
		@RequestMapping("list")
		public String index(ModelMap model) {
			List<Product> list = productService.getListProducts();
			model.addAttribute("listProduct", list);
			return "e-commerce/list";
		}
	}