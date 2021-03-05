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
import org.springframework.web.bind.annotation.RestController;

import br.com.estanislau.bestbuy.application.ProductFacade;
import br.com.estanislau.bestbuy.interfaces.dto.CategoryDTO;
import br.com.estanislau.bestbuy.interfaces.dto.ProductDTO;
import br.com.estanislau.bestbuy.interfaces.dto.SubCategoryDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ProductController {

	private final ProductFacade productFacade;

	/**
	 * Create a new Category
	 * 
	 * @param CategoryDTO
	 * @return ResponseEntity ok
	 */
	@PostMapping("/category/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody final CategoryDTO categoryDTO) throws IOException {
		return ResponseEntity.ok(this.productFacade.createCategory(categoryDTO));
	}

	/**
	 * Create a new product
	 * 
	 * @param ProductDTO
	 * @return ResponseEntity ok
	 */
	@PostMapping("/")
	public ResponseEntity<Void> createProduct(@RequestBody final ProductDTO productDTO) throws IOException {
		this.productFacade.createProduct(productDTO);
		return ResponseEntity.ok().build();
	}

	/**
	 * Update product
	 * 
	 * @param ProductDTO
	 * @return ResponseEntity ok
	 */
	@GetMapping("/liststatus/{status}")
	public ResponseEntity<List<ProductDTO>> listProductByStatus(@PathVariable("status") final Boolean status)
			throws IOException {
		return ResponseEntity.ok(this.productFacade.listProductsByStatus(status));
	}

	@GetMapping("/listcode/{code}")
	public ResponseEntity<List<ProductDTO>> listProductByStatus(@PathVariable("code") final String code)
			throws IOException {
		return ResponseEntity.ok(this.productFacade.findProductByCode(code));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<ProductDTO> findProductByName(@PathVariable("name") final String name) throws IOException {
		return ResponseEntity.ok(this.productFacade.findProductByName(name));
	}

	@GetMapping("/listdescription/{description}")
	public ResponseEntity<List<ProductDTO>> listProductByDescription(
			@PathVariable("description") final String description) throws IOException {
		return ResponseEntity.ok(this.productFacade.listProductsByDescription(description));
	}

	@GetMapping("/listunity/{unity}")
	public ResponseEntity<List<ProductDTO>> listProductByUnity(@PathVariable("unity") final String unity)
			throws IOException {
		return ResponseEntity.ok(this.productFacade.listProductsByUnity(unity));
	}

	@GetMapping("/listsubcategory/{subCategoryId}")
	public ResponseEntity<SubCategoryDTO> listProductBySubCategory(
			@PathVariable("subCategoryId") final Long subCategoryId) throws IOException {
		return ResponseEntity.ok(this.productFacade.listProductsBySubCategory(subCategoryId));
	}

	@GetMapping("/listcategory/{categoryiId}")
	public ResponseEntity<CategoryDTO> listProductByCategory(@PathVariable("categoryiId") final Long categoryiId)
			throws IOException {
		return ResponseEntity.ok(this.productFacade.listProductsByCategory(categoryiId));
	}

	@PutMapping("/")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody final ProductDTO productDTO) throws IOException {
		this.productFacade.updateProduct(productDTO);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<ProductDTO>> removeProduct(@PathVariable("id") final Long id) throws IOException {
		this.productFacade.removeProduct(id);
		return ResponseEntity.ok().build();
	}

}
