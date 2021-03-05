package br.com.estanislau.bestbuy.domain.provider;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;

public interface ProviderService extends Serializable {

	/**
	 * Create new User
	 *
	 * @param UserDTO
	 * @return UserDTO
	 * @throws IOException
	 */
	public ProviderDTO createProvider(final ProviderDTO providerDTO) throws IOException;

	public List<ProviderDTO> listProvidersByStatus(final Boolean providerDTO) throws IOException;

	public Boolean removeProvider(final Long id) throws IOException;

	public ProviderDTO updateProvider(ProviderDTO providerDTO) throws IOException;
}
