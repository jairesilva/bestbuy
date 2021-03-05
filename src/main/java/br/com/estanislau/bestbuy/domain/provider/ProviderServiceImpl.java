package br.com.estanislau.bestbuy.domain.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Transient;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
import br.com.estanislau.bestbuy.interfaces.dto.ContactDTO;
import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

	private static final long serialVersionUID = 5425152269942272555L;
	private final ProviderRepository providerRepository;
	private final ContactRepository contactRepository;
	private final ObjectMapper objectMapper;

	@Override
	@Transient
	public ProviderDTO createProvider(ProviderDTO providerDTO) throws IOException {
		this.validProviderDTO(providerDTO);
		providerDTO.updateCreated(providerDTO);

		Provider provider = Provider.of(null, providerDTO.getName(), providerDTO.getAddress(),
				providerDTO.getPostalCode(), providerDTO.getCity(), providerDTO.getState(), providerDTO.getCountry(),
				providerDTO.getContactDTO().stream().map(cont -> objectMapper.convertValue(cont, Contact.class))
						.collect(Collectors.toList()),
				true, providerDTO.getCreated());

		return this.objectMapper.convertValue(this.providerRepository.save(provider), ProviderDTO.class);
	}

	@Override
	public List<ProviderDTO> listProvidersByStatus(Boolean status) throws IOException {
		checkNotNull(status, "Status can not be null.");

		final List<Provider> resultList = this.providerRepository.findAll();

		List<ProviderDTO> result = resultList.stream().map(provider -> this.convEntityToDTO(provider))
				.collect(Collectors.toList());

		return result;
	}

	@Override
	public Boolean removeProvider(Long id) throws IOException {
		checkNotNull(id, "Id cannot be null.");
		final Provider provider = this.providerRepository.findById(id)
				.orElseThrow(() -> new NotAllowException("Provider not found."));
		this.providerRepository.delete(provider);
		return true;
	}

	@Override
	public ProviderDTO updateProvider(ProviderDTO providerDTO) throws IOException {
		this.validProviderDTO(providerDTO);

		final Provider provider = this.providerRepository.findById(providerDTO.getId())
				.orElseThrow(() -> new NotAllowException("Provider not found."));

		provider.updateContact(providerDTO.getContactDTO().stream()
				.map(contact -> objectMapper.convertValue(contact, Contact.class)).collect(Collectors.toList()));
		provider.updateFromDTO(providerDTO);

		return this.convEntityToDTO(this.providerRepository.save(provider));
	}

	private ProviderDTO convEntityToDTO(Provider provider) {
		return ProviderDTO.of(provider.getId(), provider.getName(), provider.getAddress(), provider.getPostalCode(),
				provider.getCity(), provider.getState(), provider.getCountry(), provider.getContacts().stream()
						.map(obj -> objectMapper.convertValue(obj, ContactDTO.class)).collect(Collectors.toList()),
				provider.isStatus(), provider.getCreated());
	}

//	private Provider convDTOToEntity(ProviderDTO providerDTO) {
//		return Provider.of(providerDTO.getId(), providerDTO.getName(), providerDTO.getAddress(),
//				providerDTO.getPostalCode(), providerDTO.getCity(), providerDTO.getState(), providerDTO.getCountry(),
//				providerDTO.getContactDTO().stream().map(obj -> objectMapper.convertValue(obj, Contact.class))
//						.collect(Collectors.toList()),
//				providerDTO.isStatus(), providerDTO.getCreated());
//	}

	private void validProviderDTO(ProviderDTO providerDTO) {
		checkNotNull(providerDTO, "Provider cannot be null.");
		checkNotNull(providerDTO.getName(), "Name of the user cannot be null.");
		checkNotNull(providerDTO.getCity(), "City cannot be null.");
		checkNotNull(providerDTO.getCountry(), "Country type cannot be null.");
		checkNotNull(providerDTO.getState(), "State cannot be null.");
	}

}