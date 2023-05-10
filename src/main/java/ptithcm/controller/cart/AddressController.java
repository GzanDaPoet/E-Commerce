package ptithcm.controller.cart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.DenormalizedTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.order.OrderLine;
import ptithcm.model.pay.CustomerPaymentMethod;
import ptithcm.model.ship.ShippingMethod;
import ptithcm.model.shop.ShopOrder;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.service.AddressService;
import ptithcm.service.CartService;
import ptithcm.service.PaymentService;
import ptithcm.service.ProductService;

@RequestMapping("/e-commerce/")
@Controller
@Transactional
public class AddressController {

	@Autowired
	AddressService addressService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "address")
	public String showAddress(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressListByID(1);
		model.addAttribute("customerAddress", addressList);
		return "e-commerce/address";
	}
	
	@RequestMapping(value = "address1")
	public String showAddress1(ModelMap model) {
		List<CustomerAddress> addressList = addressService.getAddressListByID(1);
		model.addAttribute("customerAddress", addressList);
		return "e-commerce/address1";
	}

	@RequestMapping(value = "address/delete", method = RequestMethod.POST)
	public String deleteAddress(@RequestParam("addressId") int addressId) {
		addressService.deleteCustomerAddress(addressId);
		addressService.deleteAddress(addressId);
		return "redirect:/e-commerce/address.htm";
	}

	@RequestMapping(value = "address/deliver", method = RequestMethod.POST)
	public String deliver(@RequestParam("addressId") int addressId, ModelMap model, HttpSession session) {
		System.out.println(addressId);
		session.setAttribute("addressId", addressId);
		List<CustomerPaymentMethod> payment = paymentService.getPaymentListById(1);
		model.addAttribute("payment", payment);
		List<ShippingMethod> shipping = paymentService.getListShippingMethods();
		model.addAttribute("shipping", shipping);
		return "e-commerce/payment";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkout(@RequestParam int PaymentMethod, @RequestParam int ShippingMethod, ModelMap model,
			HttpSession session) {
		System.out.println(PaymentMethod);
		System.out.println(ShippingMethod);
		int addressId = (int) session.getAttribute("addressId");
		int sum = (int) session.getAttribute("sum") + paymentService.getShippingById(ShippingMethod).getPrice();
		List<Integer> price = (List<Integer>) session.getAttribute("price"); 
		System.out.println(addressId);
		Date sqlDate = new Date(System.currentTimeMillis());
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setShippingMethod(paymentService.getShippingById(ShippingMethod));
		shopOrder.setCustomerAddress(addressService.getAddressById(addressId));
		shopOrder.setOrderStatus(addressService.getOrderStatusById(2));
		shopOrder.setCustomerPaymentMethod(paymentService.getPaymentById(PaymentMethod));
		shopOrder.setOrderDate(sqlDate);
		shopOrder.setOrderTotal(sum);
		Session session1 = sessionFactory.openSession();
		org.hibernate.Transaction t =  session1.beginTransaction();
		
		try {
			session1.save(shopOrder);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công! ");
			System.out.println("done");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại! ");
			System.out.println(e);
		} finally {
			session1.close();
		}
        List<ShoppingCartItem> listCartItems = cartService.getAllCartItemsById(1);
        for (int i=0;i<listCartItems.size();i++) {
        	System.out.println(listCartItems.size());
        	OrderLine orderLine = new OrderLine();
        	orderLine.setProductItem(listCartItems.get(i).getProductItem());
        	orderLine.setShopOrder(shopOrder);	
        	orderLine.setQuantity(listCartItems.get(i).getQuantity());
        	orderLine.setPrice(price.get(i));
        	Session session2 = sessionFactory.openSession();
    		org.hibernate.Transaction t1 =  session2.beginTransaction();
    		try {
    			session2.save(orderLine);
    			t1.commit();
    			System.out.println("done");
    		} catch (Exception e) {
    			t1.rollback();
    			System.out.println(e);
    		}
    		finally {
    			session2.close();
    		}
    		productService.updateQty(listCartItems.get(i).getId(), listCartItems.get(i).getQuantity()*(-1));
    		cartService.deleteCartItem(listCartItems.get(i).getId());
		}
        return "e-commerce/checkout";
	}
	
	@RequestMapping(value = "order-success")
	  public String showOrderSuccessPage() {
	    return "e-commerce/orderSuccess";
	  }
}

