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

}
