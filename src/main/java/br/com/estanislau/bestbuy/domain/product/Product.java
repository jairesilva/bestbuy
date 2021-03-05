package br.com.estanislau.bestbuy.domain.product;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.common.base.Objects;

import br.com.estanislau.bestbuy.interfaces.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "tbproduct", uniqueConstraints = @UniqueConstraint(columnNames = {
		"tbproduct_id" }, name = "tbproduct_id_UK"))
public class Product implements Serializable {

	private static final long serialVersionUID = -7447557778739811944L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tbproduct_id")
	private Long id;

	@Column(name = "tbproduct_code")
	private String code;

	@Column(name = "tbproduct_name")
	private String name;

	@Column(name = "tbproduct_marca")
	private String marca;

	@Column(name = "tbproduct_description")
	private String description;

	@Column(name = "tbproduct_unity")
	private String unity;

	@Column(name = "tbproduct_status")
	private Boolean status;

	@Column(name = "tbuser_created")
	private LocalDateTime created;

	public void update(ProductDTO productDTO) {
		this.code = productDTO.getCode();
		this.name = productDTO.getName();
		this.marca = productDTO.getMarca();
		this.description = productDTO.getDescription();
		this.unity = productDTO.getUnity();
		this.status = Objects.equal(productDTO.getStatus(), null) ? this.status : productDTO.getStatus();
	}

}
