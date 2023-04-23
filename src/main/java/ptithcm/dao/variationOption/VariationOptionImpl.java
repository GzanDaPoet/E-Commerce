package ptithcm.dao.variationOption;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.model.product.VariationOption;

@Repository
public class VariationOptionImpl implements VariationOptionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void deleteById(int variationOptionId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete VariationOption vo where vo.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", variationOptionId);
		query.executeUpdate();
	}

	@Override
	public List<VariationOption> getAllVariationOptionons() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM VariationOption v ORDER BY v.id";
		Query query = session.createQuery(hql);
		List<VariationOption> list = query.list();
		return list;
	}

	@Override
	public VariationOption getVariationOptionById(int variationOptionId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM VariationOption v where v.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", variationOptionId);
		return (VariationOption) query.uniqueResult();
	}

	@Override
	public void insert(VariationOption variationOption) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.save(variationOption);

			session.getTransaction().commit();

			System.out.print("insert variation option success!");
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public List<VariationOption> listPaginatedVariationOptions(int firstResult, int maxResults) {
		firstResult = firstResult <= 0 ? 0 : firstResult;
		maxResults = maxResults <= 5 ? 5 : maxResults;
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM VariationOption v ORDER BY v.id";
		Query query = session.createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		List<VariationOption> list = query.list();
		return list;
	}

	@Override
	public void updateById(VariationOption variationOption) {
		Session session = sessionFactory.getCurrentSession();
		session.update(variationOption);
	}
}
