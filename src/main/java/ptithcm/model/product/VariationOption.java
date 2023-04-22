package ptithcm.model.product;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Variation_Option")
public class VariationOption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "variation_id")
	private Variation variation;
	@Column(name = "value")
	private String value;
	
	@OneToMany(mappedBy = "variationOption", fetch = FetchType.LAZY)
	private Collection<ProductConfigruation> productConfigruations;

	
	
	public VariationOption() {
		super();
	}

	public VariationOption(Integer id, Variation variation, String value,
			Collection<ProductConfigruation> productConfigruations) {
		super();
		this.id = id;
		this.variation = variation;
		this.value = value;
		this.productConfigruations = productConfigruations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Variation getVariation() {
		return variation;
	}

	public void setVariation(Variation variation) {
		this.variation = variation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Collection<ProductConfigruation> getProductConfigruations() {
		return productConfigruations;
	}

	public void setProductConfigruations(Collection<ProductConfigruation> productConfigruations) {
		this.productConfigruations = productConfigruations;
	}
	
	
	
	
}
