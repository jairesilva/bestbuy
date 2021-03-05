package br.com.estanislau.bestbuy.interfaces.dto;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

	private Long id;
	private String name;
	private String description;
	private Boolean status;
	private List<SubCategoryDTO> subCategoryDTO;
	private LocalDateTime created;

	public void updateCreatedStatus(CategoryDTO categoryDTO) {
		checkNotNull(categoryDTO, "Category cannot be null.");
		this.created = LocalDateTime.now();
		this.status = true;
	}

}
