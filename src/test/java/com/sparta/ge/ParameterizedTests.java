package com.sparta.ge;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ParameterizedTests {



    @ParameterizedTest(name = "{index} of {argumentsWithNames}")
    @ValueSource(ints = {1, 20, 30, 5, 7, 15})
    @DisplayName("Check for int higher than 10")
    void checkForIntHigherThan10(int num){
        Assumptions.assumeTrue(num > 10);
    }

    @ParameterizedTest
    //@CsvSource({"David", "Manish"})
    @CsvFileSource(resources = "names.csv")
    @NullAndEmptySource
    @DisplayName("Using CSV source for test")
    void runCSVTests(String name){
        Assertions.assertEquals(5, name.length());
    }

    @ParameterizedTest
    @MethodSource("SourceMethod")
    @DisplayName("Using a method source")
    void usingAMethodSource(int number, String name){
        Assertions.assertEquals(name.length(), number);
    }

    public static Stream<Arguments> SourceMethod() {
        return Stream.of(
                Arguments.of(1, "Manish"),
                Arguments.of(2, "David"),
                Arguments.of(3, "Stephen"),
                Arguments.of(4, "Danny")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 7, 8, 10})
    @DisplayName("Testing for exceptions")
    void testingForExceptions(int number){
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> numberList.get(number));
    }
}
