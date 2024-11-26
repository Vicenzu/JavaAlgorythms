package Lezione14;
//Classe di una coppia di elementi, di cui non conosco il tipo, quindi ne indico uno generico T che prende in input
// una classe. Se volessimo utilizzare solo oggetti che possono essere comparati, bisogna mettere <T extends Comparable>
// sennò scriveremo solo <T>
public class Coppia <T> {
    private T elem1;
    private T elem2;

    public Coppia() {
        elem1 = null;
        elem2 = null;
    }

    public String toString() {
        return "Elem1: " + elem1 + ", Elem2: " + elem2;
    }

    public T getElem1() {
        return elem1;
    }

    public void setElem1(T elem1) {
        this.elem1 = elem1;
    }

    public T getElem2() {
        return elem2;
    }

    public void setElem2(T elem2) {
        this.elem2 = elem2;
    }

    //Nei metodi statici dobbiamo indicare che stiamo utilizzando un oggetto generico <T>. In più aggiungiamo
    // "extends Comparable" per poter utilizzare il compareTo
    public static <T extends Comparable<T>> Coppia<T> minMax(T[] a) {
        if (a == null || a.length == 0)
            return null;
        
        Coppia<T> res = new Coppia<>();
        res.setElem1(a[0]);
        res.setElem2(a[0]);

        for (int i=1; i<a.length; i++) {
            if (a[i].compareTo(res.getElem2()) > 0) 
                res.setElem2(a[i]);
            else if (a[i].compareTo(res.getElem1()) < 0)
                res.setElem1(a[i]);
        }

        return res;
    }

    

}
