package Lezione7;
//non è possibile fare questa inheritance dato che non possiamo utilizzare tutti i metodi di rettangolo (setters)
//se non mettessimo i setters e le istanze final allora il potremmo dire che un quadrato è un rettangolo
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setBase(double base) {
        super.setBase(base);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }
}
