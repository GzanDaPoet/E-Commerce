package ptithcm.service;

import java.util.List;

import org.apache.logging.log4j.core.appender.rolling.action.IfFileName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.product.ProductDao;
import ptithcm.model.customer.CustomerReview;
import ptithcm.model.order.OrderLine;
import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shoppingCart.ShoppingCartItem;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getListProducts() {
		return productDao.getAllProducts();
	}

	public ProductItem getProductItemById(int productItemId) {
		return productDao.getProductItemById(productItemId);
	}

	public Product getProductById(int id) {
		Product product = productDao.getProductById(id);
		if (product != null) {
			return product;
		}
		return null;
	}

	public int updateQty(int produtItemId, int qty) {
		int update = productDao.updateQty(produtItemId, qty);
		return update;
	}

	public List<CustomerReview> getAllCommentsById(int id) {
		List<CustomerReview> comments = productDao.getAllCommentsById(id);
		if (!comments.isEmpty()) {
			return comments;
		}
		return null;
	}

	public int getOrderId(int id) {
		int value = productDao.getOrderID(id);
		return value;
	}

	public Double getRatingAverageProduct(int id) {
		Double value = productDao.getRatingAverageProduct(id);
		if (value != null) {
			System.out.println("Value: " + value);
			return value;
		}
		return null;
	}

	public void deleteProductItem(int id) {
		productDao.deleteProductItem(id);
	}

	public List<ProductItem> searchProductItem(String name) {
		List<ProductItem> list = productDao.searchProductItem(name);
		if (list != null) {
			return list;
		}
		return null;
	}

	public List<Product> getAllProductByCateId(int categoryId) {
		List<Product> list = productDao.getAllProductByCateId(categoryId);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public boolean isExistInCart(int productId) {
		if (getListProducts() == null) {
			return false;
		}
//		for (ProductItem productItem: getListProducts()) {
//			if (productItem.getId() == productId) {
//				return true;
//			}
//		}
		return false;
	}

	public void addToCart(ShoppingCartItem shoppingCartItem, int cartId, int customerId, int bonus, int quantity) {
		productDao.addToCart(shoppingCartItem, cartId, customerId, bonus, quantity);
	}

	public List<ProductItem> getListPaginatedCategories(int firstResult, int maxResults, String search) {
		return productDao.listPaginatedProductCategory(firstResult, maxResults, search);
	}

	public OrderLine isBoughtThisProduct(int customerId, int productItemId) {
		return productDao.isBoughtByCustomer(customerId, productItemId);
	}

	public List<ProductItem> getProductItemByProductId(int productId) {
		return productDao.getProductItemByProductId(productId);
	}

	public boolean isReviewed(int customerId, int productItemId, List<CustomerReview> listCustomerReiview) {
		for (CustomerReview customerReview: listCustomerReiview) {
			if (customerReview.getCustomer().getId() == customerId && customerReview.getOrderLine().getProductItem().getId() == productItemId) {
				return true;
			}
		}
		return false;
	}
	
}
