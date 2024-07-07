package ge.sokolov.voidapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.time.LocalDateTime;
import java.util.Optional;

@Configuration
@EnableJdbcRepositories
@EnableJdbcAuditing
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public AuditorAware<LocalDateTime> auditorProvider() {
        return () -> Optional.of(LocalDateTime.now());
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now());
    }
}
