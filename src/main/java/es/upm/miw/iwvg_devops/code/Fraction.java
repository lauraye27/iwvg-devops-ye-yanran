package es.upm.miw.iwvg_devops.code;

public class Fraction {
    private int numerator;
    private int denominator;

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
        double resDenominator = this.denominator * fraction2.getDenominator();
        double firstNumeratorFraction = (resDenominator / this.denominator) * this.numerator;
        double secondNumeratorFraction = (resDenominator / fraction2.getDenominator()) * fraction2.getNumerator();
        double resNumerator = firstNumeratorFraction + secondNumeratorFraction;
        res = resNumerator / resDenominator;
        return res;
    }

    public double multiply(Fraction fraction2) {
        double res;
        double resNumerator = this.numerator * fraction2.getNumerator();
        double resDenominator = this.denominator * fraction2.getDenominator();
        res = resNumerator / resDenominator;
        return res;
    }

    public double divide(Fraction fraction2) {
        double res;
        double resNumerator = this.numerator * fraction2.getDenominator();
        double resDenominator = this.denominator * fraction2.getNumerator();
        res = resNumerator / resDenominator;
        return res;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
