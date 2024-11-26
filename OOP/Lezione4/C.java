package Lezione4;

//INHERITANCE

public class C extends SC{
    private int subValue;

    public C() {
        super(0);
    }

    public C(int v, int sv) {
        super(v);
        this.subValue = sv;
    }
}
