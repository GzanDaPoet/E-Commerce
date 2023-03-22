package ptithcm.model.promotion;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promotion_category")
public class PromotionCategory {
	@Id
	@ManyToOne()
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
}
