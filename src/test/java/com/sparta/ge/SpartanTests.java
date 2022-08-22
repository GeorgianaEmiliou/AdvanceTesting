package com.sparta.ge;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Objects;

public class SpartanTests {

    //Hooks - Block of repeated code
    //BeforeAll - runs a block of code before all tests,
    // BeforeEach - runs a block of code before each test,
    // AfterAll, AfterEach
    //setup - tearDown

    private Spartan spartan;

    @BeforeAll
    static void initAll(TestInfo testInfo){
        System.out.println(testInfo.getTestClass() + " has started");
    }

    @BeforeEach
    void init(TestInfo testInfo){
        spartan = new Spartan(11, "Manish", "Java", LocalDate.of(2022, 12, 12));
        System.out.println(testInfo.getDisplayName() + " executing");
    }

    @Test
    //@Disabled("Waiting for Manish to finish his method") //comment out the test - do not run it for the moment
    /*@DisabledIf(value = "checkForSpartan",
            disabledReason = "Code has not been completed yet")*/
    @DisplayName("Check that the Spartan is called Manish")
    void checkThatTheSpartanIsCalledManish(){
        Assertions.assertEquals("Manish", spartan.getName());
    }


    @ParameterizedTest(name = "{index} of {argumentsWithNames}")
    @ValueSource(ints = {1, 20, 30, 5, 7, 15})
    @DisplayName("Check that the id is between 10 and 10000")
    void checkTheSpartanId(int num){
        Assertions.assertTrue(num >= 10 && num <=10000);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "spartans.csv")
    //@NullAndEmptySource
    @DisplayName("Using CSV source for test")
    void runCSVTests(int id){
        Assertions.assertTrue(id >=10 && id <=10000);
    }

    /*@ParameterizedTest
    @CsvFileSource(resources = "spartans.csv")
    //@NullAndEmptySource
    @DisplayName("Using CSV source for test")
    void runCSVTests(String course){
        Assertions.assertTrue(course == "Java" || course == "C#")
                || course == "Data" || course == "DevOps" || Objects.equals(spartan.getCourse(), "Cyber-Security")
                || Objects.equals(spartan.getCourse(), "Business"));
    }*/



    @Test
    @DisplayName("Check the course of the Spartan")
    void checkTheSpartanCourse(){
        Assertions.assertTrue(Objects.equals(spartan.getCourse(), "Java") || Objects.equals(spartan.getCourse(), "C#")
        || Objects.equals(spartan.getCourse(), "Data") || Objects.equals(spartan.getCourse(), "DevOps") || Objects.equals(spartan.getCourse(), "Cyber-Security")
        || Objects.equals(spartan.getCourse(), "Business"));
    }

    boolean checkForSpartan(){
        return true;
    }

    @Tag("valueCheck")
   /* @RepeatedTest(value = 2,
            name = "{displayName} is running test {currentRepetition}")*/
    @DisplayName("Check that the id is a positive number")
    void checkThatTheIdIsAPositiveNumber(){
        //if fails the test will get ignored
        //if it passes, it continues to the assertion
        Assumptions.assumeTrue(spartan.getId() == 12);
        Assertions.assertTrue(spartan.getId() >= 0);
    }

    /*@Nested
    @DisplayName("Nested Tests")
    class NestedTests{
        @Test
        @DisplayName("Nested example"){
            void nestedExample(){

            }
        }
    }*/



    @AfterEach
    void tearDown(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName() + " completed");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo){
        System.out.println(testInfo.getTestClass() + " has finished");
    }
}
