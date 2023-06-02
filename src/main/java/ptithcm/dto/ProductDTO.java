package ptithcm.dto;

import java.util.List;

import ptithcm.model.product.Product;
import ptithcm.model.product.ProductItem;

public class ProductDTO {
	private Integer id;
	private Integer productCategoryId;
	private String name;
	private String description;
	private String productImage;
	private String productCategoryName;
	private int defaultProductItem = 0;
	private int defaultPrice = 0;

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.productImage = product.getProductImage();
		this.productCategoryId = product.getProductCategory().getId();
		this.productCategoryName = product.getProductCategory().getCategoryName();
		List<ProductItem> listProductItems = (List<ProductItem>) product.getProductItems();
		if (listProductItems.size() >= 1) {
			defaultProductItem = listProductItems.get(0).getId();
			defaultPrice = listProductItems.get(0).getPrice();
		}
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

	public int getDefaultProductItem() {
		return defaultProductItem;
	}

	public void setDefaultProductItem(int defaultProductItem) {
		this.defaultProductItem = defaultProductItem;
	}

	public int getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(int defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

}
