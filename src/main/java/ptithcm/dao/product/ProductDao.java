package ptithcm.dao.product;

import java.util.List;

import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.ProductItem;

public interface ProductDao {
	public List<ProductItem> getAllProducts();

	public ProductItem getProductById(int id);

	public Integer getOrderID(int id);

	public List<CustomerReview> getAllCommentsById(int id);

	public Double getRatingAverageProduct(int productId);

	public OrderLine getOrderLineById(int id);
}
