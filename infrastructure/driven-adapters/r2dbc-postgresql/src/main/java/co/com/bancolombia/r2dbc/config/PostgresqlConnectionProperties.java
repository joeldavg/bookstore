package co.com.bancolombia.r2dbc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "adapters.postgres")
public class PostgresqlConnectionProperties {

    private String database;
    private String schema;
    private String username;
    private String password;
    private String host;
    private Integer port;

}
