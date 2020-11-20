package br.com.estanislau.bestbuy.interfaces;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estanislau.bestbuy.application.ProviderFacade;
import br.com.estanislau.bestbuy.interfaces.dto.ProviderDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/providers")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ProviderController {
	
private final ProviderFacade providerFacade;
	
	/**
	 * Add Provider
	 * 
	 * @param providerDTO ProviderDTO
	 * @return ResponseEntity ProviderDTO
	 */
	@PostMapping("/add")
	public ResponseEntity<ProviderDTO> addProvider(@RequestBody final ProviderDTO providerDTO) throws IOException {
		return ResponseEntity.ok(this.providerFacade.addProvider(providerDTO));
		
	}

	/**
	 * Add Provider
	 * 
	 * @param providerDTO ProviderDTO
	 * @return ResponseEntity ProviderDTO
	 */
	@GetMapping("/")
	public ResponseEntity<List<ProviderDTO>> listProviders(@RequestParam final Boolean status) throws IOException {
		return ResponseEntity.ok(this.providerFacade.listProvidersByStatus(status));
	}
	
	
	/**
	 * Find prorovider by id
	 * 
	 * @param Long id
	 * @return ResponseEntity ProviderDTO
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProviderDTO> findById(@RequestParam final Long idProvider) throws IOException {
		return ResponseEntity.ok(this.providerFacade.findById(idProvider));
	}
	
	
	/**
	 * Update Provider
	 * 
	 * @param providerDTO ProviderDTO
	 * @param id of the provider
	 * @return 
	 * @return ResponseEntity ProviderDTO
	 */
	@PutMapping("/provider/{id}")
	public ResponseEntity<ProviderDTO> updateProviders(@RequestBody final ProviderDTO providerDTO) throws IOException {
		return ResponseEntity.ok(this.providerFacade.update(providerDTO));
	}
	
	/**
	 * Delete Provider
	 * 
	 * @param id of the provider
	 * @return 
	 * @return ResponseEntity ProviderDTO
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProviderDTO> deleteProviders(@RequestParam final Long id) throws IOException {
		this.providerFacade.deleteProvider(id);
		return ResponseEntity.noContent().build();
	}
}
