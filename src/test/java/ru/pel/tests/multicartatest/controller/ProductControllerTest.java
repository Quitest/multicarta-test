package ru.pel.tests.multicartatest.controller;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.pel.tests.multicartatest.entity.Product;
import ru.pel.tests.multicartatest.service.ProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
public class ProductControllerTest extends TestCase {
    @Autowired
    private MockMvc mockMvc;

    private static Product product;

    @MockBean
    private ProductService service;

    @BeforeAll
    public static void initProduct(){
        product = new Product();
        product
                .setId(20)
                .setName("патифон");
    }

    @Test
    @DisplayName("Получение продукта по ID")
    public void testGetById() throws Exception {

        Mockito.when(service.getById(20)).thenReturn(product);

        mockMvc.perform(get("/products/20").accept(MediaType.APPLICATION_XML))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.xpath("/Product/name").string("патифон"));
    }
}