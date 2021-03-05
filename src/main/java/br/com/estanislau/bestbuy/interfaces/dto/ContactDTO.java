package br.com.estanislau.bestbuy.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.estanislau.bestbuy.domain.provider.typeContactEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO {

	private Long id;
	private typeContactEnum type;
	private String name;
	private String telephone;
	private String email;

}
