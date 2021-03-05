package br.com.estanislau.bestbuy.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.estanislau.bestbuy.domain.user.fixture.UserFixture;
import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserServiceTest {

	@BeforeClass
	public static void initialSetup() {
		UserFixture.loadTemplates();
	}

	@Autowired
	private UserService userService;

	@Test
	@Sql("classpath:sql/truncate.sql")
	@Sql("classpath:sql/domain/user/get-user-data.sql")
	public void listUsersByStatusSuccess() {

		final Boolean status = true;
		final List<UserDTO> resultList = this.userService.listUsersByStatus(status);

		assertEquals(1, resultList.size());
	}
}
