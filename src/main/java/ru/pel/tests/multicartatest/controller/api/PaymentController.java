package ru.pel.tests.multicartatest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(service.getAllPayments());
    }

    @PostMapping
    public ResponseEntity<Payment> doPayment(
            @RequestBody
            Payment payment) { //FIXME заменить entity на DTO
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.savePayment(payment));
    }
}
