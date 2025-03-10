package Esercitazione7;

public enum Taglio {
    ONE_CENT(0.01),
    TWO_CENTS(0.02),
    FIVE_CENTS(0.05),
    TEN_CENTS(0.10),
    TWENTY_CENTS(0.20),
    FIFTY_CENTS(0.50),
    ONE_EURO(1.00),
    TWO_EUROS(2.00),

    // Banconote in euro
    FIVE_EUROS(5.00),
    TEN_EUROS(10.00),
    TWENTY_EUROS(20.00),
    FIFTY_EUROS(50.00),
    ONE_HUNDRED_EUROS(100.00),
    TWO_HUNDRED_EUROS(200.00),
    FIVE_HUNDRED_EUROS(500.00);

    private final double value;

    Taglio(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static Taglio isValue(double value) {
        for (Taglio taglio : Taglio.values()) {
            if (Double.compare(taglio.getValue(),value) == 0) {
                return taglio;
            }
        }
        return null;
    }

}