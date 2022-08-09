package ru.pel.tests.multicartatest.controller;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.pel.tests.multicartatest.controller.api.ProductController;
import ru.pel.tests.multicartatest.entity.Product;
import ru.pel.tests.multicartatest.service.ProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
public class ProductControllerTest extends TestCase {
    @Autowired
    private MockMvc mockMvc;

    private static Product savedProduct;

    @MockBean
    private ProductService service;

    @BeforeAll
    public static void initProduct(){
        savedProduct = new Product();
        savedProduct.setId(10)
                .setName("патифон");
    }

    @Test
    public void testGetById() throws Exception {

        Mockito.when(service.getById(20)).thenReturn(savedProduct);

        mockMvc.perform(get("/products/20").accept(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.xpath("/Product/name").string("патифон"));
    }
}