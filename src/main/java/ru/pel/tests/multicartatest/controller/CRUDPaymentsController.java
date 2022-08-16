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

    @GetMapping("/update")
    public String getOldPayment(Model model, @RequestParam("paymentIdForEdit") long id) {
        model.addAttribute("payment", paymentService.getById(id));
        model.addAttribute("productList", productService.getAllProducts());
        return "payments/update-payment";
    }

    @PutMapping
    public String updatePayment(@RequestParam("updateId") long id, Payment payment){
        //TODO рассмотреть возможность использования ModelMapper'а для избавления от этой лапши, а также перейти на DTO в параметрах
        Payment savedPayment = paymentService.getById(id);
        savedPayment.setPurchaseItem(payment.getPurchaseItem());
        savedPayment.setAge(payment.getAge());
        savedPayment.setCount(payment.getCount());
        savedPayment.setAmount(payment.getAmount());
        savedPayment.setName(payment.getName());
        savedPayment.setLastname(payment.getLastname());
        savedPayment.setPurchaseDate(payment.getPurchaseDate());
        paymentService.savePayment(savedPayment);
        return "redirect:/payments";
    }

    @DeleteMapping
    public String deletePayment(@RequestParam("paymentIdForDelete") long id) {
        paymentService.deleteById(id);
        return "redirect:/payments";
    }
}
