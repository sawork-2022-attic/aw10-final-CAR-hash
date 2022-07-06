package com.micropos.dataloader;

import com.micropos.datatype.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    public static final AtomicInteger productCounter =new AtomicInteger(0);
}
