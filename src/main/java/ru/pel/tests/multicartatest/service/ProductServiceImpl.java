package ru.pel.tests.multicartatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pel.tests.multicartatest.entity.Product;
import ru.pel.tests.multicartatest.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductsRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getById(long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }


}
