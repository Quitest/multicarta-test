package ru.pel.tests.multicartatest.service;

import org.springframework.stereotype.Service;
import ru.pel.tests.multicartatest.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product product);
}
