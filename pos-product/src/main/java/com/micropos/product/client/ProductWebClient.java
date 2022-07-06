package com.micropos.product.client;

import com.micropos.datatype.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ProductWebClient {

    @Autowired
    Environment environment;

    WebClient client=WebClient.create("http://localhost:"+environment.getProperty("server.port"));



}
