package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testGetNumerator() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(1, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction(1, 2);
        fraction.setNumerator(10);

        assertEquals(10, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction(1, 2);
        fraction.setDenominator(10);

        assertEquals(10, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1,2);
        assertEquals(0.5, fraction.decimal(), 10e-5);
    }

    @Test
    void testDecimalForNegativeFraction() {
        Fraction fraction = new Fraction(-1, 2);
        assertEquals(-0.5, fraction.decimal(), 10e-5);
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
    void testIsEquivalentNegative() {
        Fraction fraction = new Fraction(-1, 2);
        Fraction fraction2 = new Fraction(-2, 4);

        assertTrue(fraction.isEquivalent(fraction2));
    }

    @Test
    void testIsEquivalentFalse() {
        Fraction fraction = new Fraction(1, 3);
        Fraction fraction2 = new Fraction(2, 3);

        assertFalse(fraction.isEquivalent(fraction2));
    }

    @Test
    void testAdd() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2,4);

        assertEquals(1.0, fraction.add(fraction2), 10e-5);
    }

    @Test
    void testAddByZero() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 0);

        assertThrows(ArithmeticException.class, () -> fraction.add(fraction2));
    }

    @Test
    void testMultiply() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1,2);

        assertEquals(0.25, fraction.multiply(fraction2), 10e-5);
    }

    @Test
    void testMultiplyByZero() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 0);

        assertThrows(ArithmeticException.class, () -> fraction.multiply(fraction2));
    }

    @Test
    void testDivide() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1,2);

        assertEquals(1.0, fraction.divide(fraction2), 10e-5);
    }

    @Test
    void testDivideByZero() {
        Fraction fraction = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(0,2);

        assertThrows(ArithmeticException.class, () -> fraction.divide(fraction2));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        assertEquals(List.of(0.0, -0.0, 0.0), new Fraction().findDecimalFractionByUserName("Antonio"));
    }

    @Test
    void testFindHighestFraction() {
        Fraction expected = new Fraction(2, 1);
        Fraction actual = new Fraction().findHighestFraction();

        assertEquals(expected.getNumerator(), actual.getNumerator());
        assertEquals(expected.getDenominator(), actual.getDenominator());
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(1, 2);
        String expected = "Fraction{numerator=1, denominator=2}";

        assertEquals(expected, fraction.toString());
    }
}
