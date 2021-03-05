package br.com.estanislau.bestbuy.application;

import java.io.IOException;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;

public interface ProviderFacade {

	/**
	 * Create new provider
	 *
	 * @param ProviderDTO
	 * @return Boolean
	 * @throws IOException
	 */
	public ProviderDTO createProvider(final ProviderDTO providerDTO) throws IOException;

	public List<ProviderDTO> listProvidersByStatus(Boolean status) throws IOException;

	public Boolean removeProvider(Long id) throws IOException;

	public ProviderDTO updateProvider(ProviderDTO providerDTO) throws IOException;
}
