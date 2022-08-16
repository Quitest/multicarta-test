package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.service.PaymentService;

@Controller
@RequestMapping("/payments")
public class CRUDPaymentsController {
    @Autowired
    private PaymentService service;

    @PostMapping
    public String createPayment() {
        throw new UnsupportedOperationException("POST Пока что не реализовано");
    }

    @GetMapping
    public String readAllPayments(Model model) {
        model.addAttribute("paymentList", service.getAllPayments());
        return "payments/index";
    }

    @PatchMapping
    public String updatePayment() {
        throw new UnsupportedOperationException("Пока что не реализовано");
    }

    @DeleteMapping
    public String deletePayment(@RequestParam("paymentIdForDelete") long id) {
        service.deleteById(id);
        return "redirect:/payments";
    }
}
