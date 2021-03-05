package br.com.estanislau.bestbuy.application.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.estanislau.bestbuy.application.ProductFacade;
import br.com.estanislau.bestbuy.domain.product.ProductService;
import br.com.estanislau.bestbuy.interfaces.dto.CategoryDTO;
import br.com.estanislau.bestbuy.interfaces.dto.ProductDTO;
import br.com.estanislau.bestbuy.interfaces.dto.SubCategoryDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductFacadeImpl implements ProductFacade {

	private final ProductService productService;

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
		return this.productService.createProduct(productDTO);
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
		return this.productService.createCategory(categoryDTO);
	}

	@Override
	public List<ProductDTO> listProductsByStatus(Boolean status) throws IOException {
		return this.productService.listProductsByStatus(status);
	}

	@Override
	public List<ProductDTO> findProductByCode(String code) throws IOException {
		return this.productService.findProductByCode(code);
	}

	@Override
	public ProductDTO findProductByName(String name) throws IOException {
		return this.productService.findProductByName(name);
	}

	@Override
	public List<ProductDTO> listProductsByDescription(String description) throws IOException {
		return this.productService.listProductsByDescription(description);
	}

	@Override
	public List<ProductDTO> listProductsByUnity(String unity) throws IOException {
		return this.productService.listProductsByUnity(unity);
	}

	@Override
	public SubCategoryDTO listProductsBySubCategory(Long subCategoryId) throws IOException {
		return this.productService.listProductsBySubCategory(subCategoryId);
	}

	@Override
	public CategoryDTO listProductsByCategory(Long categoryiId) {
		return this.productService.listProductsByCategory(categoryiId);
	}

	@Override
	public Boolean removeProduct(Long id) throws IOException {
		return this.productService.removeProduct(id);
	}

	@Override
	public Boolean updateProduct(ProductDTO providerDTO) throws IOException {
		return this.productService.updateProduct(providerDTO);
	}

}
