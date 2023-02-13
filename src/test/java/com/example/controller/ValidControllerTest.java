package com.example.controller;

import com.example.entity.BodyDemo;
import com.example.response.ResponseResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

class ValidControllerTest {

    private ValidController validControllerUnderTest;

    @BeforeEach
    void setUp() {
        validControllerUnderTest = new ValidController();
    }

    @Test
    void testDemo() {
        // Setup
        final BodyDemo demo = new BodyDemo("name", 0, "address", "email");
        final BindingResult bindingResult = null;

        // Run the test
        final ResponseResult result = validControllerUnderTest.demo(demo, bindingResult);

        // Verify the results
    }
}
