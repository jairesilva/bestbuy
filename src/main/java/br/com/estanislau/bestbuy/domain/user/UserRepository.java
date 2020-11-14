package br.com.estanislau.bestbuy.domain.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>, Serializable {
	

}
