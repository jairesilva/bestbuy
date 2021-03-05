package br.com.estanislau.bestbuy.application.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.estanislau.bestbuy.application.ProviderFacade;
import br.com.estanislau.bestbuy.domain.provider.ProviderService;
import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProviderFacadeImpl implements ProviderFacade {

	private final ProviderService providerService;

	@Override
	public ProviderDTO createProvider(ProviderDTO providerDTO) throws IOException {
		return this.providerService.createProvider(providerDTO);
	}

	@Override
	public List<ProviderDTO> listProvidersByStatus(Boolean status) throws IOException {
		return this.providerService.listProvidersByStatus(status);
	}

	@Override
	public Boolean removeProvider(Long id) throws IOException {
		return this.providerService.removeProvider(id);
	}

	@Override
	public ProviderDTO updateProvider(ProviderDTO providerDTO) throws IOException {
		return this.providerService.updateProvider(providerDTO);
	}

}
