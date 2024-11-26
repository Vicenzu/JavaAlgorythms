package Esercitazione1;

public interface Maintenance {
    int nextMaintenance();
    int maintenance();

    static boolean eseguiManutenzioneLista(Maintenance[] list){
        for (Maintenance maintenance : list) {
            maintenance.maintenance();
        }
        return true;
    }
 }













