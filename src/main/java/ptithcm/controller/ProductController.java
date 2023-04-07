package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.stream.events.Comment;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shop.ShopOrder;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;
import ptithcm.service.ShoppingCartService;

@Transactional
@Controller
@RequestMapping("/e-commerce/")
public class ProductController {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ProductService productService;
	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	CustomerService customerService;

	@RequestMapping("shop")
	public String shop(ModelMap model) {
		List<ProductItem> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		return "e-commerce/shop";
	}

	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
	public String product(ModelMap model, @PathVariable("productId") int productId) {
		ProductItem product = productService.getProductById(productId);
		int cartId = shoppingCartService.isHaveCart(1);
		System.out.println("Cart ID: " + cartId);
		if (cartId > 0) {
			int quantityOrdered = shoppingCartService.getTotalQuantityOrdered(cartId);
			model.addAttribute("quantityOrdered", quantityOrdered);
			List<CustomerReview> comments = productService.getAllCommentsById(productId);
			for (CustomerReview s : comments) {
				System.out.println("UserName: " + s.getCustomer().getUserName());
				System.out.println("Comment: " + s.getComment());
			}
			Double ratingAve = productService.getRatingAverageProduct(productId);
			System.out.println("Rateing Average: " + ratingAve);
		}
		model.addAttribute("product", product);
		return "e-commerce/product";
	}

	@RequestMapping("list")
	public String index(ModelMap model) {
		List<ProductItem> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		return "e-commerce/list";
	}

//	@RequestMapping(value = "product/{productId}", method = RequestMethod.POST)
//	public String addToCart(ModelMap model, @PathVariable("productId") int productId,
//			@ModelAttribute("shoppingCartItem") ShoppingCartItem shoppingCartItem, HttpServletRequest request) {
//		ProductItem product = productService.getProductById(productId);
//		model.addAttribute("product", product);
//		Integer quantity = Integer.valueOf(request.getParameter("quantityInput"));
//		shoppingCartItem.setQuantity(quantity);
	// Kiểm tra khách hàng đã có giỏ hàng chưa
//		Customer customer = customerService.getCustomerById(1);
//		Integer cartId = shoppingCartService.isHaveCart(1);
//		Session session = sessionFactory.openSession();
//		Transaction t = session.beginTransaction();
//		if (cartId > 0) {
//			shoppingCartItem.setCart(shoppingCartService.getShoppingCartId(cartId, 1));
//			// Thêm sản phẩm vào giỏ hàng
//			try {
//				session.save(shoppingCartItem);
//				t.commit();
//				model.addAttribute("message", "Thêm mới thành công! ");
//			} catch (Exception e) {
//				t.rollback();
//				model.addAttribute("message", "Thêm mới thất bại! ");
//			} finally {
//				session.close();
//			}
//		}
//		// thêm giỏ hàng cho khách hàng
//		else {
//			ShoppingCart shoppingCart = new ShoppingCart();
//			shoppingCart.setCustomer(customer);
//			try {
//				session.save(shoppingCart);
//				t.commit();
//				model.addAttribute("message", "Thêm mới giỏ hàng thành công! ");	
//
//			} catch (Exception e) {
//				t.rollback();
//				model.addAttribute("message", "Thêm mới giỏ hàng thất bại! ");
//			} finally {
//				session.close();
//			}
//		}
//		int quantityOrdered = shoppingCartService.getTotalQuantityOrdered(cartId);
//		model.addAttribute("quantityOrdered", quantityOrdered);
//		return "e-commerce/product";
//	}

}
