package ptithcm.model.promotion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PromotionCategoryId implements Serializable {

	
    @Column(name = "promotion_id")
    private Long promotionId;

    @Column(name = "variation_option_id")
    private Long categoryId;

    public PromotionCategoryId() {
    }

    public PromotionCategoryId(Long promotionId, Long categoryId) {
        this.promotionId = promotionId;
        this.categoryId = categoryId;
    }

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

    
    
   
}
