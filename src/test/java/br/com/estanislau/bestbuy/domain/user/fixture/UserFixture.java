package br.com.estanislau.bestbuy.domain.user.fixture;

import java.util.Date;

import br.com.estanislau.bestbuy.domain.user.UserTypeEnum;
import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class UserFixture {

	public static final String VALID_USER = "valid-user";

	public static void loadTemplates() {
		loadUser();
	}

	public static <T> T of(final String templateName, final Class<T> as) {
		return Fixture.from(as).gimme(templateName);
	}

	private static void loadUser() {

		Fixture.of(UserDTO.class).addTemplate(VALID_USER, new Rule() {
			{
				this.add("id", 1L);
				this.add("name", "Jair Estanislau da Silva");
				this.add("userType", UserTypeEnum.DEFAULT);
				this.add("login", "jairesilva");
				this.add("Created", new Date());
				this.add("password", "1q2w3e");
			}
		});

	}
}