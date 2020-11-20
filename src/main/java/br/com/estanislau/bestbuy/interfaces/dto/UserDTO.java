package br.com.estanislau.bestbuy.interfaces.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.estanislau.bestbuy.domain.user.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 3743404578869630625L;

	private Long id;
	private String name;
	private UserType userType;
	private String userName;
	private LocalDateTime created;
	private String password;
}
