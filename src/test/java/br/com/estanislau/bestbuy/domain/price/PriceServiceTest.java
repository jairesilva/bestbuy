package br.com.estanislau.bestbuy.domain.price;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.estanislau.bestbuy.domain.price.fixture.PriceFixture;
import br.com.estanislau.bestbuy.interfaces.dto.PriceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PriceServiceTest {

	@BeforeClass
	public static void initialSetup() {
		PriceFixture.loadTemplate();
	}

	@Autowired
	private PriceService priceService;

	@Test
	public void createPriceSucessTest() throws IOException {
		final PriceDTO priceDTOExpected = PriceFixture.of(PriceFixture.VALID_ID, PriceDTO.class);

		final PriceDTO created = this.priceService.createPrice(priceDTOExpected);

	}

}
