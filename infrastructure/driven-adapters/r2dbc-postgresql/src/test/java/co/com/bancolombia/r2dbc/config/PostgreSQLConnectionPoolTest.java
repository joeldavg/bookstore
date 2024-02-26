package co.com.bancolombia.r2dbc.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostgreSQLConnectionPoolTest {

    @InjectMocks
    private PostgreSQLConnectionPool connectionPool;

    private PostgresqlConnectionProperties properties;

    @BeforeEach
    void setUp() {
        properties = new PostgresqlConnectionProperties();
        properties.setSchema("test");
        properties.setDatabase("test");
        properties.setHost("test");
        properties.setUsername("test");
        properties.setPassword("test");
        properties.setPort(5432);
    }

    @Test
    void getConnectionConfig() {
        Assertions.assertNotNull(connectionPool.getConnectionConfig(properties));
    }
}
