package ge.sokolov.voidapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(scanBasePackages = "ge.sokolov.voidapp")
@EnableJdbcRepositories
public class VoidApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoidApplication.class, args);
	}

}
