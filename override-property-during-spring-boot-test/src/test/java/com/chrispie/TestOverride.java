package com.chrispie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
@ExtendWith(MockitoExtension.class)
class TestOverride {

    @Autowired
    PropertyConfig propertyConfig;

    @Test
    void testValueIsOverridden() {
        Assertions.assertThat(propertyConfig.getProperty()).isEqualTo("apiProp"); //Value should be `apiProp` and not `defaultProp`
    }

}
