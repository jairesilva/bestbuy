package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbproduct_category", uniqueConstraints = @UniqueConstraint(columnNames = {
		"tbproduct_category_name" }, name = "tbproduct_category_name_UK"))
public class Category implements Serializable {

	private static final long serialVersionUID = 7619414036780563703L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbproduct_category_id")
	private Long id;

	@Column(name = "tbproduct_category_name")
	private String name;

	@Column(name = "tbproduct_category_description")
	private String description;

	@Column(name = "tbproduct_category_status")
	private Boolean status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "category_id")
	private List<SubCategory> subCategory;

	@Column(name = "tbproduct_category_created")
	private LocalDateTime created;

	public void updateSubCategory(SubCategory subCategory) {
		this.subCategory.add(subCategory);
	}

}
