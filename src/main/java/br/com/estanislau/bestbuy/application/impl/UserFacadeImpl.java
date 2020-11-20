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
	public UserDTO update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getOne(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> listUsersByStatus(Boolean status) {
		return this.userService.listUsersByStatus(status);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws IOException {
		return this.userService.createUser(userDTO);
	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
