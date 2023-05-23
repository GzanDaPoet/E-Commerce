package ptithcm.dao.ManageOrder;

import java.sql.Date;
import java.util.List;

import ptithcm.model.order.OrderLine;
import ptithcm.model.shop.ShopOrder;

public interface ManageOrderDao {
	List<OrderLine> getListOrderLineByStatus();
	ShopOrder getShopOrderById(int orderId);
} 