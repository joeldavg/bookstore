package co.com.bancolombia.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObjectMapperConfigTest {

    @InjectMocks
    private ObjectMapperConfig objectMapperConfig;

    @Test
    void shouldReturnAnObjectMapperConfigInstance() {
        assertNotNull(objectMapperConfig);
    }

    @Test
    void shouldReturnAnObjectMapperBean() {
        assertNotNull(objectMapperConfig.objectMapper());
    }
}