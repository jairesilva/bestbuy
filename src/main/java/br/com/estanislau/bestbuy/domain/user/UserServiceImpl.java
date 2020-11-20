package br.com.estanislau.bestbuy.domain.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.time.LocalDateTime;
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

	private static final String ID_NOT_NULL = "ID can not be null";
	private static final String USER_NOT_NULL = "User can not be null";
	private static final String USER_NOT_FOUND = "User not found.";
	private final UserRepository userRepository;
	private final ObjectMapper objectMapper;

	@Override
	public UserDTO addUser(UserDTO userDTO) throws IOException {
		checkNotNull(userDTO, "User cannot be null.");
		userDTO.updateCreated(LocalDateTime.now());
		return this.objectMapper.convertValue(
				this.userRepository.save(this.objectMapper.convertValue(userDTO, User.class)), UserDTO.class);
	}

	@Override
	public UserDTO update(final UserDTO userDTO) {
		checkNotNull(userDTO.getId(), ID_NOT_NULL);
		checkNotNull(userDTO, USER_NOT_NULL);
		
		User user = this.userRepository.findById(userDTO.getId()).orElseThrow(() -> new NotAllowException(USER_NOT_FOUND));
		
		user.update(userDTO);
		this.userRepository.save(user);
		return objectMapper.convertValue(user, UserDTO.class);
	}


	@Override
	public List<UserDTO> listUsersByStatus(Boolean status) {
		checkNotNull(status, "Status can not be null.");

		List<User> resultList = this.userRepository.findAll();
		return resultList.stream().map(user -> {
			return this.objectMapper.convertValue(user, UserDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		checkNotNull(idUser, ID_NOT_NULL);
		
		this.userRepository.delete(this.userRepository.findById(idUser).orElseThrow(() -> new NotAllowException(USER_NOT_FOUND)));
		
		return true;
	}

	@Override
	public UserDTO findById(final Long idUser) {
		checkNotNull(idUser, ID_NOT_NULL);
		
		return objectMapper.convertValue(this.userRepository.findById(idUser).orElseThrow(() -> new NotAllowException(USER_NOT_FOUND)), UserDTO.class);
	}

}