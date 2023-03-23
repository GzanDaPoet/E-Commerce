package ptithcm.model.product;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class  ProductConfigurationId implements Serializable {

	 private Long productItemId;

	    private Long variationOptionId;

	    public ProductConfigurationId() {}

	    public ProductConfigurationId(Long productItemId, Long variationOptionId) {
	        this.productItemId = productItemId;
	        this.variationOptionId = variationOptionId;
	    }

	    // getters and setters
	    public Long getProductItemId() {
	        return productItemId;
	    }

	    public void setProductItemId(Long productItemId) {
	        this.productItemId = productItemId;
	    }

	    public Long getVariationOptionId() {
	        return variationOptionId;
	    }

	    public void setVariationOptionId(Long variationOptionId) {
	        this.variationOptionId = variationOptionId;
	    }

	    // override equals() and hashCode() methods
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof ProductConfigurationId)) return false;
	        ProductConfigurationId that = (ProductConfigurationId) o;
	        return Objects.equals(getProductItemId(), that.getProductItemId()) &&
	                Objects.equals(getVariationOptionId(), that.getVariationOptionId());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getProductItemId(), getVariationOptionId());
	    }
}
