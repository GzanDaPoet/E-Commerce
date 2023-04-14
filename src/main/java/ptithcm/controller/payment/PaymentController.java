package ptithcm.controller.payment;

import java.util.List;

import javax.management.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.expr.NewArray;
import ptithcm.dao.payment.PaymentDao;
import ptithcm.model.pay.*;
import ptithcm.model.ship.ShippingMethod;
import ptithcm.model.shop.ShopOrder;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.service.CartService;
import ptithcm.service.PaymentService;


@RequestMapping("/e-commerce/")
@Controller
public class PaymentController{
	@Autowired
	CartService cartService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "payment")
	public String showPayment(ModelMap model,HttpSession ss) {
		int sum= 0;
		List<CustomerPaymentMethod> payment = paymentService.getPaymentListById(3);
		model.addAttribute("payment",payment);
		List<ShippingMethod> shipping = paymentService.getListShippingMethods();
		model.addAttribute("shipping", shipping);
		List<ShoppingCartItem> listCartItems = cartService.getAllCartItemsById(3);
		model.addAttribute("cart", listCartItems);
		for (ShoppingCartItem item : listCartItems ) {
			sum +=item.getProductItem().getPrice() * item.getQuantity(); 
		}
		ss.setAttribute("sum", sum);
		return "e-commerce/payment";
	}

	@RequestMapping(value="checkout", method = RequestMethod.GET)
	public String checkOut(ModelMap model) {
		model.addAttribute("shopOrder",  new ShopOrder());
		return "e-commerce/payment";
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkOut (ModelMap model, @ModelAttribute("shopOrder") ShopOrder shopOrder) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(shopOrder);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công! ");
		} catch ( Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại! ");
		}
		finally {
			session.close();
		}
		List<ShoppingCartItem> listItems =cartService.getAllCartItemsById(3);
		for (ShoppingCartItem item : listItems ) {
			
		}
		return "e-commerce/payment";
	}
	
}