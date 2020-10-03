package com.wog.eag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication( exclude = { HibernateJpaAutoConfiguration.class })
public class EagBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagBackApplication.class, args);
	}

}
