package ptithcm.model.address;

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

import ptithcm.model.customer.CustomerAddress;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "province")
	private Province province;
	@ManyToOne
	@JoinColumn(name = "ward")
	private Ward ward;
	@ManyToOne
	@JoinColumn(name = "district")
	private District district;
	@Column(name="detail_address")
	private String detailAddress;
	
	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	private Collection<CustomerAddress> customerAddress;
	
	public Address() {
		super();
	}
	
	public Address(int id, Province province, Ward ward, District district, String detailAddress) {
		super();
		this.id = id;
		this.province = province;
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
	
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	
	
}
