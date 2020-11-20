package br.com.estanislau.bestbuy.application.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.estanislau.bestbuy.application.ProviderFacade;
import br.com.estanislau.bestbuy.domain.provider.ProviderService;
import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProviderFacadeImpl implements ProviderFacade {

	@Autowired
	private final ProviderService providerService;
	
	@Override
	public ProviderDTO addProvider(ProviderDTO providerDTO) {
		return this.providerService.addProvider(providerDTO);
	}

	@Override
	public ProviderDTO update(final ProviderDTO providerDTO) {
		return this.providerService.update(providerDTO);
	}

	@Override
	public ProviderDTO findById(Long idProvider) {
		return this.providerService.findById(idProvider);
	}

	@Override
	public List<ProviderDTO> listProvidersByStatus(Boolean status) {
		return this.providerService.listProvidersByStatus(status);
	}

	@Override
	public Boolean deleteProvider(Long idProvider) throws IOException {
		return this.providerService.deleteProvider(idProvider);
	}

}
