package com.micropos.product;

import com.micropos.product.repository.CacheHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ProductsApplication {

    @Bean
    public CacheHelper cacheHelper(){
        return new CacheHelper();
    }


    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }


}
