package br.com.estanislau.bestbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {BestbuyApplication.class, Jsr310JpaConverters.class})
public class BestbuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestbuyApplication.class, args);
	}

}
