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

import ptithcm.model.inventory.InventoryReceivingDetails;
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
	private Integer price;
	@Column(name = "warranty_time")
	private int date;
	@Column(name = "status")
	private String status;
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
	@OneToMany(mappedBy = "productItem", fetch = FetchType.LAZY)
	private Collection<InventoryReceivingDetails> inventoryReceivingDetails;
	

	
	public ProductItem() {
		super();
	}

	
	public ProductItem(int id, Product product, String sKU, int quantityInStock, String productImage, Integer price,
			int date, String status, Collection<OrderLine> orderLines, Collection<ShoppingCartItem> cartItems,
			Collection<ProductConfigruation> productConfigruations, Collection<WarrantyDetail> warrantyDetails,
			Collection<UpdatePriceProductItem> updatePriceProductItems, Collection<InventoryReceivingDetails> inventoryReceivingDetails) {
		super();
		this.id = id;
		this.product = product;
		SKU = sKU;
		this.quantityInStock = quantityInStock;
		this.productImage = productImage;
		this.price = price;
		this.date = date;
		this.status = status;
		this.orderLines = orderLines;
		this.cartItems = cartItems;
		this.productConfigruations = productConfigruations;
		this.warrantyDetails = warrantyDetails;
		this.updatePriceProductItems = updatePriceProductItems;
		this.inventoryReceivingDetails = inventoryReceivingDetails;
	}


	public Collection<InventoryReceivingDetails> getInventoryReceivingDetails() {
		return inventoryReceivingDetails;
	}


	public void setInventoryReceivingDetails(Collection<InventoryReceivingDetails> inventoryReceivingDetails) {
		this.inventoryReceivingDetails = inventoryReceivingDetails;
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


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Collection<OrderLine> getOrderLines() {
		return orderLines;
	}


	public void setOrderLines(Collection<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}


	public Collection<ShoppingCartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(Collection<ShoppingCartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public Collection<ProductConfigruation> getProductConfigruations() {
		return productConfigruations;
	}


	public void setProductConfigruations(Collection<ProductConfigruation> productConfigruations) {
		this.productConfigruations = productConfigruations;
	}


	public Collection<WarrantyDetail> getWarrantyDetails() {
		return warrantyDetails;
	}


	public void setWarrantyDetails(Collection<WarrantyDetail> warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}


	public Collection<UpdatePriceProductItem> getUpdatePriceProductItems() {
		return updatePriceProductItems;
	}


	public void setUpdatePriceProductItems(Collection<UpdatePriceProductItem> updatePriceProductItems) {
		this.updatePriceProductItems = updatePriceProductItems;
	}


	

}
