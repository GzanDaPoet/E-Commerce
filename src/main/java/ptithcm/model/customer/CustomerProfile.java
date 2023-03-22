package ptithcm.model.customer;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Profile")
public class CustomerProfile {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "create_at")
	private LocalDate createAt;
	@Column(name = "modified_at")
	private LocalDate modifiedAt;

	public CustomerProfile() {
		super();
	}

	public CustomerProfile(Integer id, Customer customer, String name, String address, String phoneNumber,
			LocalDate createAt, LocalDate modifiedAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDate modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
