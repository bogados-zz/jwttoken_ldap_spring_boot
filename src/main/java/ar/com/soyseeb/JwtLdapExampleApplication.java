package ar.com.soyseeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@EntityScan(basePackages = "ar.com.tssa.core.model")

public class JwtLdapExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtLdapExampleApplication.class, args);
	}
}
