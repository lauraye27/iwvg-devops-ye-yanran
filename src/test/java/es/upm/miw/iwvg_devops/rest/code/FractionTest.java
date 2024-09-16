package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1,2);
        assertEquals(0.5, fraction.decimal(), 10e-5);
    }

    @Test
    void testIsProperTrue() {
        Fraction fraction = new Fraction(1,2);
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsProperFalse() {
        Fraction fraction = new Fraction(2,1);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsImproperTrue() {
        Fraction fraction = new Fraction(2, -1);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsImproperFalse() {
        Fraction fraction = new Fraction(-2, -3);
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2,4);

        assertTrue(fraction.isEquivalent(fraction2));
    }

    @Test
    void testAdd() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2,4);

        assertEquals(1.0, fraction.add(fraction2), 10e-5);
    }

    @Test
    void testMultiply() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1,2);

        assertEquals(0.25, fraction.multiply(fraction2), 10e-5);
    }

    @Test
    void testDivide() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1,2);

        assertEquals(1.0, fraction.divide(fraction2), 10e-5);
    }
}
