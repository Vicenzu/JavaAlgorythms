package Esercitazione2;

public abstract class Document{
    private String text, name, signatureName;
    private int signatureCode;

    //Signed
    public Document(String text, String name, String signName, int signCode) {
        this.text = text;
        this.name = name;
        this.signatureName = signName;
        this.signatureCode = signCode;
    }

    //Not Signed
    public Document(String text, String name) {
        this.text = text;
        this.name = name;
    }

    protected abstract boolean checkSign(); //verifica solo se il documento è firmato correttamente

    public boolean isSigned() {
        return signatureCode != 0 && signatureName != null;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public int getSignatureCode() {
        return signatureCode;
    }
}
