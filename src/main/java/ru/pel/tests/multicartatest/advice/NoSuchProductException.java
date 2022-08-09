package ru.pel.tests.multicartatest.advice;

import java.util.NoSuchElementException;

public class NoSuchProductException extends NoSuchElementException {
    public NoSuchProductException(String message){
        super(message);
    }
}
