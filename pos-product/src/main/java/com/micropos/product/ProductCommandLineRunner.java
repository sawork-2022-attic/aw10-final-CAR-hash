package com.micropos.product;

import com.micropos.datatype.product.Product;
import com.micropos.product.repository.MongoDBProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {
    @Autowired
    MongoDBProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
