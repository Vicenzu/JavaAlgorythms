package Esercitazione1;

public abstract class VehicleMaintenance implements Maintenance, Vehicle {
    private int km;
    private int kmFromLastMaintenance;
    private int ruote;
    private String marca;
    private String modello;
    private String targa;

    public VehicleMaintenance(int km, int kmFromLastMaintenance, int ruote, String marca, String modello, String targa) {
        this.km = km;
        this.kmFromLastMaintenance = kmFromLastMaintenance;
        this.ruote = ruote;
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
    }

    @Override
    public int getWheels() {
        return 0;
    }

    @Override
    public int getKm() {
        return km;
    }

    public int getKmFromLastMaintenance() {
        return kmFromLastMaintenance;
    }


    @Override
    public String getLicensePlate() {
        return targa;
    }

    @Override
    public int maintenance(){
        System.out.println("Manutenzione");
        this.kmFromLastMaintenance=0;
        return 0;
    }
}

















