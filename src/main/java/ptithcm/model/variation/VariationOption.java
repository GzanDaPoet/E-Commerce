package ptithcm.model.variation;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ptithcm.model.product.ProductConfigruation;

@Entity
@Table(name = "Variation_Option")
public class VariationOption {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "variation_id")
	private Variation variation;
	@Column(name = "value")
	private String value;
	
	@OneToMany(mappedBy = "variationOption", fetch = FetchType.EAGER)
	private Collection<ProductConfigruation> productConfigruations;
	
	
	
	
}
