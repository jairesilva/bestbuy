package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProviderRepository extends JpaRepository<Provider, Long>, Serializable {
	

}
