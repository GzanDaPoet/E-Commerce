package ptithcm.dao.promotion;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PromotionImp implements PromotionDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Integer getPriceDiscount(int productId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT PM.discountRate FROM ProductItem PI JOIN PI.product P JOIN P.productCategory PC JOIN PC.promotionCategories PMC JOIN PMC.promotion PM WHERE PI.id = :productId";
		Query query = session.createQuery(hql);
		query.setParameter("productId", productId);
		return (Integer)  query.uniqueResult();
	};
}
