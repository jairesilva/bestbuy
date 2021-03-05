package br.com.estanislau.bestbuy.application.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.estanislau.bestbuy.application.UserFacade;
import br.com.estanislau.bestbuy.domain.user.UserService;
import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFacadeImpl implements UserFacade {

	private final UserService userService;

	@Override
	public List<UserDTO> listUsersByStatus(Boolean status) {
		return this.userService.listUsersByStatus(status);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws IOException {
		return this.userService.createUser(userDTO);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) throws IOException {
		return this.userService.updateUser(userDTO);
	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		return this.userService.deleteUser(idUser);
	}

	@Override
	public UserDTO findUserById(Long idUser) throws IOException {
		return this.userService.findUserById(idUser);
	}

}
