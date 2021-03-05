package br.com.estanislau.bestbuy.domain.user;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.UserDTO;

public interface UserService extends Serializable{
	
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
     * Update User
     *
     * @param UserDTO
     * @return UserDTO
     * @throws IOException
     */
    public UserDTO updateUser(final UserDTO userDTO) throws IOException;
    
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
   * @throws IOException
   */
  public UserDTO findUserById(final Long idUser) throws IOException;
  
}
