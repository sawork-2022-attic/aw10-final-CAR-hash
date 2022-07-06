package com.micropos.product.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.micropos.datatype.product.Product;
import com.micropos.product.repository.MongoDBProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@WebFluxTest(controllers = ProductController.class)
@RunWith(SpringRunner.class)
@Import(MongoTestRepo.class)
class ProductControllerTest {

    @MockBean
    MongoDBProductRepository mongoDBProductRepository;

    List<Product>products;

    @Autowired
    WebTestClient testClient;

    @BeforeEach
    void init(){
        products=new ArrayList<>();
        Product pa=new Product();
        Product pb=new Product();
        Product pc=new Product();
        Product pd=new Product();
        pa.setMongoId("mpa");
        pa.setId("pa");
        pa.setName("productA");
        pa.setPrice("1.1");
        pb.setMongoId("mpb");
        pb.setId("pb");
        pb.setName("productB");
        pb.setPrice("2.3");
        pc.setMongoId("mpc");
        pc.setId("pc");
        pc.setName("productC");
        pc.setPrice("3.4");
        pd.setId("pd");
        pd.setName("tCD");
        pd.setPrice("4.5");

        products.add(pa);
        products.add(pb);
        products.add(pc);
        products.add(pd);

        List<Product> paList=new ArrayList<>();
        paList.add(products.get(0));
        when(mongoDBProductRepository.findAll())
                .thenReturn(products);

        when(mongoDBProductRepository.findProductByProductId("pa"))
                .thenReturn(paList);

    }

    @Test
    void findAllProducts() {
        testClient.get()
                .uri("/product/products")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .equals(products);
    }

    @Test
    void findProductById() {
        List<Product> paList=new ArrayList<>();
        paList.add(products.get(0));
        testClient.get()
                .uri("/product/product/pa")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .equals(paList);
    }

    @Test
    void searchProductByTitle() {
        List<Product> paList=new ArrayList<>();
        paList.add(products.get(0));
        testClient.get()
                .uri("/product/products/search/{title}","A")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .equals(paList);
        List<Product> p=new ArrayList<>();
        p.add(products.get(2));
        p.add(products.get(3));
        testClient.get()
                .uri("/product/products/search/{title}","tC")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .equals(p);
    }

}