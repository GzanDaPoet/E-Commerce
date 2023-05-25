package ptithcm.controller.admin;

import java.util.List;

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
import ptithcm.model.order.OrderStatus;
import ptithcm.model.shop.ShopOrder;
import ptithcm.service.ManageOrderService;

@Transactional
@Controller
@RequestMapping(value = "/admin/manage-ordered/")
public class ManageOrderController {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ManageOrderService manageOrderService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String showOrderedList(ModelMap model) {
		List<CustomerOrderDTO> customerOrderList = manageOrderService.getOderCustomerDTOList();
		System.out.println("Size of list orderd: " + customerOrderList.size());
		model.addAttribute("listOrdered", customerOrderList);
		return "admin/manage-ordered/list";
	}
	
	@RequestMapping(value="list/confirmed/{orderId}")
	public String confirmOrder(@PathVariable int orderId) {
		ShopOrder shopOrder = manageOrderService.getShopOrderById(orderId);
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(2);
		shopOrder.setOrderStatus(orderStatus);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (shopOrder != null) {
			try {
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
