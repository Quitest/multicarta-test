package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.service.PaymentService;
import ru.pel.tests.multicartatest.service.ProductService;

@Controller
@RequestMapping("/payments")
public class CRUDPaymentsController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ProductService productService;

    @PostMapping
    public String createPayment(Payment createdPayment) { //FIXME заменить на DTO
        paymentService.savePayment(createdPayment);
        return "redirect:/payments";
    }

    @GetMapping("/create")
    public String newPayment(@ModelAttribute("newPayment") Payment newpayment, Model model){ //FIXME заменить на DTO
        model.addAttribute("productList", productService.getAllProducts());
        return "payments/new-payment";
    }

    @GetMapping
    public String readAllPayments(Model model) {
        model.addAttribute("paymentList", paymentService.getAllPayments());
        return "payments/index";
    }

    @PatchMapping
    public String updatePayment() {
        throw new UnsupportedOperationException("Пока что не реализовано");
    }

    @DeleteMapping
    public String deletePayment(@RequestParam("paymentIdForDelete") long id) {
        paymentService.deleteById(id);
        return "redirect:/payments";
    }
}
