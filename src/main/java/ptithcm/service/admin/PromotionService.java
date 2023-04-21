package ptithcm.service.admin;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.promotion.PromotionDao;

@Service
public class PromotionService {
	
	@Autowired
	PromotionDao promotionDao;
	
	public Integer getPriceDiscount(int productId) {
		int price = promotionDao.getPriceDiscount(productId);
		if (price >= 0) {
			return price;
		}
		return -1;
	}
}

