package ptithcm.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ptithcm.model.agency.Agency;
import ptithcm.model.user.User;

@Entity
@Table(name = "Inventory_receiving")
public class InventoryReceiving {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne()
	@JoinColumn(name = "agency_id")
	private Agency agency;
	@ManyToOne()
	@JoinColumn(name = "status_id")
	private StatusReceiving statusReceiving;

	public InventoryReceiving() {
		super();
	}

	public InventoryReceiving(Integer id, User user, Agency agency, StatusReceiving statusReceiving) {
		super();
		this.id = id;
		this.user = user;
		this.agency = agency;
		this.statusReceiving = statusReceiving;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public StatusReceiving getStatusReceiving() {
		return statusReceiving;
	}

	public void setStatusReceiving(StatusReceiving statusReceiving) {
		this.statusReceiving = statusReceiving;
	}

}
