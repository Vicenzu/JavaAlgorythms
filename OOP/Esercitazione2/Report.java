package Esercitazione2;

public class Report extends Document implements PrintDoc{
    private String destinatario;
    private String[] parametri;
    private boolean[] raggiunti;

    public Report(String text, String name, String signName, int signCode, String destinatario, String[] parametri, boolean[] raggiunti) {
        super(text, name, signName, signCode);
        this.destinatario = destinatario;
        this.parametri = parametri;
        this.raggiunti = raggiunti;
    }


    @Override
    protected boolean checkSign() {
        return super.isSigned() && getName().equals(getSignatureName()) && getSignatureCode() > 0;
    }

    @Override
    public void printDoc() {
        System.out.println("Printed");
    }
}
