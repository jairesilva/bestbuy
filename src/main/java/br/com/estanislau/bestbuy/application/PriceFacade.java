package br.com.estanislau.bestbuy.application;

import java.io.IOException;

import br.com.estanislau.bestbuy.interfaces.dto.PriceDTO;

public interface PriceFacade {

	public PriceDTO createPrice(final PriceDTO priceDTO) throws IOException;

}