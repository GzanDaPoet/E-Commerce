package ptithcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.category.ICategoryDao;
import ptithcm.model.product.ProductCategory;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private ICategoryDao categoryDao;

	public void insertCategory(ProductCategory category) {

		categoryDao.insert(category);
	}

	public List<ProductCategory> getAllCategory() {
		return categoryDao.getAllCategory();
	}

	public List<ProductCategory> getListPaginatedCategories(int firstResult, int maxResults) {
		return categoryDao.listPaginatedProductCategory(firstResult, maxResults);
	}

	public void deleteCategoryById(int categoryId) {
		categoryDao.deleteById(categoryId);
	}

	public ProductCategory getProductCategoryById(int categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}

	public void updateCategory(ProductCategory productCategory) {
		categoryDao.updateById(productCategory);
	}

}
