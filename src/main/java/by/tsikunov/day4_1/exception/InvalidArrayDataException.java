package by.tsikunov.day4_1.exception;

public class InvalidArrayDataException extends Exception {
    public InvalidArrayDataException() {}
    public InvalidArrayDataException(String message) {
        super(message);
    }
    public InvalidArrayDataException(String message, Throwable e) {
        super(message, e);
    }
    public InvalidArrayDataException(Throwable e) {
        super(e);
    }
}
