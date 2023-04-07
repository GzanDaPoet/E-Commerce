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

import ptithcm.model.order.OrderLine;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.model.updation.UpdatePriceProductItem;
import ptithcm.model.warranty.WarrantyDetail;

@Entity
@Table(name = "Product_Item")

public class ProductItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "SKU")	
	private String SKU;
	@Column(name = "qty_in_stock")	
	private int quantityInStock;
	@Column(name = "product_image")
	private String productImage;
	@Column(name = "price")
	private int price;
	@Column(name = "warranty_time")
	private int date;
	@Column(name = "status")
	private String statusProduct;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<OrderLine> orderLines;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<ShoppingCartItem> cartItems;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<ProductConfigruation> productConfigruations;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<WarrantyDetail> warrantyDetails;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<UpdatePriceProductItem> updatePriceProductItems;
	
	

	
	public ProductItem() {
		super();
	}

	public ProductItem(int id, Product product, String sKU, int quantityInStock, String productImage, int price,
			int date, String status) {
		super();
		this.id = id;
		this.product = product;
		SKU = sKU;
		this.quantityInStock = quantityInStock;
		this.productImage = productImage;
		this.price = price;
		this.date = date;
		this.statusProduct = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getStatus() {
		return statusProduct;
	}

	public void setStatus(String status) {
		this.statusProduct = status;
	}

}
