package ptithcm.model.cart;
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
import ptithcm.model.customer.Customer;
import ptithcm.model.product.ProductItem;

@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private Collection<ShoppingCartItem> shoppingCartItems;

	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public ShoppingCart() {
		super();
	}


	public ShoppingCart(Integer id, Collection<ShoppingCartItem> shoppingCartItems, Customer customer) {
		super();
		this.id = id;
		this.shoppingCartItems = shoppingCartItems;
		this.customer = customer;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Collection<ShoppingCartItem> getCartItems() {
		return shoppingCartItems;
	}


	public void setCartItems(Collection<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	

}
