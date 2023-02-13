package com.example.property;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YmlConfigFactoryTest {

    private YmlConfigFactory ymlConfigFactoryUnderTest;

    @BeforeEach
    void setUp() {
        ymlConfigFactoryUnderTest = new YmlConfigFactory();
    }

    @Test
    void testCreatePropertySource() throws Exception {
        // Setup
        final EncodedResource resource = new EncodedResource(null);
        final PropertySource<?> expectedResult = PropertySource.named("name");

        // Run the test
        final PropertySource<?> result = ymlConfigFactoryUnderTest.createPropertySource("name", resource);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testCreatePropertySource_ThrowsIOException() {
        // Setup
        final EncodedResource resource = new EncodedResource(null);

        // Run the test
        assertThatThrownBy(() -> ymlConfigFactoryUnderTest.createPropertySource("name", resource))
                .isInstanceOf(IOException.class);
    }
}
