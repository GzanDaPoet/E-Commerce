package ptithcm.dao.category;

import java.lang.constant.Constable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.model.product.ProductCategory;
import ptithcm.model.product.ProductItem;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void deleteById(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductCategory> getAllCategory() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ProductCategory";
		Query query = session.createQuery(hql);
		List<ProductCategory> list = query.list();
		return list;
	}

	@Override
	public ProductCategory getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ProductCategory category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.save(category);

			session.getTransaction().commit();

			System.out.print("insert category success!");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public void updateById(int categoryId) {
		// TODO Auto-generated method stub

	}
}
