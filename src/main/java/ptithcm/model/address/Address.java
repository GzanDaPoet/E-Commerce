package ptithcm.model.address;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ptithcm.model.customer.CustomerAddress;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "city")
	private String city;
	@Column(name = "ward")
	private String ward;
	@Column(name = "district")
	private String district;
	@Column(name="detail_address")
	private String detailAddress;
	
	
	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	private Collection<CustomerAddress> customerAddress;
	
	public Address() {
		super();
	}
	
	public Address(int id, String city, String ward, String district, String detailAddress) {
		super();
		this.id = id;
		this.city = city;
		this.ward = ward;
		this.district = district;
		this.detailAddress = detailAddress;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	
	
}
