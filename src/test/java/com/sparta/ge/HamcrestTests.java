package com.sparta.ge;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class HamcrestTests {

    private Spartan spartan;

    @BeforeEach
    void setup(){
        spartan = new Spartan(1, "David", "Data", LocalDate.of(2022, 12, 12));
    }

    @Test
    @DisplayName("Check Spartan is called Manish")
    void checkSpartanIsCalledManish(){
        MatcherAssert.assertThat(spartan.getName(), Matchers.equalTo("Manish"));
    }

    @Test
    @DisplayName("Check that sparta has an id field")
    void checkThatSpartaHasAnIdField(){
        MatcherAssert.assertThat(spartan, Matchers.hasProperty("id", Matchers.equalTo(1)));
    }

    /*@Test
    @DisplayName("Hamcrest String methods")
    void hamcrestStringMethods(){
        MatcherAssert.assertThat(spartan.getName(), Matcher);
    }*/
}
