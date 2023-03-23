package ptithcm.service;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.ProductDao;
import ptithcm.model.product.Product;

@Service
public class ProductService {
	@Autowired 
	private ProductDao productDao;
	
	public List<Product> getListProducts() {
		List<Product> listProducts = productDao.getAllProducts();
		if (!listProducts.isEmpty()) {
			return listProducts;
		}
		return null;
	}
	
	
	public Product getProductById(int id) {
		Product product = productDao.getProductById(id);
		if (product != null) {
			return product;
		}
		return null;
	}
	
	public List<String> getAllCommentsById(int id) {
		List<String> comments = productDao.getAllCommentsById(id);
		if (!comments.isEmpty()) {
			return comments;
		}
		return null;
	}
	
	public int getOrderId(int id) {
		int value = productDao.getOrderID(id);
		System.out.println("Value: " + value);
		return value;
	}
	
}
