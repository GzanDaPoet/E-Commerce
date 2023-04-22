package ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.product.ProductDao;
import ptithcm.model.product.ProductItem;

@Service
public class ProductService {
	@Autowired 
	private ProductDao productDao;
	
	public List<ProductItem> getListProducts() {
		List<ProductItem> listProducts = productDao.getAllProducts();
		if (!listProducts.isEmpty()) {
			return listProducts;
		}
		return null;
	}
	
	
	public ProductItem getProductById(int id) {
		ProductItem product = productDao.getProductById(id);
		if (product != null) {
			return product;
		}
		return null;
	}
	
	
	public int updateQty(int produtItemId, int qty) {
		int update =productDao.updateQty(produtItemId,qty);
		return update;
	}
		
//	public List<CustomerReview> getAllCommentsById(int id) {
//		List<CustomerReview> comments = productDao.getAllCommentsById(id);
//		if (!comments.isEmpty()) {
//			return comments;
//		}
//		return null;
//	}
//	
//	public int getOrderId(int id) {
//		int value = productDao.getOrderID(id);
//		System.out.println("Value: " + value);
//		return value;
//	}
	
//	public Boolean checkIsCart(int customerId) {
//		if (productDao.checkIsCart(customerId)) {
//			return true;
//		}
//		return false;
//	}
	
}
