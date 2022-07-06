package com.micro.delivery.router;

import com.micro.delivery.handler.DeliveryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class DeliveryRouter {

    @Bean
    public RouterFunction<ServerResponse> route(DeliveryHandler deliveryHandler) {
        String prefix = "/delivery";
        return RouterFunctions
                .route(POST(prefix +"/checkout").and(accept(APPLICATION_JSON)), deliveryHandler::checkout)
                .andRoute(GET(prefix +"/list/{id}").and(accept(APPLICATION_JSON)), deliveryHandler::listOrders);
    }
}
