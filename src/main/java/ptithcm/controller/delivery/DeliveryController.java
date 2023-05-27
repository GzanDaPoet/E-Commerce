package ptithcm.controller.delivery;

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
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.dto.OrderDeliveryDTO;
import ptithcm.model.order.DeliveryStatus;
import ptithcm.model.order.OrderDelivery;
import ptithcm.model.order.OrderLine;
import ptithcm.model.order.OrderStatus;
import ptithcm.model.shop.ShopOrder;
import ptithcm.model.user.User;
import ptithcm.service.ManageOrderService;
import ptithcm.service.OrderDeliveryService;
import ptithcm.service.UserService;

@Transactional
@Controller
@RequestMapping(value = "/delivery/")

public class DeliveryController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired 
	OrderDeliveryService orderDeliveryService;
	
	@Autowired
	ManageOrderService manageOrderService;
	
	
	
	@RequestMapping(value="listDeliveryOrder")
	public String getListDeliveryOrder(ModelMap modelMap) {
		List<OrderDeliveryDTO> orderDeliveryDTOList = orderDeliveryService.orderDeliveryDTOList();
		if (orderDeliveryDTOList == null) {
			System.out.println("Null roi");
		}
		else {
			System.out.println("khong null");
			modelMap.addAttribute("orderDeliveryDTOList", orderDeliveryDTOList);
		}
		return "delivery/listDeliveryOrder";
	}
	
	@RequestMapping(value="detail/{id}", method = RequestMethod.GET)
	public String detail(ModelMap modelMap, @PathVariable Integer id) {
		OrderDeliveryDTO orderDeliveryDTO = orderDeliveryService.getOrderDeliveryDTOById(id);
		modelMap.addAttribute("listItemOrder", orderDeliveryDTO.getListOrderDelivery());
			
		return "delivery/detail";
	}
	
	@RequestMapping(value = "confirmed/{id}", method = RequestMethod.POST)
	public String confirmedSucccess(@RequestParam("status") String status, @PathVariable Integer id) {
		System.out.println("Come here");
		OrderDelivery orderDelivery = orderDeliveryService.getOrderDeliveryById(id);
		Integer orderId = orderDelivery.getShopOrder().getId();
		System.out.println("order id: " + orderId);
		ShopOrder shopOrder = manageOrderService.getShopOrderById(orderId);
		OrderStatus orderStatus = new OrderStatus();
		DeliveryStatus deliveryStatus = new DeliveryStatus();
		if (status.equals("success")) {
			System.out.println("success");
			orderStatus.setId(3);
			deliveryStatus.setId(2);
		}
		else {
			System.out.println("Don hang giao khong thanh cong");
			deliveryStatus.setId(3);
			orderStatus.setId(1);
		}
		shopOrder.setOrderStatus(orderStatus);
		orderDelivery.setDeliveryStatus(deliveryStatus);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (shopOrder != null) {
			try {
				session.saveOrUpdate(orderDelivery);
				session.merge(shopOrder);
				t.commit();
				System.out.println("Thanh cong");
			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
				t.rollback();
			} finally {
				session.close();
			}
		}
		return "redirect:/delivery/listDeliveryOrder.htm";
	}
	
	
}