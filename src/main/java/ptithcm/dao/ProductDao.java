package ptithcm.dao;

import java.util.List;

import ptithcm.model.product.Product;



public interface ProductDao {
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public List<String> getAllCommentsById(int id);
}
