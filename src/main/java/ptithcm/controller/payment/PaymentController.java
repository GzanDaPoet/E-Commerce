package ptithcm.controller.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.dao.payment.PaymentDao;
import ptithcm.model.pay.*;
import ptithcm.model.ship.ShippingMethod;
import ptithcm.service.PaymentService;


@RequestMapping("/e-commerce/")
@Controller
public class PaymentController{
	
	@Autowired
	PaymentService paymentService;
	@RequestMapping(value = "payment")
	public String showPayment(ModelMap model) {
		List<CustomerPaymentMethod> payment = paymentService.getPaymentListById(3);
		model.addAttribute("payment",payment);
		List<ShippingMethod> shipping = paymentService.getListShippingMethods();
		model.addAttribute("shipping", shipping);
		return "e-commerce/payment";
	}

	
}