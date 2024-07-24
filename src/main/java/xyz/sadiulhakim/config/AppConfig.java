package xyz.sadiulhakim.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.sadiulhakim.FastDBClient;

@Slf4j
@Configuration
public class AppConfig {
    @Value("${fast.db.host:localhost}")
    private String host;

    @Value("${fast.db.port:8000}")
    private int port;

    @Bean
    public FastDBClient template() {
        try {
            return new FastDBClient(host, port);
        } catch (Exception ex) {
            log.error("Could not create FastDBClient : {}", ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
