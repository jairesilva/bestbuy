package br.com.estanislau.bestbuy.application.impl;

import java.io.IOException;

import org.springframework.stereotype.Component;

import br.com.estanislau.bestbuy.application.PriceFacade;
import br.com.estanislau.bestbuy.domain.price.PriceService;
import br.com.estanislau.bestbuy.interfaces.dto.PriceDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceFacadeImpl implements PriceFacade {

	private final PriceService priceService;

	@Override
	public PriceDTO createPrice(PriceDTO priceDTO) throws IOException {
		return this.priceService.createPrice(priceDTO);
	}

}
