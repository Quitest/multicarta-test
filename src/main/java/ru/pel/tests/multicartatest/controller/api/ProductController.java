package ru.pel.tests.multicartatest.controller.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.entity.Product;
import ru.pel.tests.multicartatest.service.ProductService;

import java.util.List;

@SecurityRequirement(name = "basicAuth")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product /*HttpServletRequest request*/) { //FIXME заменить Product -> ProductDto
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }
}
