package br.com.estanislau.bestbuy.domain.user;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;

public interface UserService extends Serializable{
	
	/**
	 * Create new User
	 *
	 * @param UserDTO
	 * @return UserDTO
	 * @throws IOException
	 */
	public UserDTO addUser(final UserDTO userDTO) throws IOException;

	/**
	 * Update User
	 * 
	 * @param Id Long User
	 * @param UserDTO
	 * @return UserDTO
	 */
	public UserDTO update(final UserDTO userDTO);
	
	/**
     * List all users by status
     *
     * @param status
     * @return The {@link UserDTO}
     */
    public List<UserDTO> listUsersByStatus(final Boolean status);

    /**
    *
    * @param idUser
    * @return True
    * @throws IOException
    */
   public Boolean deleteUser(final Long idUser) throws IOException;
   
   /**
    * 
    * @param idUser
    * @return UserDTO
    */
   public UserDTO findById(Long idUser);

}
