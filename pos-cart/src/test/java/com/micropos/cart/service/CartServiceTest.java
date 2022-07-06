package com.micropos.cart.service;

import com.ctc.wstx.shaded.msv_core.util.LightStack;
import com.micropos.cart.client.CartWebClient;
import com.micropos.cart.repository.CartRepository;
import com.micropos.cart.rest.CartController;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.product.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

/*@WebFluxTest(controllers = CartController.class)
@RunWith(SpringRunner.class)
@Import({CartService.class,CartWebClient.class})
class CartServiceTest {

    @MockBean
    CartWebClient client;

    @Autowired
    CartService cartService;

    Product testProduct;
    Cart testCart;

    @MockBean
    CartRepository cartRepository;

    @BeforeEach
    void init(){
        testProduct=new Product();
        testProduct.setId("123-product");
        testProduct.setPrice("12.4");
        testCart=new Cart();
        testCart.setUsrId("myCart");
        when(client.getProduct(Mockito.anyString()))
                .thenReturn(Mono.just(testProduct));
        cartService.registerCart(testCart);
    }
    @Test
    void registerCart() {
        cartService.registerCart(testCart);
        assertEquals(cartService.getCart().getUsrId(),"myCart");
    }

    @Test
    void createAndRegisterCart() {
        cartService.createAndRegisterCart("newCart");
        assertEquals(cartService.getCart().getUsrId(),"newCart");
    }

    @Test
    void addItem() {
        cartService.addItem("123-product",2);
        Item testItem=new Item();
        testItem.setProduct(testProduct);
        testItem.setQuantity(2);
        assertEquals(cartService.getCart().getMerchandises().get(0),testItem);
    }

    @Test
    void delItem() {
        testCart=new Cart();
        testCart.setUsrId("myCart");
        List<Item> merchandises=new ArrayList<>();
        Item testItem=new Item();
        testItem.setProduct(testProduct);
        testItem.setQuantity(2);
        merchandises.add(testItem);
        testCart.setMerchandises(merchandises);
        cartService.registerCart(testCart);

        cartService.delItem("123-product",1);
        assertEquals(cartService.getCart().getMerchandises().get(0).getProduct().getId(),"123-product");
        assertEquals(cartService.getCart().getMerchandises().get(0).getQuantity(),1);

        cartService.delItem("123-product",1);
        assertEquals(cartService.getCart().getMerchandises().size(),0);

        cartService.delItem("123-product",1);
        assertEquals(cartService.getCart().getMerchandises().size(),0);


    }

    @Test
    void clear() {
        testCart=new Cart();
        testCart.setUsrId("myCart");
        List<Item> merchandises=new ArrayList<>();
        Item testItem=new Item();
        testItem.setProduct(testProduct);
        testItem.setQuantity(2);
        merchandises.add(testItem);
        testCart.setMerchandises(merchandises);
        cartService.registerCart(testCart);
        cartService.clear();
        assertEquals(cartService.getCart().getMerchandises().size(),0);
    }

    @Test
    void finish() {
        testCart=new Cart();
        testCart.setUsrId("myCart");
        List<Item> merchandises=new ArrayList<>();
        Item testItem=new Item();
        testItem.setProduct(testProduct);
        testItem.setQuantity(2);
        merchandises.add(testItem);
        testCart.setMerchandises(merchandises);
        cartService.registerCart(testCart);
        cartService.finish();
        assertNull(cartService.getCart());
    }

    @Test
    void getCart() {
        testCart=new Cart();
        testCart.setUsrId("myCart");
        List<Item> merchandises=new ArrayList<>();
        Item testItem=new Item();
        testItem.setProduct(testProduct);
        testItem.setQuantity(2);
        merchandises.add(testItem);
        testCart.setMerchandises(merchandises);
        cartService.registerCart(testCart);
        assertEquals(cartService.getCart(),testCart);
    }
}*/