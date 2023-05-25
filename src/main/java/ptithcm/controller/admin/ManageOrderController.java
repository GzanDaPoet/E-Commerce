package ptithcm.controller.admin;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.dto.CustomerOrderDTO;
import ptithcm.dto.OrderDeliveryDTO;
import ptithcm.model.customer.Customer;
import ptithcm.model.order.OrderDelivery;
import ptithcm.model.order.OrderLine;
import ptithcm.model.order.OrderStatus;
import ptithcm.model.shop.ShopOrder;
import ptithcm.model.user.User;
import ptithcm.service.ManageOrderService;
import ptithcm.service.OrderDeliveryService;
import ptithcm.util.SessionUtil;

@Transactional
@Controller
@RequestMapping(value = "/admin/manage-ordered/")
public class ManageOrderController {
	@Autowired
	SessionFactory sessionFactory;
	

	
	@Autowired
	ManageOrderService manageOrderService;
	
	@Autowired
	OrderDeliveryService orderDeliveryService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String showOrderedList(ModelMap model) {
		List<CustomerOrderDTO> customerOrderList = manageOrderService.getOderCustomerDTOList();
		System.out.println("Size of list orderd: " + customerOrderList.size());
		model.addAttribute("listOrdered", customerOrderList);
		System.out.println("Danh sach don hang sap chuyen di: " + orderDeliveryService.orderDeliveryDTOList().size());
		return "admin/manage-ordered/list";
	}
	
	@RequestMapping(value="list/confirmed/{orderId}")
	public String confirmOrder(@PathVariable int orderId, HttpServletRequest request) {
		ShopOrder shopOrder = manageOrderService.getShopOrderById(orderId);
		User user= ((User) SessionUtil.getInstance().getValue(request, "USER_MODEL"));
		java.util.Date now = new java.util.Date(); 
		java.sql.Date deliveryDate = new java.sql.Date(now.getTime()); 
		Calendar calendar = java.util.Calendar.getInstance();
		calendar.add(java.util.Calendar.DAY_OF_YEAR, 2);
		java.util.Date receiveDate = calendar.getTime();
		java.sql.Date sqlReceiveDate = new java.sql.Date(receiveDate.getTime());
		OrderDelivery orderDelivery = new OrderDelivery();
		orderDelivery.setShopOrder(shopOrder);
		orderDelivery.setUser(user);
		orderDelivery.setCreatedAt(new java.sql.Date(now.getTime()));
		orderDelivery.setDeliveryDate(deliveryDate);
		orderDelivery.setReceivedDate(sqlReceiveDate);
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(2);
		shopOrder.setOrderStatus(orderStatus);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (shopOrder != null) {
			try {
				session.save(orderDelivery);
				session.merge(shopOrder);
				t.commit();
			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
				t.rollback();
			} finally {
				session.close();
			}
		}
		
		return "redirect:/admin/manage-ordered/list.htm";
	}
	
	@RequestMapping(value="list/cancel/{orderId}")
	public String cancelOrder(@PathVariable int orderId) {
		System.out.println("Come here");
		ShopOrder shopOrder = manageOrderService.getShopOrderById(orderId);
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(4);
		shopOrder.setOrderStatus(orderStatus);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (shopOrder != null) {
			try {
				session.merge(shopOrder);
				t.commit();
				System.out.println("Cap nhat don hang thanh cong");
			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
				t.rollback();
			} finally {
				session.close();
			}
		}
		return "redirect:/admin/manage-ordered/list.htm";
	}
}
