package Esercitazione2;

public class Letter extends Document implements PrintDoc {
    private String mittente;
    private String destinatario;

    public Letter(String text, String name, String signName, int signCode, String mittente, String destinatario) {
        super(text, name, signName, signCode);
        this.mittente = mittente;
        this.destinatario = destinatario;
    }


    @Override
    protected boolean checkSign() {
        return super.isSigned() &&  getSignatureName().equals(mittente) && getSignatureCode() > 0;
    }

    @Override
    public void printDoc() {
        System.out.println("Printed");
    }
}
