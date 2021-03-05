package br.com.estanislau.bestbuy.interfaces;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Lista Provider by status
	 * 
	 * @param providerDTO ProviderDTO
	 * @return ResponseEntity ok
	 */
	@PostMapping("/")
	public ResponseEntity<Void> createProvider(@RequestBody final ProviderDTO providerDTO) throws IOException {
		this.providerFacade.createProvider(providerDTO);
		return ResponseEntity.ok().build();
	}

	/**
	 * List Provider by status
	 * 
	 * @param Boolean Status
	 * @return ResponseEntity list<ProviderDTO>
	 */
	@GetMapping("/")
	public ResponseEntity<List<ProviderDTO>> listProviderByStatus(@RequestParam final Boolean status)
			throws IOException {
		return ResponseEntity.ok(this.providerFacade.listProvidersByStatus(status));
	}

	/**
	 * Update Provider
	 * 
	 * @param ProviderDTO
	 * @return ResponseEntity ProviderDTO
	 */
	@PutMapping("/")
	public ResponseEntity<ProviderDTO> updateProvider(@RequestBody final ProviderDTO providerDTO) throws IOException {
		return ResponseEntity.ok(this.providerFacade.updateProvider(providerDTO));
	}

	/**
	 * Delete provider
	 * 
	 * @param Long id
	 * @return ResponseEntity list<ProviderDTO>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<List<ProviderDTO>> removeProvider(@PathVariable("id") final Long id) throws IOException {
		this.providerFacade.removeProvider(id);
		return ResponseEntity.ok().build();
	}

}
