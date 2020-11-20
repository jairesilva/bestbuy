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
public class UserFacadeImpl implements UserFacade{
	
	private final UserService userService;

	@Override
	public UserDTO update(final UserDTO userDTO) {
		return this.userService.update(userDTO);
	}

	@Override
	public UserDTO findById(Long idUser) {
		return this.userService.findById(idUser);
	}

	@Override
	public List<UserDTO> listUsersByStatus(Boolean status) {
		return this.userService.listUsersByStatus(status);
	}

	@Override
	public UserDTO addUser(UserDTO userDTO) throws IOException {
		return this.userService.addUser(userDTO);
	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		return this.userService.deleteUser(idUser);
	}
	

}
