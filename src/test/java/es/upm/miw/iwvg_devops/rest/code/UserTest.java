package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        user = new User("001", "Laura", "Ye", new ArrayList<>());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction(1,2);
        user.addFraction(fraction);
        List<Fraction> fractions = user.getFractions();

        assertEquals(1, fractions.size());
        assertEquals(fraction, fractions.get(0));
    }

    @Test
    void testFullName() {
        assertEquals("Laura Ye", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("L.", user.initials());
    }

    @Test
    void testFindUserNameBySomeImproperFraction() {
        assertEquals(List.of("Oscar", "Ana", "Paula"), new User().findUserNameBySomeImproperFraction());
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5"), new User().findUserIdBySomeProperFraction());
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(1,2);
        user.addFraction(fraction);
        String expected = "User{id='001', name='Laura', familyName='Ye', fractions=[Fraction{numerator=1, denominator=2}]}";

        assertEquals(expected, user.toString());
    }
}
