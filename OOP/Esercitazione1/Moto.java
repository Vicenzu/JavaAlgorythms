package Esercitazione1;

public class Moto extends VehicleMaintenance {
    private int cilindrata;

    public Moto(int cilindrata,int km, int kmFromLastMaintenance, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastMaintenance, ruote, marca, modello, targa);
        this.cilindrata=cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String details() {
        return super.details();
    }

    @Override
    public int nextMaintenance() {
        int manutenzione=500;

        return manutenzione-super.getKmFromLastMaintenance();
    }
    @Override
    public int maintenance(){
        super.maintenance();
        System.out.println("Manutenzione Moto");
        System.out.println("Cambio Freni, Catena, Forcella...");
        return 0;
    }
}
