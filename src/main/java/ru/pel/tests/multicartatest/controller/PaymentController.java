package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(service.getAllPayments());
    }
}
