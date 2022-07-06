package com.micropos.cart.repository;

import com.micropos.datatype.cart.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.integration.annotation.Reactive;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
    @Query("{usrId:  ?0}")
    public Cart findCartByUsrId(String usrId);
}
