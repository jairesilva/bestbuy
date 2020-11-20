package br.com.estanislau.bestbuy.interfaces;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PostMapping("/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody final UserDTO userDTO) throws IOException {
		return ResponseEntity.ok(this.userFacade.addUser(userDTO));
		
	}
	
	/**
	 * Add User
	 * 
	 * @param userDTO UserDTO
	 * @return ResponseEntity UserDTO
	 */
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> listUsers(@RequestParam final Boolean status) throws IOException {
		return ResponseEntity.ok(this.userFacade.listUsersByStatus(status));
	}
	
	
	/**
	 * Find by Id of User
	 * 
	 * @param Long id
	 * @return ResponseEntity UserDTO
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@RequestParam final Long id) throws IOException {
		return ResponseEntity.ok(this.userFacade.findById(id));
	}
	
	
	/**
	 * Update User
	 * 
	 * @param userDTO UserDTO
	 * @param id of the user
	 * @return 
	 * @return ResponseEntity UserDTO
	 */
	@PutMapping("/user/{id}")
	public ResponseEntity<UserDTO> updateUsers(@RequestBody final UserDTO userDTO) throws IOException {
		return ResponseEntity.ok(this.userFacade.update(userDTO));
	}
	
	/**
	 * Delete User
	 * 
	 * @param id of the user
	 * @return 
	 * @return ResponseEntity UserDTO
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteUsers(@RequestParam final Long id) throws IOException {
		this.userFacade.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
}
