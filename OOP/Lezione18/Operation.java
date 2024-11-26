package Lezione18;

public enum Operation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("x") {
        //METODI SPECIFICI PER OGNI ISTANZA
        @Override
        double apply(double x, double y) {
            return x*y;
        }

        @Override
        public String getSymbol() {
            return "x";
        }
    },
    DIVIDE("/"){
        @Override
        double apply(double x, double y) {
            return x/y;
        }
    };
    private final String symbol;
    abstract double apply(double x, double y);


    //METODI COMUNI A TUTTE LE ISTANZE
    Operation (String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
