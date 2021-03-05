package br.com.estanislau.bestbuy.domain.price;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long>, Serializable {

}
