package br.com.estanislau.bestbuy.domain.price;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.estanislau.bestbuy.domain.product.Product;
import br.com.estanislau.bestbuy.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbprice", uniqueConstraints = @UniqueConstraint(columnNames = { "tbprice_id" }, name = "tbprice_id_UK"))
public class Price implements Serializable {

	private static final long serialVersionUID = 5636570370434038445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbprice_id")
	private Long id;

	@Column(name = "tbprice_amount")
	private Float amount;

	@Column(name = "tbprice_value")
	private Float value;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private List<Product> products;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_created_by")
	private User createdBy;

	@Column(name = "tbprice_created")
	private LocalDate created;

}
