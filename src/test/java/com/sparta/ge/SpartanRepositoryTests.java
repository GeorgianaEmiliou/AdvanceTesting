package com.sparta.ge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SpartanRepositoryTests {

    private Spartan mockSpartan;
    private Spartan spySpartan;
    private Spartan spartan;

    @BeforeEach
    void init(){
        mockSpartan = Mockito.mock(Spartan.class);
        spartan = new Spartan(1, "Manish", "Java", LocalDate.now());
        spySpartan = Mockito.spy(spartan); //partial mock
    }

    @Test
    @DisplayName("Testing Spartan Repository Print Method")
    void testingSpartan(){
        SpartanRepository.addSpartan(mockSpartan);
        Mockito.when(mockSpartan.toString()).thenReturn("Found Mock Spartan");
        Mockito.doReturn("Found Mock Spartan").when(mockSpartan.toString());
        Mockito.doThrow(NullPointerException.class).when(mockSpartan).setId(Mockito.anyInt());
        //System.out.println(SpartanRepository.getAllSpartans());
        Assertions.assertEquals("Found Mock Spartan" + "\n", SpartanRepository.getAllSpartans());
    }

    @Test
    @DisplayName("Testing method order")
    void testingMethodOrder(){
        Mockito.when(mockSpartan.getStartDate())
                .thenReturn(LocalDate.now())
                .thenReturn(LocalDate.MAX);

        System.out.println(mockSpartan.getStartDate());
        System.out.println(mockSpartan.getStartDate());
    }

}
