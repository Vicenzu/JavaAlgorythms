package Esercitazione3;

public class InvalidUserIdException extends IllegalArgumentException {
    public InvalidUserIdException(String message) {
        super(message);
    }
}