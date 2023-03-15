package ptithcm.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Category")
public class Category {
	@Id @GeneratedValue
	@Column(name="category_id")
	private Integer id;
	@Column(name="parent_category_id")
	private Integer parentCategoryId;
	@Column(name="category_name")
	private String categoryName;
	
//	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//	private Collection<Product> products;

	public Category() {
		super();
	}
	
	public Category(Integer id, Integer parentCategoryId, String categoryName) {
		super();
		this.id = id;
		this.parentCategoryId = parentCategoryId;
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
}
