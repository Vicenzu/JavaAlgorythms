package Esercitazione1;

import java.util.Vector;

public interface Vehicle {
    default String details(){
        return ""+getKm()+" KM Plate:"+getLicensePlate();}
    int getWheels();
    int getKm();
    String getLicensePlate();

}

