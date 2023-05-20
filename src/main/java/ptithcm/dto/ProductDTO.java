package ptithcm.dto;

import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;

public class ProductDTO {
	private Integer id;
	private Integer productCategoryId;
	private String name;
	private String description;
	private String productImage;
	private String productCategoryName;
	private String status;

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.productImage = product.getProductImage();
		this.productCategoryId = product.getProductCategory().getId();
		this.productCategoryName = product.getProductCategory().getCategoryName();
		this.status = determineStatus(product);
	}

	private String determineStatus(Product product) {
		for (ProductItem item : product.getProductItems()) {
			if (item.getProduct().getId().equals(product.getId())) {
				return item.getStatus();
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
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

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
