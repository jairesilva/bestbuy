package br.com.estanislau.bestbuy.domain.provider;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>, Serializable {

	Optional<Contact> findByEmail(String email);

}
