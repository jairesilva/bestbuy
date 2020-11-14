package br.com.estanislau.bestbuy.interfaces;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estanislau.bestbuy.application.UserFacade;
import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
	
	private final UserFacade userFacade;
	
	/**
	 * Add User
	 * 
	 * @param userDTO UserDTO
	 * @return ResponseEntity UserDTO
	 */
	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody final UserDTO userDTO) throws IOException {
		this.userFacade.createUser(userDTO);
		
		return ResponseEntity.ok().build();
		
	}
	
	/**
	 * Add Rser
	 * 
	 * @param userDTO UserDTO
	 * @return ResponseEntity UserDTO
	 */
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> listUsers(@RequestParam final Boolean status) throws IOException {
		return ResponseEntity.ok(this.userFacade.listUsersByStatus(status));
		
	}

}
