package ptithcm.dao.ManageOrder;

import java.sql.Date;
import java.util.List;

import ptithcm.model.order.OrderLine;
import ptithcm.model.shop.ShopOrder;

public interface ManageOrderDao {
	List<ShopOrder> getListShopOrderByStatus();
	Long getQuantityOfOrder(int orderId);
	ShopOrder getShopOrderById(int orderId);
} 