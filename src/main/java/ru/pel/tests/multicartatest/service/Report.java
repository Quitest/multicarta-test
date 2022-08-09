package ru.pel.tests.multicartatest.service;

import ru.pel.tests.multicartatest.entity.Product;

import java.util.List;

public interface Report {
    List<Product> lastSales();
}
