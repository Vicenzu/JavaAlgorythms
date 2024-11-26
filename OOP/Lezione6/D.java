package Lezione6;
/*Se creiamo una classe concreta che estende la classe abstract DOBBIAMO inserire il super-costruttore*/
public class D extends Base{

    public D(int v) {
        super(v);
    }

    @Override
    public void m() {

    }
}
