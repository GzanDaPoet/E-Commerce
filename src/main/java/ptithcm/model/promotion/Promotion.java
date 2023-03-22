package ptithcm.model.promotion;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ptithcm.model.user.User;

@Entity
@Table(name = "Promotion")
public class Promotion {
	@Id
	@GeneratedValue
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
	
	
	@OneToMany(mappedBy = "promotion", fetch = FetchType.EAGER)
	private Collection<User> users;
	@OneToMany(mappedBy = "promotion", fetch = FetchType.EAGER)
	private Collection<PromotionCategory> promotionCategories;
	
	
	
	
}
