package com.micropos.cart.client;

import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Order;
import com.micropos.datatype.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CartWebClient {

    @Autowired
    Environment env;


    private WebClient cartClient;

    public CartWebClient(){
        cartClient=WebClient.builder().build();
    }

    public Flux<Product> getProducts(){
        return cartClient
                .get()
                .uri(env.getProperty("product.server")+env.getProperty("product.getProducts"))
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Product> getProduct(String productId){
        return cartClient
                .get()
                .uri(env.getProperty("product.server")+env.getProperty("product.getProduct")+productId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Product.class);
    }

    public Mono<Order> checkOut(Cart cart){
        return cartClient
                .post()
                .uri("http://localhost:8083/delivery/checkout")
                .header("id",cart.getId())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Order.class);
    }
}
