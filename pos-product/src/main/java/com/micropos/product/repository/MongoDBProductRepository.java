package com.micropos.product.repository;

import com.micropos.datatype.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface MongoDBProductRepository extends MongoRepository<Product,String> {
    @Query("{id: ?0}")
    List<Product> findProductByProductId(String id);

    //正则表达式匹配
    @Query(value = "{name:{$regex: ?0}}")
    List<Product> searchProductsByTitle(String title);

    @Query(value = "{page: ?0}")
    List<Product> findProductByPage(int page);
}
