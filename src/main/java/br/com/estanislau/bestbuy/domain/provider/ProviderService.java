package br.com.estanislau.bestbuy.domain.provider;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;

public interface ProviderService extends Serializable {
	
	/**
	 * Add provider
	 * 
	 * @param ProviderDTO
	 * @return ProviderDTO
	 */
	public ProviderDTO addProvider(final ProviderDTO providerDTO);
	
	/**
	 * Update Provider
	 * 
	 * @param Id Long Provider
	 * @param ProviderDTO
	 * @return ProviderDTO
	 */
	public ProviderDTO update(final ProviderDTO providerDTO);
	
	/**
     * List all providers by status
     *
     * @param status
     * @return The {@link ProviderDTO}
     */
    public List<ProviderDTO> listProvidersByStatus(final Boolean status);

    /**
    *
    * @param idProvider
    * @return True
    * @throws IOException
    */
   public Boolean deleteProvider(final Long idProvider) throws IOException;
   
   /**
    * 
    * @param idProvider
    * @return ProviderDTO
    */
   public ProviderDTO findById(Long idProvider);

}
