package org.nagarro.CustomerSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"org.nagarro.samplelib"})
@EnableJpaRepositories(basePackages = {"org.nagarro.samplelib"})
//@ComponentScan(basePackages = { "org.nagarro.samplelib"})
public class CustomerSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSampleApplication.class, args);
	}

}
