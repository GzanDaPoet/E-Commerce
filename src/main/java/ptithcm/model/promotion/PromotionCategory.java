package ptithcm.model.promotion;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ptithcm.model.product.ProductCategory;

@Entity
@Table(name = "Promotion_Category")

public class PromotionCategory {

	@EmbeddedId
	private PromotionCategoryId id;

	@ManyToOne()
	@JoinColumn(name = "promotion_id", insertable = false, updatable = false)
	private Promotion promotion;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private ProductCategory productCategory;

	public PromotionCategory() {
		super();
	}

	public PromotionCategory(PromotionCategoryId id, Promotion promotion, ProductCategory productCategory) {
		super();
		this.id = id;
		this.promotion = promotion;
		this.productCategory = productCategory;
	}

	public PromotionCategoryId getId() {
		return id;
	}

	public void setId(PromotionCategoryId id) {
		this.id = id;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

}
