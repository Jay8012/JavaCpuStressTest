package de.jay8012.exceptions;

public class MussMirNochWasUeberlegenException extends Exception {
    public MussMirNochWasUeberlegenException() {
    }

    public MussMirNochWasUeberlegenException(String message) {
        super(message);
    }

    public MussMirNochWasUeberlegenException(String message, Throwable cause) {
        super(message, cause);
    }

    public MussMirNochWasUeberlegenException(Throwable cause) {
        super(cause);
    }

    public MussMirNochWasUeberlegenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

