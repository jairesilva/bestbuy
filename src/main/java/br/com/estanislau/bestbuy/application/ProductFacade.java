package br.com.estanislau.bestbuy.application;

import java.io.IOException;
import java.util.List;

import br.com.estanislau.bestbuy.interfaces.dto.CategoryDTO;
import br.com.estanislau.bestbuy.interfaces.dto.ProductDTO;
import br.com.estanislau.bestbuy.interfaces.dto.SubCategoryDTO;

public interface ProductFacade {

	public ProductDTO createProduct(final ProductDTO productDTO) throws IOException;

	public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

	public List<ProductDTO> listProductsByStatus(Boolean status) throws IOException;

	public List<ProductDTO> findProductByCode(String code) throws IOException;

	public ProductDTO findProductByName(String name) throws IOException;

	public List<ProductDTO> listProductsByDescription(String description) throws IOException;

	public List<ProductDTO> listProductsByUnity(String unity) throws IOException;

	public SubCategoryDTO listProductsBySubCategory(Long subCategoryId) throws IOException;

	public CategoryDTO listProductsByCategory(Long categoryiId);

	public Boolean removeProduct(Long id) throws IOException;

	public Boolean updateProduct(ProductDTO providerDTO) throws IOException;

}