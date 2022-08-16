package ru.pel.tests.multicartatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.entity.Product;
import ru.pel.tests.multicartatest.exception.NoSuchProductException;
import ru.pel.tests.multicartatest.repository.PaymentsRepository;
import ru.pel.tests.multicartatest.repository.ProductsRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Payment savePayment(Payment payment) {
        String name = payment.getPurchaseItem().getName();
        Product product = productsRepository.findByName(name)
                .orElseThrow(() -> new NoSuchProductException(
                        String.format("Продукта %s в магазине нет.", payment.getPurchaseItem().getName())));
        product.addPayment(payment);
        payment.setPurchaseItem(product);
        return paymentsRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        Payment payment = paymentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
        paymentsRepository.delete(payment);
    }

    @Override
    public Payment getById(long id) {
        return paymentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
    }
}
