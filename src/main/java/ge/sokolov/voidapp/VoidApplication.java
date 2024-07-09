package ge.sokolov.voidapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication(scanBasePackages = "ge.sokolov.voidapp")
@EnableJdbcRepositories
@CommandScan
public class VoidApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoidApplication.class, args);
    }

}
