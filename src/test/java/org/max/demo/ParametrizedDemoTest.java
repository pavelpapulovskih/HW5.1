package org.max.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

public class ParametrizedDemoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, -3, 15, Integer.MAX_VALUE})
    @DisplayName("демонстрация работы параметраризованного теста")
    void parameterizedTest(int number) {
        //given
        //when
        //then
        Assertions.assertTrue(isOdd(number));
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest
    @DisplayName("демонстрация работы параметраризованного теста с использование enum")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "DECEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        //given
        final boolean isALeapYear = false;
        //when
        //then
        Assertions.assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @DisplayName("демонстрация работы параметраризованного теста с использование csv")
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        //given
        String actualValue = input.toUpperCase();
        //when
        //then
        Assertions.assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
            String input, String expected) {
        String actualValue = input.toUpperCase();
        Assertions.assertEquals(expected, actualValue);
    }
}
