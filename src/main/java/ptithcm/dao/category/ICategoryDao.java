package ptithcm.dao.category;

import java.util.List;

import ptithcm.model.product.ProductCategory;

public interface ICategoryDao {
	public void insert(ProductCategory category);

	public void deleteById(int categoryId);

	public void updateById(int categoryId);

	public ProductCategory getCategoryById(int categoryId);

	public List<ProductCategory> getAllCategory();

}
