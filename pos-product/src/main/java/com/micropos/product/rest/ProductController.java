package com.micropos.product.rest;

import com.ctc.wstx.shaded.msv_core.driver.textui.Debug;
import com.micropos.datatype.product.Product;
import com.micropos.product.repository.MongoDBProductRepository;
import com.micropos.product.utility.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController{

    @Autowired
    MongoDBProductRepository mongoDBProductRepository;


    //reactive api
    @GetMapping("/products")
    public Flux<Product> findAllProducts() {
        return Flux.fromIterable(mongoDBProductRepository.findAll());

    }

    @GetMapping("/product/{id}")
    public Mono<Product> findProductById(@PathVariable String id){
        List<Product> products=mongoDBProductRepository.findProductByProductId(id);
        if(products.isEmpty()){
            throw new ProductNotFoundException("Product "+id+" Not Found.");
        }
        return Mono.just(products.get(0));
    }

    @GetMapping("/products/{page}")
    public Flux<Product> findProductsByPage(@PathVariable int page){
        return Flux.fromIterable(mongoDBProductRepository.findProductByPage(page));
    }

    @GetMapping("/products/search/{title}")
    public Flux<Product> searchProductByTitle(@PathVariable String title){
        List<Product> products=mongoDBProductRepository.searchProductsByTitle(title);
        System.out.println(products.size());
        for (Product p:
             products) {
            System.out.println(p);
        }
        return Flux.fromIterable(products);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public void onProductNotFound(ProductNotFoundException e){
        System.out.println(e.getMessage());
    }

}
