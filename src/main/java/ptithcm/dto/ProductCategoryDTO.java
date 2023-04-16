package ptithcm.dto;

import ptithcm.model.product.ProductCategory;

public class ProductCategoryDTO {
	private String categoryName;
	private Integer id;
	private String parentCategoryName;
	private Integer parentId;

	public ProductCategoryDTO(ProductCategory productCategory, String parentName) {
		this.categoryName = productCategory.getCategoryName();
		this.id = productCategory.getId();
		this.parentId = productCategory.getParentCategoryId();
		this.parentCategoryName = parentName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentCategoryName() {
		return parentCategoryName;
	}

	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
