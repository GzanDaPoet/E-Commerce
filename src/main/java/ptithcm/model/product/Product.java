package ptithcm.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategory productCategory;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "product_image")
	private String productImage;
	
	public Product() {
		super();
	}

	

	public Product(Integer id, ProductCategory productCategory, String name, String description, String productImage) {
		super();
		this.id = id;
		this.productCategory = productCategory;
		this.name = name;
		this.description = description;
		this.productImage = productImage;
	}



	public ProductCategory getCategory() {
		return productCategory;
	}



	public void setCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

}
