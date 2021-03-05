package br.com.estanislau.bestbuy.domain.product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estanislau.bestbuy.domain.provider.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>, Serializable {

	Optional<Category> findByNameIgnoreCase(String name);

	List<Category> findByStatus(Boolean status);

}
