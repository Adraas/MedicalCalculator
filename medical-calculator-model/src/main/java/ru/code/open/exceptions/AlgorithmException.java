package ru.code.open.exceptions;

public class AlgorithmException extends Exception {

    public AlgorithmException(String message) {
        super("Algorithm exception cause: ".concat(message));
    }
}
