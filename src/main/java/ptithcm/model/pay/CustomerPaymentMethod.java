package ptithcm.model.pay;

import java.time.LocalDate;
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

import ptithcm.model.customer.Customer;
import ptithcm.model.shop.ShopOrder;
@Entity
@Table(name = "Customer_Payment_Method")
public class CustomerPaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne()
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;
	@Column(name = "expiry")
	private LocalDate expiry;
	
	@OneToMany(mappedBy = "customerPaymentMethod", fetch = FetchType.LAZY)
	private Collection<ShopOrder> shopOrders;
	
	
	public CustomerPaymentMethod() {
		super();
	}


	public CustomerPaymentMethod(Integer id, Customer customer, PaymentType paymentType, LocalDate expiry,
			Collection<ShopOrder> shopOrders) {
		super();
		this.id = id;
		this.customer = customer;
		this.paymentType = paymentType;
		this.expiry = expiry;
		this.shopOrders = shopOrders;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public PaymentType getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}


	public LocalDate getExpiry() {
		return expiry;
	}


	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}


	public Collection<ShopOrder> getShopOrders() {
		return shopOrders;
	}


	public void setShopOrders(Collection<ShopOrder> shopOrders) {
		this.shopOrders = shopOrders;
	}

	

}
