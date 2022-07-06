package com.micro.delivery.repository;

import com.micropos.datatype.cart.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface CartRepository extends ReactiveMongoRepository<Cart,String> {
}
