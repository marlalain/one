package dev.alexaa;

import org.junit.jupiter.api.Test;

import static dev.alexaa.StringUtils.validate;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    public void simpleCorrectCase() {
        validate("Hello, World!");
    }

    @Test
    public void emptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
           validate("");
        });
    }

    @Test
    public void emptyWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> {
            validate("               ");
        });
    }
}