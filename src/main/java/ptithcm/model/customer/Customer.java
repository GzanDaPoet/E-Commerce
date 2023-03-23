package ptithcm.model.customer;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ptithcm.model.cart.ShoppingCart;
import ptithcm.model.pay.CustomerPaymentMethod;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "username")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<CustomerAddress> customerAddresses;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<ShoppingCart> shoppingCarts;
	
	@OneToOne(mappedBy = "customer")
	private CustomerProfile customerProfile;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<CustomerReview> customerReivews;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<CustomerPaymentMethod> customerPaymentMethods;
	
	
	public Customer() {
		super();
	}

	public Customer(Integer id, String userName, String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
