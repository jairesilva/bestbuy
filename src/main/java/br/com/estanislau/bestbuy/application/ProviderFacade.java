package br.com.estanislau.bestbuy.application;

import java.io.IOException;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;

public interface ProviderFacade {
	
	/**
	 * Add provider
	 * 
	 * @param ProviderDTO
	 * @return ProviderDTO
	 * */
	ProviderDTO addProvider(final ProviderDTO providerDTO);
	
	/**
	 * Update Provider
	 * 
	 * @param Id Long Provider 
	 * @param ProviderDTO
	 * @return ProviderDTO
	 */
	ProviderDTO update(final ProviderDTO providerDTO);
	
	/**
	 * Get one Provider
	 * 
	 * @param idProvider Long
	 * @return ProviderDTO
	 */
	ProviderDTO findById(final Long idProvider);
	
	
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

}