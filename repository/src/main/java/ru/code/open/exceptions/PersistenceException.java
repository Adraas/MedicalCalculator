package ru.code.open.exceptions;

public class PersistenceException extends Exception {

    public PersistenceException(String message, Throwable cause) {
        super("Persistence exception cause: ".concat(message), cause);
    }
}
