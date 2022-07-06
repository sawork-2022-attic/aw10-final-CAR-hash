package com.micro.delivery.handler;

import com.micro.delivery.repository.CartRepository;
import com.micro.delivery.repository.DeliveryRepository;
import com.micro.delivery.router.DeliveryRouter;
import com.micro.delivery.service.DeliveryService;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import com.micropos.datatype.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.loadbalancer.core.LoadBalancerServiceInstanceCookieTransformer;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

/*@WebFluxTest(controllers = DeliveryRouter.class)
@RunWith(SpringRunner.class)
@Import({TestCartRepo.class,TestDeliveryRepo.class, DeliveryService.class,DeliveryHandler.class})
class DeliveryHandlerTest {

    @Autowired
    WebTestClient testClient;

    Cart testCart;

    List<Product> products;
    Order testOrder;
    List<Item> merchandises;

    @MockBean
    CartRepository cartRepository;

    @MockBean
    DeliveryRepository deliveryRepository;

    @BeforeEach
    void init(){
        testCart=new Cart();
        testCart.setId("123-cart");
        testCart.setUsrId("myCart");
        merchandises=new ArrayList<>();
        products=new ArrayList<>();
        Product pa=new Product();
        Product pb=new Product();
        Product pc=new Product();
        Product pd=new Product();
        pa.setMongoId("mpa");
        pa.setId("pa");
        pa.setName("productA");
        pa.setPrice("1.1");
        pb.setMongoId("mpb");
        pb.setId("pb");
        pb.setName("productB");
        pb.setPrice("2.3");
        pc.setMongoId("mpc");
        pc.setId("pc");
        pc.setName("productC");
        pc.setPrice("3.4");
        pd.setId("pd");
        pd.setName("tCD");
        pd.setPrice("4.5");
        products.add(pa);
        products.add(pb);
        products.add(pc);
        products.add(pd);

        Item ia=new Item();
        ia.setProduct(pa);
        ia.setQuantity(1);
        Item ib=new Item();
        ib.setProduct(pb);
        ib.setQuantity(2);
        Item ic=new Item();
        ic.setProduct(pc);
        ic.setQuantity(3);
        Item id=new Item();
        id.setProduct(pd);
        id.setQuantity(4);
        merchandises.add(ia);
        merchandises.add(ib);
        merchandises.add(ic);
        merchandises.add(id);
        testCart.setMerchandises(merchandises);
        testCart.setUsrId("testUsr");
        when(cartRepository.findById(Mockito.anyString()))
                .thenReturn(Mono.just(testCart));
        testOrder=new Order(testCart);
        List<Order> testOrders=new ArrayList<>();
        testOrders.add(testOrder);
        when(deliveryRepository.findByUsrId("testUsr"))
                .thenReturn(testOrders);
    }

    @Test
    void checkout() {
        testClient.post()
                .uri("/delivery/checkout")
                .header("id","123-cart")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void listOrders() {
        List<Order> testOrders=new ArrayList<>();
        testOrders.add(testOrder);
        testClient.get()
                .uri("/delivery/list/{id}","testUsr")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .equals(testOrders);
    }
}*/