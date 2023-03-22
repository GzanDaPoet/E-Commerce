package ptithcm.model.pay;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Payment_Type")
public class PaymentType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "status")
	private String status;
	
	
	@OneToMany(mappedBy = "paymentType", fetch = FetchType.EAGER)
	private Collection<CustomerPaymentMethod> customerPaymentMethods;
	
	public PaymentType() {
		super();
	}

	public PaymentType(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
