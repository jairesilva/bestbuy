package br.com.estanislau.bestbuy.domain.product;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, Serializable {

	Optional<Product> findByNameIgnoreCaseContains(String name);

	List<Product> findByStatus(Boolean status);

	Collection<Product> findByCode(String code);

	List<Product> findByDescriptionIgnoreCaseContains(String description);

	List<Product> findByUnityIgnoreCase(String unity);

}
