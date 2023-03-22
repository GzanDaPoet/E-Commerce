package ptithcm.model.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ptithcm.model.variation.VariationOption;

@Entity
@Table(name = "Product_Configuration")
public class ProductConfigruation {
	@Id
	@ManyToOne()
	@JoinColumn(name = "product_item_id")
	private ProductItem productItem;
	@ManyToOne()
	@JoinColumn(name = "variation_option_id")
	private VariationOption variationOption;
	public ProductConfigruation(ProductItem productItem, VariationOption variationOption) {
		super();
		this.productItem = productItem;
		this.variationOption = variationOption;
	}
	public ProductItem getProductItem() {
		return productItem;
	}
	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}
	public VariationOption getProductConfigruation() {
		return variationOption;
	}
	public void setProductConfigruation(VariationOption productConfigruation) {
		this.variationOption = productConfigruation;
	}
	
	
	
}
