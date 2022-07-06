package com.micro.delivery.handler;

import com.micro.delivery.service.DeliveryService;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class DeliveryHandler {
    @Autowired
    DeliveryService deliveryService;

    public Mono<ServerResponse> checkout(ServerRequest request){
        System.out.println("got it");
        return ok()
                .build(deliveryService.checkoutCart(request.headers().header("id").get(0)));
    }

    public Mono<ServerResponse> listOrders(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(deliveryService.listOrders(request.pathVariable("id")));
    }

}
