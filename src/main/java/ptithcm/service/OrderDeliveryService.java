package ptithcm.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.ManageOrder.ManageOrderDao;
import ptithcm.dto.OrderDeliveryDTO;
import ptithcm.model.order.OrderDelivery;
import ptithcm.model.order.OrderLine;
import ptithcm.model.shop.ShopOrder;

@Service
public class OrderDeliveryService {
	@Autowired
	ManageOrderDao manageOrderDao;
	
	public List<OrderDeliveryDTO> orderDeliveryDTOList() {
		List<OrderDelivery> listOrderForShipping = manageOrderDao.getListOfOrderShipping();
		List<OrderDeliveryDTO> orderDeliveryList = new ArrayList<>();
		if (listOrderForShipping.size() > 0) {
			for (OrderDelivery orderDelivery: listOrderForShipping) {
				List<OrderLine> orderItemList = (List<OrderLine>) orderDelivery.getShopOrder().getOrderLines();
				OrderDeliveryDTO orderDeliveryDTO = new OrderDeliveryDTO();
				orderDeliveryDTO.setUserId(orderDelivery.getUser().getId());
				orderDeliveryDTO.setDeliveryDate(orderDelivery.getDeliveryDate());
				orderDeliveryDTO.setDeliveryReceived(orderDelivery.getReceivedDate());
				orderDeliveryDTO.setListOrderDelivery(orderItemList);
				orderDeliveryDTO.setStatus("Đang giao");
				orderDeliveryDTO.setOrderId(orderDelivery.getShopOrder().getId());
				orderDeliveryList.add(orderDeliveryDTO);
			}
			System.out.println("Danh sach don giao hang: " + orderDeliveryList.size());
			return orderDeliveryList;
		}
		return null;
	}
	
	
}
