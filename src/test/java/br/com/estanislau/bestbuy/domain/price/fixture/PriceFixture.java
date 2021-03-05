package br.com.estanislau.bestbuy.domain.price.fixture;

import br.com.six2six.fixturefactory.Fixture;

public class PriceFixture {

	public static final String VALID_ID = "valid-id";

	public static void loadTemplate() {
		loadPrice();
	}

	public static <T> T of(final String templateName, final Class<T> as) {
		return Fixture.from(as).gimme(templateName);
	}

	private static void loadPrice() {

//		Fixture.of(PriceDTO.class).addTemplate(VALID_ID, new Rule() {
//			{
//				this.add("id", 1L);
//				this.add("amount", 100.10);
//				this.add("value", 101.11);
//			}
//		});

	}
}