package br.com.estanislau.bestbuy.domain.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

	private static final long serialVersionUID = 6296905600785892085L;
	private final ObjectMapper objectMapper;
	private final ProviderRepository providerRepository;

	private static final String ID_NOT_NULL = "ID can not be null";
	private static final String PROVIDER_NOT_NULL = "Provider can not be null";
	private static final String PROVIDER_NOT_FOUND = "Provider not found.";
	
	@Override
	public ProviderDTO addProvider(ProviderDTO providerDTO) {
		checkNotNull(providerDTO, PROVIDER_NOT_NULL);
		
		providerDTO.updateCreated(LocalDateTime.now());
		return this.objectMapper.convertValue(
				this.providerRepository.save(this.objectMapper.convertValue(providerDTO, Provider.class)), ProviderDTO.class);
	}
	
	@Override
	public ProviderDTO update(final ProviderDTO providerDTO) {
		checkNotNull(providerDTO.getId(), ID_NOT_NULL);
		checkNotNull(providerDTO, PROVIDER_NOT_NULL);
		
		Provider provider = this.providerRepository.findById(providerDTO.getId()).orElseThrow(() -> new NotAllowException(PROVIDER_NOT_FOUND));
		
		provider.update(providerDTO);
		this.providerRepository.save(provider);
		return objectMapper.convertValue(provider, ProviderDTO.class);
	}


	@Override
	public List<ProviderDTO> listProvidersByStatus(Boolean status) {
		checkNotNull(status, "Status can not be null.");

		List<Provider> resultList = this.providerRepository.findAll();
		return resultList.stream().map(provider -> {
			return this.objectMapper.convertValue(provider, ProviderDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	public Boolean deleteProvider(Long idProvider) throws IOException {
		checkNotNull(idProvider, ID_NOT_NULL);
		
		this.providerRepository.delete(this.providerRepository.findById(idProvider).orElseThrow(() -> new NotAllowException(PROVIDER_NOT_FOUND)));
		
		return true;
	}

	@Override
	public ProviderDTO findById(final Long idProvider) {
		checkNotNull(idProvider, ID_NOT_NULL);
		
		return objectMapper.convertValue(this.providerRepository.findById(idProvider).orElseThrow(() -> new NotAllowException(PROVIDER_NOT_FOUND)), ProviderDTO.class);
	}

}
