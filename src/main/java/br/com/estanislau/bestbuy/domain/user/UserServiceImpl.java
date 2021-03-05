package br.com.estanislau.bestbuy.domain.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 910701499221211045L;

	private final UserRepository userRepository;
	private final ObjectMapper objectMapper;

	@Override
	public List<UserDTO> listUsersByStatus(Boolean status) {
		checkNotNull(status, "Status can not be null.");

		List<User> resultList = this.userRepository.findAll();
		return resultList.stream().map(user -> {
			return this.objectMapper.convertValue(user, UserDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws IOException {
		checkNotNull(userDTO, "User cannot be null.");
		checkNotNull(userDTO.getName(), "Name of the user cannot be null.");
		checkNotNull(userDTO.getLogin(), "Username cannot be null.");
		checkNotNull(userDTO.getUserType(), "User type cannot be null.");
		checkNotNull(userDTO.getPassword(), "Password cannot be null.");

		userDTO.updateCreated(userDTO);
		userDTO.encriptPassword(userDTO);

		return this.objectMapper.convertValue(
				this.userRepository.save(this.objectMapper.convertValue(userDTO, User.class)), UserDTO.class);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) throws IOException {
		checkNotNull(userDTO, "User cannot be null.");
		checkNotNull(userDTO.getId(), "User id cannot be null.");
		checkNotNull(userDTO.getLogin(), "UserName cannot be null.");
		checkNotNull(userDTO.getUserType(), "User Type cannot be null.");

		final User user = this.userRepository.findById(userDTO.getId())
				.orElseThrow(() -> new NotAllowException("User not found."));
		user.update(objectMapper.convertValue(userDTO, User.class));

		return this.objectMapper.convertValue(this.userRepository.save(user), UserDTO.class);
	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		final User user = this.userRepository.findById(idUser)
				.orElseThrow(() -> new NotAllowException("User not found."));
		this.userRepository.delete(user);
		return true;
	}

	@Override
	public UserDTO findUserById(Long idUser) throws IOException {
		return objectMapper.convertValue(this.userRepository.findById(idUser), UserDTO.class);
	}

}
