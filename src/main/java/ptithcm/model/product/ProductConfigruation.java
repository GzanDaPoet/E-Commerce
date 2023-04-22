package ptithcm.model.product;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Configuration")
public class ProductConfigruation {
	@EmbeddedId
    private ProductConfigurationId id;
	@ManyToOne()
	@JoinColumn(name = "product_item_id")
	private ProductItem productItem;
	@ManyToOne()
	@JoinColumn(name = "variation_option_id")
	private VariationOption variationOption;

	public ProductConfigruation() {
		super();
	}

	public ProductConfigruation(ProductConfigurationId id, ProductItem productItem, VariationOption variationOption) {
		super();
		this.id = id;
		this.productItem = productItem;
		this.variationOption = variationOption;
	}

	public ProductConfigurationId getId() {
		return id;
	}

	public void setId(ProductConfigurationId id) {
		this.id = id;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public VariationOption getVariationOption() {
		return variationOption;
	}

	public void setVariationOption(VariationOption variationOption) {
		this.variationOption = variationOption;
	}

	

}
