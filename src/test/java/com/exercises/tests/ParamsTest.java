package com.exercises.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.exercises.Params;

public class ParamsTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    @DisplayName("Should return true for null or blank string")
    void shouldReturnTrueForNullOrBlankString(String input) {
        assertTrue(Params.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Should return true for null input")
    void shouldReturnTrueForNull(String input) {
        assertTrue(Params.isBlank(input));
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    // @EnumSource(
    // value = Month.class,
    // names = { "APRIL", "JUNE" },
    // mode = EnumSource.Mode.EXCLUDE)
    @DisplayName("Should always between 1 and 12")
    void shouldBetween1And12(Month month) {
        int value = month.getValue();
        assertTrue(value >= 1 && value <= 12);
    }

    @ParameterizedTest
    // @CsvSource({ "test,TEST", "tEst,TEST", "Java,JAVA" })
    @CsvSource(value = {"test:TEST", "tEst:TEST", "Java:JAVA"}, delimiter = ':')
    @DisplayName("Should generate expected uppercase value")
    void shouldGenerateExpectedUppercaseValue(String input, String expected) {
        String actual = input.toUpperCase();
        assertEquals(expected, actual);
    }
}
