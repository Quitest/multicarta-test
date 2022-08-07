package ru.pel.tests.multicartatest.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pel.tests.multicartatest.entity.Payment;

public class PaymentRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Payment.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //https://www.baeldung.com/spring-data-rest-validators

    }
}
