	package ptithcm.controller;
	
	import java.util.List;
	
	import javax.transaction.Transactional;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
		public String product(ModelMap model, @PathVariable("productId") int productId) {
			Product product = productService.getProductById(productId);
			List<String> comments = productService.getAllCommentsById(productId);
			if (!comments.isEmpty()) {
				model.addAttribute("comments", comments);
			}
		
			model.addAttribute("product", product);
			return "e-commerce/product";
		}
		
		
		@RequestMapping("list")
		public String index(ModelMap model) {
			List<Product> list = productService.getListProducts();
			model.addAttribute("listProduct", list);
			return "e-commerce/list";
		}
	}