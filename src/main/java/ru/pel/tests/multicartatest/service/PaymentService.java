package ru.pel.tests.multicartatest.service;

import org.springframework.stereotype.Service;
import ru.pel.tests.multicartatest.entity.Payment;

import java.util.List;

@Service
public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
}
