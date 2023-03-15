package ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.ProductDao;
import ptithcm.model.Product;

@Service("productService")
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
	
}
