package ptithcm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.model.user.User;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;
import ptithcm.service.ShoppingCartService;
import ptithcm.util.SessionUtil;
import ptithcm.service.admin.PromotionService;

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
	
	@Autowired
	PromotionService promotionService;
	

	@RequestMapping("shop")
	public String shop(ModelMap model, HttpServletRequest request) {
		List<ProductItem> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		User user = (User) SessionUtil.getInstance().getValue(request, "USER_MODEL");
		return "e-commerce/shop";
	}


	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
	public String product(ModelMap model, @PathVariable("productId") int productId) {
		ProductItem product = productService.getProductById(productId);
		System.out.println("Product Image URL: " + product.getProductImage());
		int cartId = shoppingCartService.isHaveCart(1);
		System.out.println("Cart ID: " + cartId);
		if (cartId > 0) {
			int quantityOrdered = shoppingCartService.getTotalQuantityOrdered(cartId);
			System.out.println("quantity: " + quantityOrdered);
			model.addAttribute("quantityOrdered", quantityOrdered);
			List<CustomerReview> comments = productService.getAllCommentsById(productId);
			if (comments != null) {
				Collections.reverse(comments);
				model.addAttribute("comments", comments);
			}
		}
		model.addAttribute("product", product);
		return "e-commerce/product";
	}

	@RequestMapping("list")
	public String list(ModelMap model) {
		List<ProductItem> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		return "e-commerce/list";
	}

	@RequestMapping(value = "product/{productId}", method = RequestMethod.POST, params = "addToCart")
	public String addToCart(ModelMap model, @PathVariable("productId") int productId,
			@ModelAttribute("shoppingCartItem") ShoppingCartItem shoppingCartItem, HttpServletRequest request) {
		ProductItem product = productService.getProductById(productId);
		model.addAttribute("product", product);
		Integer quantity = Integer.valueOf(request.getParameter("quantityInput"));
		shoppingCartItem.setQuantity(quantity);
		Customer customer = customerService.getCustomerById(1);
		int cartId = shoppingCartService.isHaveCart(1);
		if (cartId > 0) {
			int quantityOrdered = shoppingCartService.getTotalQuantityOrdered(cartId);
			model.addAttribute("quantityOrdered", quantityOrdered);
			List<CustomerReview> comments = productService.getAllCommentsById(productId);
			if (comments != null) {
				model.addAttribute("comments", comments);
			}
		}
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (cartId > 0) {
			shoppingCartItem.setCart(shoppingCartService.getShoppingCartId(cartId, 1));
			try {
				session.save(shoppingCartItem);
				t.commit();
				model.addAttribute("message", "Thêm mới thành công! ");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm mới thất bại! ");
			} finally {
				session.close();
			}
		} else {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setCustomer(customer);
			try {
				session.save(shoppingCart);
				t.commit();
				model.addAttribute("message", "Thêm mới giỏ hàng thành công! ");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Thêm mới giỏ hàng thất bại! ");
			} finally {
				session.close();
			}
		}
		int quantityOrdered = shoppingCartService.getTotalQuantityOrdered(cartId);
		model.addAttribute("quantityOrdered", quantityOrdered);
		return "e-commerce/product";
	}

	@RequestMapping(value = "product/{productId}", method = RequestMethod.POST, params = "addComment")
	public String addComment(ModelMap model, @PathVariable("productId") int productId,
			@ModelAttribute("CustomerReview") CustomerReview customerReview, HttpServletRequest request) {
		Customer customer = customerService.getCustomerById(1);
		customerReview.setCustomer(customer);
		String comment = request.getParameter("commentInput").trim();
		customerReview.setComment(comment);
		customerReview.setOrderLine(productService.getOrderLinebyId(productId));
		customerReview.setRatingValue(5);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (customerReview.getComment() != "") {
			try {
				session.save(customerReview);
				t.commit();
				model.addAttribute("message", "Success");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Fail");
			} finally {
				session.close();
			}
		}
		return product(model, productId);
	}

	@RequestMapping(value = "list/delete/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		System.out.println("Vao day");
		System.out.println("Product Id: " + productId);
		productService.deleteProductItem(productId);
		return "redirect:/e-commerce/list.htm";
	}

	/*
	 * @RequestMapping(value = "list", method = RequestMethod.POST, params =
	 * "searchText") public String searchProduct(ModelMap model, HttpServletRequest
	 * request) { String searchText = request.getParameter("searchText").trim();
	 * List<ProductItem> list = productService.searchProductItem(searchText);
	 * model.addAttribute("listProduct", list); return "e-commerce/list"; }
	 */

	/*
	 * @RequestMapping(value = "list", method = RequestMethod.GET, params =
	 * "filter") public String processSelectedItem(ModelMap
	 * model, @RequestParam("selectOption") String selectOption) { List<ProductItem>
	 * listProductItems = productService.getListProducts(); if
	 * (selectOption.equals("active")) { System.out.println("Chon active");
	 * List<ProductItem> listActiveItems = new ArrayList<>(); for (ProductItem
	 * productItem : listProductItems) { if
	 * (productItem.getStatus().equals("In stock")) {
	 * listActiveItems.add(productItem); } } model.addAttribute("listProduct",
	 * listActiveItems); } else if (selectOption.equals("inactive")) {
	 * System.out.println("Chon InActive"); List<ProductItem> listInActiveItems =
	 * new ArrayList<>(); for (ProductItem productItem : listProductItems) { if
	 * (productItem.getStatus().equals("Out of stock")) {
	 * listInActiveItems.add(productItem); } } model.addAttribute("listProduct",
	 * listInActiveItems); } else if (selectOption.equals("all")) {
	 * model.addAttribute("listProduct", listProductItems); } return
	 * "e-commerce/list"; }
	 */

}
