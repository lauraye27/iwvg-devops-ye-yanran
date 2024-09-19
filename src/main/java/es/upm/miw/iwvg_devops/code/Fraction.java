package es.upm.miw.iwvg_devops.code;

import java.util.Comparator;
import java.util.List;

public class Fraction {
    private int numerator;
    private int denominator;
    private static final String DIVISION_BY_ZERO_ERROR = "Indeterminate: division by 0";

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    // Fraction proper: located in the interval [0,1)
    public boolean isProper() {
        if(this.denominator == 0) return false;
        return Math.abs(this.numerator) < Math.abs(this.denominator);
    }

    public boolean isImproper() {
        return !isProper();
    }

    public boolean isEquivalent(Fraction fraction2) {
        return (this.numerator * fraction2.getDenominator()) == (this.denominator * fraction2.getNumerator());
    }

    public double add(Fraction fraction2) {
        double res;
        double resDenominator = this.denominator * (double) fraction2.getDenominator();

        if (resDenominator == 0) {
            throw new ArithmeticException(DIVISION_BY_ZERO_ERROR);
        }

        double firstNumeratorFraction = (resDenominator / this.denominator) * this.numerator;
        double secondNumeratorFraction = (resDenominator / fraction2.getDenominator()) * fraction2.getNumerator();
        double resNumerator = firstNumeratorFraction + secondNumeratorFraction;
        res = resNumerator / resDenominator;
        return res;
    }

    public double multiply(Fraction fraction2) {
        double res;
        double resNumerator = this.numerator * (double) fraction2.getNumerator();
        double resDenominator = this.denominator * (double) fraction2.getDenominator();

        if (resDenominator == 0) {
            throw new ArithmeticException(DIVISION_BY_ZERO_ERROR);
        }

        res = resNumerator / resDenominator;
        return res;
    }

    public double divide(Fraction fraction2) {
        double res;
        double resNumerator = this.numerator * (double) fraction2.getDenominator();
        double resDenominator = this.denominator * (double) fraction2.getNumerator();

        if (resDenominator == 0) {
            throw new ArithmeticException(DIVISION_BY_ZERO_ERROR);
        }

        res = resNumerator / resDenominator;
        return res;
    }

    public List<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal)
                .toList();
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.getDenominator() != 0)
                .max(Comparator.comparingDouble(Fraction::decimal))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
