package br.com.estanislau.bestbuy.domain.user;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;

public interface UserService extends Serializable{
	
	/**
	 * Update User
	 * 
	 * @param UserDTO
	 * @return UserDTO
	 */
	public UserDTO update(final UserDTO userDTO);
	
	/**
	 * Get one User
	 * 
	 * @param idUser Long
	 * @return UserDTO
	 */
	public UserDTO getOne(final Long idUser);
	
	
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
    public UserDTO createUser(final UserDTO userDTO) throws IOException;

    /**
    *
    * @param idUser
    * @return True
    * @throws IOException
    */
   public Boolean deleteUser(final Long idUser) throws IOException;

}
