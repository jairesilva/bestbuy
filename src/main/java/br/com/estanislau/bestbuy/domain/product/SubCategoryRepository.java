package br.com.estanislau.bestbuy.domain.product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estanislau.bestbuy.domain.provider.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>, Serializable {

	Optional<SubCategory> findByNameIgnoreCase(String name);

	Optional<SubCategory> findByProductId(Long id);

	List<SubCategory> findByStatus(Boolean status);

}
