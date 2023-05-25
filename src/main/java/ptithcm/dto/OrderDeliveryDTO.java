package ptithcm.dto;

import java.sql.Date;
import java.util.List;

import ptithcm.model.order.OrderLine;

public class OrderDeliveryDTO {
	private Integer id;
	private Integer orderId;
	private String status;
	private Date deliveryDate;
	private Date deliveryReceived;
	private Integer userId;
	private List<OrderLine> listOrderDelivery;

	public OrderDeliveryDTO() {
		super();
	}

	public OrderDeliveryDTO(Integer orderId, String status, Date deliveryDate, Date deliveryReceived, Integer userId,
			List<OrderLine> listOrderDelivery) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.deliveryDate = deliveryDate;
		this.deliveryReceived = deliveryReceived;
		this.userId = userId;
		this.listOrderDelivery = listOrderDelivery;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getDeliveryReceived() {
		return deliveryReceived;
	}

	public void setDeliveryReceived(Date deliveryReceived) {
		this.deliveryReceived = deliveryReceived;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<OrderLine> getListOrderDelivery() {
		return listOrderDelivery;
	}

	public void setListOrderDelivery(List<OrderLine> listOrderDelivery) {
		this.listOrderDelivery = listOrderDelivery;
	}

}
