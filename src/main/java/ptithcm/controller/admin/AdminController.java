package ptithcm.controller.admin;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.product.Product;
import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.ProductItem;
import ptithcm.model.promotion.Promotion;
import ptithcm.model.promotion.PromotionCategory;
import ptithcm.service.ProductCategoryService;
import ptithcm.service.ProductService;
import ptithcm.service.admin.LoginService;
import ptithcm.model.user.User;
import ptithcm.model.user.UserPermission;

@Transactional
@Controller
public class AdminController {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	LoginService service;

	@Autowired
	ProductCategoryService productCategoryService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String showAdminLogin() {
		return "admin/login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String handleAdminLoginRequest(@RequestParam String username, @RequestParam String password,
			ModelMap model) {
		if (service.validateUser(username, password)) {
			model.put("password", password);
			model.put("username", username);
			return "shop/index";
		} else {
			return "admin/login";
		}

	}

	@RequestMapping(value = "/admin/promotion", method = RequestMethod.GET)
	public String showPromotion(ModelMap model, HttpServletRequest request) {
		List<ProductCategory> listCategories = productCategoryService.getAllProductCategory();
		model.addAttribute("categories", listCategories);

		return "admin/promotion";
	}

	@RequestMapping(value = "/admin/promotion", method = RequestMethod.POST)
	public String createPromotion(ModelMap model, @RequestParam("promotion-name") String promotionName,
			@RequestParam("promotion-description") String promotionDescription, @RequestParam("brand") Integer cateId,
			@RequestParam("discount-percentage") int discountPercentage,
			@RequestParam("start-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("end-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		LocalDate currentDate = LocalDate.now();
		UserPermission userPermission = new UserPermission();
		userPermission.setId(7);
		userPermission.setValue("7");
		User user = new User(6, userPermission, "ngocthong", "ngocthong2k2@gmail.com", "123456", true);
		Promotion promotion = new Promotion(promotionName, promotionDescription, discountPercentage,
				Date.valueOf(startDate), Date.valueOf(endDate), Date.valueOf(currentDate), user);

		ProductCategory productCategory = productCategoryService.getProductCategory(cateId);
		PromotionCategory promotionCategory = new PromotionCategory();

		List<Product> listProducts = productService.getAllProductByCateId(cateId);
		List<ProductItem> listProductAdd = new ArrayList<>();
		for (Product product : listProducts) {
			List<ProductItem> listProductItems = (List<ProductItem>) product.getProductItems();
			listProductAdd.addAll(listProductItems);
		}
		
		promotionCategory.setProductCategory(productCategory);
		promotionCategory.setPromotion(promotion);
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
		    tx = session.beginTransaction();
		    session.save(promotion);
		    session.merge(promotionCategory);
		    for (ProductItem productItem : listProductAdd) {
		    	 productItem.setStatus("ON SALE");
		    	 session.merge(productItem);
			}
		    tx.commit();
		    model.addAttribute("message", "Success");
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		        model.addAttribute("message", "Fail");
		        System.out.println(e);
		    }   
		} finally {
		    if(session != null){
		        session.close();
		    }
		}
		return "admin/promotion";
	}

}
