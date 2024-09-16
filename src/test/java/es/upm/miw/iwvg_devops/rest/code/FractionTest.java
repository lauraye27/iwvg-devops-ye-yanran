package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1,2);
        assertEquals(0.5, fraction.decimal(), 10e-5);
    }
}
