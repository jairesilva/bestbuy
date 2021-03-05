package br.com.estanislau.bestbuy.domain.price;

import java.io.Serializable;
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
@Table(name = "tbprice_item", uniqueConstraints = @UniqueConstraint(columnNames = {
		"tbprice_item_id" }, name = "tbprice_item_id_UK"))
public class PriceItem implements Serializable {

	private static final long serialVersionUID = 161308189341715714L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbprice_item_id")
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_item_id")
	private List<Product> product;

	@Column(name = "tbprice_item_code")
	private String code;
}
