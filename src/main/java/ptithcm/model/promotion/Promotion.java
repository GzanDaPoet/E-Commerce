package ptithcm.model.promotion;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ptithcm.model.user.User;

@Entity
@Table(name = "Promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "discount_rate")
	private int discountRate;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "create_at")
	private LocalDate createAt;
	
	
//	@OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
//	private Collection<User> users;
	@OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
	private Collection<PromotionCategory> promotionCategory;
	
	
	
	public Promotion() {
		super();
	}



	public Promotion(Integer id, String name, String description, int discountRate, LocalDate startDate,
			LocalDate endDate, LocalDate createAt, Collection<User> users,
			Collection<PromotionCategory> promotionCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.discountRate = discountRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createAt = createAt;
//		this.users = users;
		this.promotionCategory = promotionCategory;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getDiscountRate() {
		return discountRate;
	}



	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public LocalDate getCreateAt() {
		return createAt;
	}



	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}



//	public Collection<User> getUsers() {
//		return users;
//	}



//	public void setUsers(Collection<User> users) {
//		this.users = users;
//	}



	public Collection<PromotionCategory> getPromotionCategories() {
		return promotionCategory;
	}



	public void setPromotionCategories(Collection<PromotionCategory> promotionCategory) {
		this.promotionCategory = promotionCategory;
	}
	
	
	
	
}
