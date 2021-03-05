package br.com.estanislau.bestbuy.interfaces.dto;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

	private Long id;
	private String code;
	private String name;
	private String marca;
	private String description;
	private String unity;
	private LocalDateTime created;
	private Boolean status;
	private Long subCategoryId;

	public void updateCreatedStatus(ProductDTO productDTO) {
		checkNotNull(productDTO, "Product cannot be null.");
		this.created = LocalDateTime.now();
		this.status = true;
	}
}
