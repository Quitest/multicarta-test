package ru.pel.tests.multicartatest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.SAXException;

@ControllerAdvice
public class ProductsControllerAdvice {

    @ExceptionHandler(SAXException.class)
    public ResponseEntity<String> incorrectXmlRequest(SAXException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<String> noSuchProduct(NoSuchProductException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getLocalizedMessage());
    }

}
