package Esercitazione1;

public class Camion extends VehicleMaintenance {
    boolean rimorchio;
    public Camion(boolean rimorchio,int km, int kmFromLastMaintenance, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastMaintenance, ruote, marca, modello, targa);
        this.rimorchio=rimorchio;

    }

    public boolean getRimorchio() {
        return rimorchio;
    }

    public int nextMaintenance() {
        return 5000-super.getKmFromLastMaintenance();
    }

    @Override
    public int maintenance(){
       super.maintenance();
       //if(rimorchio){
           //paga di più

       //}

        return 0;
    }
}
