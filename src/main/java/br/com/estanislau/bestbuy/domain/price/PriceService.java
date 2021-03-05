package br.com.estanislau.bestbuy.domain.price;

import java.io.IOException;

import br.com.estanislau.bestbuy.interfaces.dto.PriceDTO;

public interface PriceService {

	public PriceDTO createPrice(final PriceDTO priceDTO) throws IOException;

}
