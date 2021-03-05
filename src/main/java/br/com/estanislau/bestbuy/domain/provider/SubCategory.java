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

import br.com.estanislau.bestbuy.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbproduct_sub_category", uniqueConstraints = @UniqueConstraint(columnNames = {
		"tbproduct_sub_category_name" }, name = "tbproduct_sub_category_name_UK"))
public class SubCategory implements Serializable {

	private static final long serialVersionUID = -4860270510978817891L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbproduct_sub_category_id")
	private Long id;

	@Column(name = "tbproduct_sub_category_name")
	private String name;

	@Column(name = "tbproduct_sub_category_description")
	private String description;

	@Column(name = "tbproduct_sub_category_status")
	private Boolean status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sub_category_id")
	private List<Product> product;

	@Column(name = "tbproduct_sub_category_created")
	private LocalDateTime created;

	public void updateProduct(Product product) {
		this.product.add(product);
	}

}
