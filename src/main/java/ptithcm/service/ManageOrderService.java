package ptithcm.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.ManageOrder.ManageOrderDao;
import ptithcm.dto.CustomerOrderDTO;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shop.ShopOrder;

@Service
public class ManageOrderService {
	@Autowired
	ManageOrderDao manageOrderDao;
	
	@Autowired 
	ProductService productService;
	
	public List<OrderLine> orderLineList() {
		return manageOrderDao.getListOrderLineByStatus();
	}
	
	public ProductItem getProductItemById(int productId) {
		return productService.getProductById(productId);
	}
	
	public ShopOrder getShopOrderById(int orderId) {
		return manageOrderDao.getShopOrderById(orderId);
	}
	
	public List<CustomerOrderDTO> getOderCustomerDTOList() {
		List<OrderLine> orderLineList = orderLineList();
		List<CustomerOrderDTO> customerOrderDTOList = new ArrayList<CustomerOrderDTO>();
	
		if (orderLineList.size() > 0) {
			for (OrderLine orderLine: orderLineList) {
				CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
				customerOrderDTO.setId(orderLine.getId().toString());
				ShopOrder shopOrder = getShopOrderById(orderLine.getShopOrder().getId());
				customerOrderDTO.setPrice(shopOrder.getOrderTotal());
				ProductItem productItem = new ProductItem();
				Date orderDate = shopOrder.getOrderDate();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				productItem = getProductItemById(orderLine.getProductItem().getId());
				customerOrderDTO.setOrderId(shopOrder.getId());
				customerOrderDTO.setQuantity(orderLine.getQuantity());
				String dateString = dateFormat.format(orderDate);
				customerOrderDTO.setDateOrdered(dateString);
				customerOrderDTO.setProductItemName(productItem.getProduct().getName());
				customerOrderDTOList.add(customerOrderDTO);
			}
		}
		return customerOrderDTOList;
	}
	
}