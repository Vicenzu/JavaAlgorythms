package Esercitazione7;

public enum Taglio {
    CENTESIMO(0.01f),
    DUECENTS(0.02f),
    CINQUECENTS(0.05f),
    DIECICENTS(0.10f),
    VENTICENTS(0.20f),
    CINQUANTACENTS(0.50f),
    EURO(1f),
    DUEEURO(2f),
    CINQUEEURO(5f),
    DIECIEURO(10f),
    VENTIEURO(20f),
    CINQUANTAEURO(50f),
    CENTOEURO(100f),
    DUECENTOEURO(200f);

    private final float valore;

    Taglio(float v) {
        this.valore = v;
    }

    public float getValore() {
        return this.valore;
    }

    public static boolean isTaglioValue(float fl) {
        for (Taglio t : Taglio.values()) {
            if (Float.compare(t.valore, fl) == 0)
                return true;
        }
        return false;
    }
}
