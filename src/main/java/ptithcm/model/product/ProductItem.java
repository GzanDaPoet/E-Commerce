package ptithcm.model.product;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ptithcm.model.cart.ShoppingCartItem;
import ptithcm.model.order.OrderLine;
import ptithcm.model.updation.UpdatePriceProductItem;
import ptithcm.model.warranty.WarrantyDetail;

@Entity(name = "Product_Item")

public class ProductItem {
	@Id
	@GeneratedValue
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
	private LocalDate date;
	@Column(name = "status")
	private String status;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.EAGER)
	private Collection<OrderLine> orderLines;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.EAGER)
	private Collection<ShoppingCartItem> cartItems;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.EAGER)
	private Collection<ProductConfigruation> productConfigruations;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.EAGER)
	private Collection<WarrantyDetail> warrantyDetails;
	@OneToMany(mappedBy = "productItem", fetch = FetchType.EAGER)
	private Collection<UpdatePriceProductItem> updatePriceProductItems;
	
	

	
	public ProductItem() {
		super();
	}

	public ProductItem(int id, Product product, String sKU, int quantityInStock, String productImage, int price,
			LocalDate date, String status) {
		super();
		this.id = id;
		this.product = product;
		SKU = sKU;
		this.quantityInStock = quantityInStock;
		this.productImage = productImage;
		this.price = price;
		this.date = date;
		this.status = status;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
