package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long>, Serializable {

	Optional<Provider> findByNameIgnoreCase(String name);

	List<Provider> findByStatus(Boolean status);

}
