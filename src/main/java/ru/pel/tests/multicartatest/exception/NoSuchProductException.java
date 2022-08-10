package ru.pel.tests.multicartatest.exception;

import java.util.NoSuchElementException;

public class NoSuchProductException extends NoSuchElementException {
    public NoSuchProductException(String message){
        super(message);
    }
}
