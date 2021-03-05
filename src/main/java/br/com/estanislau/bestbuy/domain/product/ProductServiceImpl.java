package br.com.estanislau.bestbuy.domain.product;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Transient;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.estanislau.bestbuy.commons.exception.NotAllowException;
import br.com.estanislau.bestbuy.domain.provider.Category;
import br.com.estanislau.bestbuy.domain.provider.SubCategory;
import br.com.estanislau.bestbuy.interfaces.dto.CategoryDTO;
import br.com.estanislau.bestbuy.interfaces.dto.ProductDTO;
import br.com.estanislau.bestbuy.interfaces.dto.SubCategoryDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final SubCategoryRepository subCategoryRepository;
	private final ObjectMapper objectMapper;

	@Override
	@Transient
	public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
		this.validateProductDTO(productDTO);
		productDTO.updateCreatedStatus(productDTO);

		SubCategory subCategory = null;
		if (!Objects.isNull(productDTO.getSubCategoryId())) {
			subCategory = this.subCategoryRepository.findById(productDTO.getSubCategoryId())
					.orElseThrow(() -> new NotAllowException("SubCategory not found."));
		}

		Product product = Product.of(null, productDTO.getCode(), productDTO.getName(), productDTO.getMarca(),
				productDTO.getDescription(), productDTO.getUnity(), productDTO.getStatus(), productDTO.getCreated());
		subCategory.updateProduct(product);

		return this.objectMapper.convertValue(this.subCategoryRepository.save(subCategory).getProduct().get(0),
				ProductDTO.class);
	}

	@Override
	public CategoryDTO createCategory(final CategoryDTO categoryDTO) throws IOException {
		this.validateCategoryDTO(categoryDTO);
		categoryDTO.updateCreatedStatus(categoryDTO);

		final Category category = this.categoryRepository.findByNameIgnoreCase(categoryDTO.getName()).orElse(null);
		if (!Objects.isNull(category)) {
			for (SubCategory sub : category.getSubCategory()) {
				if (sub.getName().equals(categoryDTO.getSubCategoryDTO().get(0).getName())) {
					throw new NotAllowException("Category and Subcategory already exist.");
				}
			}
			SubCategoryDTO subCategoryDTO = SubCategoryDTO.of(null, categoryDTO.getSubCategoryDTO().get(0).getName(),
					categoryDTO.getSubCategoryDTO().get(0).getDescription(),
					categoryDTO.getSubCategoryDTO().get(0).getStatus(),
					categoryDTO.getSubCategoryDTO().get(0).getProduct(),
					categoryDTO.getSubCategoryDTO().get(0).getCreated());

			subCategoryDTO.updateCreatedStatus(categoryDTO.getSubCategoryDTO().get(0));

			category.updateSubCategory(objectMapper.convertValue(subCategoryDTO, SubCategory.class));
			return this.objectMapper.convertValue(this.categoryRepository.save(category), CategoryDTO.class);

		} else {
			categoryDTO.getSubCategoryDTO().get(0).updateCreatedStatus(categoryDTO.getSubCategoryDTO().get(0));
			final Category resultCategory = this.categoryRepository.save(
					Category.of(null, categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getStatus(),
							categoryDTO.getSubCategoryDTO().stream()
									.map(subDAO -> objectMapper.convertValue(subDAO, SubCategory.class))
									.collect(Collectors.toList()),
							categoryDTO.getCreated()));
			return this.objectMapper.convertValue(resultCategory, CategoryDTO.class);
		}
	}

	private void validateCategoryDTO(CategoryDTO categoryDTO) {
		checkNotNull(categoryDTO, "Category cannot be null.");
		checkNotNull(categoryDTO.getName(), "Name cannot be null.");
		checkNotNull(categoryDTO.getDescription(), "Description cannot be null.");
	}

	private void validateProductDTO(ProductDTO productDTO) {
		checkNotNull(productDTO, "Product cannot be null.");
		checkNotNull(productDTO.getCode(), "Code cannot be null.");
		checkNotNull(productDTO.getName(), "Name of the product cannot be null.");
		checkNotNull(productDTO.getDescription(), "Description cannot be null.");
	}

	@Override
	public List<ProductDTO> listProductsByStatus(Boolean status) throws IOException {
		checkNotNull(status, "Status cannot be null.");

		List<ProductDTO> result = this.productRepository.findByStatus(status).stream()
				.map(product -> this.objectMapper.convertValue(product, ProductDTO.class)).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<ProductDTO> findProductByCode(String code) throws IOException {
		checkNotNull(code, "Code cannot be null.");
		return this.productRepository.findByCode(code).stream()
				.map(prod -> objectMapper.convertValue(prod, ProductDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ProductDTO findProductByName(String name) throws IOException {
		checkNotNull(name, "Name cannot be null.");
		final Product resultList = this.productRepository.findByNameIgnoreCaseContains(name)
				.orElseThrow(() -> new NotAllowException("Product not found."));

		return objectMapper.convertValue(resultList, ProductDTO.class);
	}

	@Override
	public List<ProductDTO> listProductsByDescription(String description) throws IOException {
		checkNotNull(description, "Description cannot be null.");
		return this.productRepository.findByDescriptionIgnoreCaseContains(description).stream()
				.map(product -> this.objectMapper.convertValue(product, ProductDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> listProductsByUnity(String unity) throws IOException {
		checkNotNull(unity, "Unity cannot be null.");
		return this.productRepository.findByUnityIgnoreCase(unity).stream()
				.map(product -> this.objectMapper.convertValue(product, ProductDTO.class)).collect(Collectors.toList());
	}

	@Override
	public SubCategoryDTO listProductsBySubCategory(Long subCategoryId) throws IOException {
		checkNotNull(subCategoryId, "Subcategory cannot be null.");
		final SubCategory subCategory = this.subCategoryRepository.findById(subCategoryId)
				.orElseThrow(() -> new NotAllowException("Subcategory not found."));

		return objectMapper.convertValue(subCategory, SubCategoryDTO.class);
	}

	@Override
	public CategoryDTO listProductsByCategory(Long categoryId) {
		checkNotNull(categoryId, "Category id cannot be null.");
		final Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NotAllowException("Category not found."));

		return objectMapper.convertValue(category, CategoryDTO.class);
	}

	@Override
	public Boolean removeProduct(Long id) throws IOException {
		checkNotNull(id, "Id cannot be null.");
		final Product product = this.productRepository.findById(id)
				.orElseThrow(() -> new NotAllowException("Product not found."));
		this.productRepository.delete(product);
		return true;
	}

	@Override
	public Boolean updateProduct(ProductDTO productDTO) throws IOException {
		this.validateProductDTO(productDTO);

		final Product product = this.productRepository.findById(productDTO.getId())
				.orElseThrow(() -> new NotAllowException("Product not found."));

		product.update(productDTO);

		if (Objects.isNull(productDTO.getSubCategoryId())) {
			this.productRepository.save(product);
			return true;
		} else {
			SubCategory newSubCategory = this.subCategoryRepository.findById(productDTO.getSubCategoryId())
					.orElseThrow(() -> new NotAllowException("Subcategory not found."));
			newSubCategory.updateProduct(product);
			this.subCategoryRepository.save(newSubCategory);
			return true;
		}

	}

}
