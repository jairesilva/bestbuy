package br.com.estanislau.bestbuy.domain.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 910701499221211045L;

	private final UserRepository userRepository;
	private final ObjectMapper objectMapper;

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
		checkNotNull(status, "Status can not be null.");

		List<User> resultList = this.userRepository.findAll();
		return resultList.stream().map(user -> {
			return this.objectMapper.convertValue(user, UserDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	public UserDTO createUser(UserDTO userDTO) throws IOException {
		checkNotNull(userDTO, "User cannot be null.");
		return this.objectMapper.convertValue(
				this.userRepository.save(this.objectMapper.convertValue(userDTO, User.class)), UserDTO.class);
	}

	@Override
	public Boolean deleteUser(Long idUser) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
