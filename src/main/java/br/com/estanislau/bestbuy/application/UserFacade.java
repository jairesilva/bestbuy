package br.com.estanislau.bestbuy.application;

import java.io.IOException;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;

public interface UserFacade {
	
	/**
	 * Update User
	 * 
	 * @param Id Long User 
	 * @param UserDTO
	 * @return UserDTO
	 */
	UserDTO update(final UserDTO userDTO);
	
	/**
	 * Get one User
	 * 
	 * @param idUser Long
	 * @return UserDTO
	 */
	UserDTO findById(final Long idUser);
	
	
	/**
     * List all users by status
     *
     * @param status
     * @return The {@link UserDTO}
     */
    public List<UserDTO> listUsersByStatus(final Boolean status);

    /**
     * Create new User
     *
     * @param UserDTO
     * @return UserDTO
     * @throws IOException
     */
    public UserDTO addUser(final UserDTO userDTO) throws IOException;

    /**
    *
    * @param idUser
    * @return True
    * @throws IOException
    */
   public Boolean deleteUser(final Long idUser) throws IOException;
}
