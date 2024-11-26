package Esercitazione1;

public class Macchina extends VehicleMaintenance {
    private int posti;

    public Macchina(int posti,int km, int kmFromLastMaintenance, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastMaintenance, ruote, marca, modello, targa);
        this.posti=posti;
    }

    @Override
    public int nextMaintenance() {
        return 1000-super.getKmFromLastMaintenance();
    }

    @Override
    public int maintenance() {
        super.maintenance();
        System.out.println("Manutenzione Macchina");
        System.out.println("Cambio Freni, Radiatore, Olio...");

        return 0;
    }

    public int getPosti() {
        return posti;
    }
}
