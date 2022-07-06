package com.micro.delivery.service;

import com.micro.delivery.repository.CartRepository;
import com.micro.delivery.repository.DeliveryRepository;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.MongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DeliveryService {


    private final CartRepository cartRepository;

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(CartRepository cartRepository,DeliveryRepository deliveryRepository){
        this.cartRepository=cartRepository;
        this.deliveryRepository=deliveryRepository;
    }

    public Mono<Void> checkoutCart(String cartId){
        cartRepository.findById(cartId)
                .subscribe(
                        cart->{
                            System.out.println(1);
                            Order order=new Order(cart);
                            deliveryRepository.save(order);
                        }
                );
        return Mono.empty();
    }

    public List<Order> listOrders(String usrId){
        List<Order> orders=deliveryRepository.findByUsrId(usrId);
        return orders;
    }


}
