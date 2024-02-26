package co.com.bancolombia.api.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.cors.CorsConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class CorsConfigTest {

    @InjectMocks
    private CorsConfig corsConfig;

    private String origins;

    @BeforeEach
    void setUp() {
        origins = CorsConfiguration.ALL;
    }

    @Test
    void shouldReturnCorsWebFilterBean() {
        assertNotNull(corsConfig.corsWebFilter(origins));
    }
}