package com.springboot.creditcard.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LuhnFormulaTest {

    private LuhnFormula luhnFormula;

    @BeforeEach
    void setUp() {
        luhnFormula = new LuhnFormula();
    }

    @Test
    void shouldReturnTrueForValidNumbers() {
        assertAll(
                () -> assertTrue(luhnFormula.validate("5277029120773860")),
                () -> assertTrue(luhnFormula.validate("4556069096852293")),
                () -> assertTrue(luhnFormula.validate("4852789106979220268")),
                () -> assertTrue(luhnFormula.validate("1358954993914435"))
        );
    }

    @Test
    void shouldReturnFalseForInvalidNumbers() {
        assertAll(
                () -> assertFalse(luhnFormula.validate("4852 7891 0697 922 0261")),
                () -> assertFalse(luhnFormula.validate("3543-6933-8731-4139")),
                () -> assertFalse(luhnFormula.validate("6759310784561226"))
        );
    }
}
