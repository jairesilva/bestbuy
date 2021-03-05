package br.com.estanislau.bestbuy.interfaces.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.estanislau.bestbuy.domain.price.PriceItem;
import br.com.estanislau.bestbuy.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {

	private Long id;
	private Float amount;
	private Float value;
	private List<PriceItem> priceItem;
	private User createdBy;
	private LocalDate created;

}
