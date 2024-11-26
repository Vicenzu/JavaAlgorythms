package Lezione18;

public record Monomial(double coefficient, int degree) implements Comparable<Monomial> {

    public Monomial {
        if (degree<0) throw new RuntimeException();
    }

    @Override
    public int compareTo(Monomial m) {
        return degree-m.degree;
    }

    public Monomial sum (Monomial m) {
        if (m.degree != degree)
            throw new RuntimeException();
        return new Monomial(coefficient+m.coefficient, degree);
    }

    public Monomial mul(Monomial m) {
        return new Monomial(m.coefficient*coefficient, m.degree+degree);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (coefficient<0)
            sb.append("-");
        if (Math.abs(coefficient) != 1 || degree == 0)
            sb.append(Math.abs(coefficient));

        if (degree>0)
            sb.append("x");

        if (degree > 1)
            sb.append("^").append(degree);

        return sb.toString();
    }


}
