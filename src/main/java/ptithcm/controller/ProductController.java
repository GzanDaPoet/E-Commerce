package ptithcm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import javax.swing.event.ListDataListener;
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

import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;
import ptithcm.model.promotion.Promotion;
import ptithcm.model.promotion.PromotionCategory;
import ptithcm.model.shop.ShopOrder;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;
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
		Date curentDate = new Date();
		List<Promotion> promotionList = promotionService.getAllPromotions();
		List<ProductItem> listProductItemAdd = new ArrayList<>(); 
		for (Promotion promotion: promotionList) {
			int compare = curentDate.compareTo(promotion.getEndDate());
			if (compare > 0) {
				PromotionCategory promotionCategory = promotionService.getPromotionCategoryById(promotion.getId());
				int categoryId = promotionCategory.getProductCategory().getId();
				List<Product> listProductOutDatePromotionList = productService.getAllProductByCateId(categoryId);
				for (Product product : listProductOutDatePromotionList) {
					List<ProductItem> listProductItems = (List<ProductItem>) product.getProductItems();
					listProductItemAdd.addAll(listProductItems);
				}
			}
			
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				for (ProductItem productItem : listProductItemAdd) {
					productItem.setStatus("");
					session.merge(productItem);
				}
				tx.commit();
				System.out.println("Thanh cong");
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
					System.out.println("That bai: " + e.toString());
				}
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		
		List<ProductItem> list = productService.getListProducts();
		model.addAttribute("listProduct", list);
		return "e-commerce/shop";
	}
	
	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
	public String product(HttpServletRequest request, ModelMap model, @PathVariable("productId") int productId) {
		int id = 0;
		if (SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL") != null) {
			id = (int) ((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL")).getId();
		}
		System.out.println("ID customer: " + id);
		ProductItem product = productService.getProductById(productId);
		System.out.println("Status: " + product.getStatus());
		Boolean onSale = false;
		if (product.getStatus().equals("ON_SALE")) {
			int salePrice = product.getPrice() * (100 - promotionService.getPriceDiscount(productId)) / 100;
			model.addAttribute("salePrice" , salePrice);
			onSale = true;
		}
		model.addAttribute("onSale", onSale);
		
		int quantityOrdered = 0;
		int cartId = 0;
		if (id > 0) {
			Customer customer = customerService.getCustomerById(id);
			if (shoppingCartService.getAllCartItemsById(id).size() == 0) {
				System.out.println("Them gio hang cho khach hang");
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setCustomer(customer);
				Session session = sessionFactory.openSession();
				Transaction t = session.beginTransaction();
				try {
					session.save(shoppingCart);
					t.commit();
					model.addAttribute("message", "Thêm mới thành công! ");
				} catch (Exception e) {
					t.rollback();
					model.addAttribute("message", "Thêm mới thất bại! ");
				} finally {
					session.close();
				}

			} else {
				cartId = shoppingCartService.getAllCartItemsById(id).size();
			}
			if (cartId > 0) {
				quantityOrdered = shoppingCartService.getTotalQuantityOrdered(id);
				model.addAttribute("quantityOrdered", quantityOrdered);
			}
		}
		OrderLine orderLine = productService.isBoughtThisProduct(id, productId);
		boolean isBought;
		if (orderLine == null) {
			isBought = false;
		}
		else {
			isBought = true;
		}
		model.addAttribute("isBought", isBought);
		System.out.println("is bought: " + isBought);
		
		List<CustomerReview> comments = productService.getAllCommentsById(productId);
		if (comments != null) {
			Collections.reverse(comments);
			model.addAttribute("comments", comments);
		}
		model.addAttribute("quantityOrdered", quantityOrdered);
		model.addAttribute("product", product);
		return "e-commerce/product";
	}


	@RequestMapping(value = "product/{productId}", method = RequestMethod.POST, params = "addToCart")
	public String addToCart(ModelMap model, @PathVariable("productId") int productId, HttpServletRequest request) {
		int id = 0;
		if (SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL") != null) {
			id = (int) ((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL")).getId();
		}
		int quantityOrdered = 0;
		if (id > 0) {
			ProductItem product = productService.getProductById(productId);
			model.addAttribute("product", product);
			Integer quantity = Integer.valueOf(request.getParameter("quantityInput"));
			int cartId = shoppingCartService.isHaveCart(id);
			int bonusQuantity = shoppingCartService.getQuantityOfProductAdded(productId, id);
			ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
			shoppingCartItem.setProductItem(product);
			productService.addToCart(shoppingCartItem, cartId, id, bonusQuantity, quantity);
			quantityOrdered = shoppingCartService.getTotalQuantityOrdered(id);
			model.addAttribute("quantityOrdered", quantityOrdered);
		}
		else {
			return "redirect:/e-commerce/login.htm";
		}
		List<CustomerReview> comments = productService.getAllCommentsById(productId);
		if (comments != null) {
			model.addAttribute("comments", comments);
		}
		
		return "e-commerce/product";
	}

	@RequestMapping(value = "product/{productId}", method = RequestMethod.POST, params = "addComment")
	public String addComment(ModelMap model, @PathVariable("productId") int productId,
			@ModelAttribute("CustomerReview") CustomerReview customerReview, HttpServletRequest request) {
		int id = 0;
		if (SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL") != null) {
			id = (int) ((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL")).getId();
		}
		OrderLine orderLine = productService.isBoughtThisProduct(id, productId);
		if (id > 0) {
			Customer customer = customerService.getCustomerById(id);
			customerReview.setCustomer(customer);
			String comment = request.getParameter("commentInput").trim();
			customerReview.setComment(comment);
			customerReview.setOrderLine(orderLine);
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
		}
		else {
			return "redirect:/e-commerce/login.htm";
		}
		return product(request, model, productId);
	}

	@RequestMapping(value = "list/delete/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productService.deleteProductItem(productId);
		return "redirect:/e-commerce/list.htm";
	}

}
