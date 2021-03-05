package br.com.estanislau.bestbuy.interfaces;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estanislau.bestbuy.application.PriceFacade;
import br.com.estanislau.bestbuy.interfaces.dto.PriceDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class PriceController {

	private final PriceFacade priceFacade;

	/**
	 * Create a new price
	 * 
	 * @param PriceDTO
	 * @return ResponseEntity ok whit the new PriceDTO
	 */
	@PostMapping("/")
	public ResponseEntity<PriceDTO> createPrice(@RequestBody final PriceDTO priceDTO) throws IOException {
		return ResponseEntity.ok(this.priceFacade.createPrice(priceDTO));
	}
}