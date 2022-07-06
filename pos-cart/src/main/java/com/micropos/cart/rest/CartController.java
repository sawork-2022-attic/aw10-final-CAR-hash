package com.micropos.cart.rest;

import com.micropos.cart.repository.CartRepository;
import com.micropos.cart.service.ICartService;
import com.micropos.cart.utilities.CartDuplicateException;
import com.micropos.cart.utilities.CartNotFoundException;
import com.micropos.cart.utilities.CartNotRegisteredException;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cart")
public class CartController{

    @Autowired
    ICartService cartService;

    @Autowired
    CartRepository cartRepository;

    /**
     * @param usrId
     * @return 返回生成的cart编号，若已经存在cart则抛出NotFound异常
     */
    @PostMapping("/create/{usrId}")
    Mono<String> createCartByUserName(@PathVariable String usrId){
        System.out.println(">");
        String cid="";
        try{
            cid=cartService.createAndRegisterCart(usrId);
        }catch (CartDuplicateException e){
            System.out.println(e);
            return Mono.error(e);
        }
        return Mono.just(cid);
    }

    @PostMapping("/select/usr/{usrId}")
    Mono<String> setExistingCartByUserName(@PathVariable String usrId){
        Cart c=cartRepository.findCartByUsrId(usrId);
        if(c==null){
            return Mono.error(new CartNotFoundException());
        }
        cartService.registerCart(c);
        return Mono.just(c.getId());
    }

    @PostMapping("/select/cart/{cartId}")
    boolean selectCartById(@PathVariable String cartId){
        Optional<Cart> c_op=cartRepository.findById(cartId);
        if(c_op.isEmpty()){
            return false;
        }
        cartService.registerCart(c_op.get());
        return true;
    }

    @GetMapping("/list/{cartId}")
    Flux<Item> listCart(@PathVariable String cartId){
        Optional<Cart> c_op=cartRepository.findById(cartId);
        if(c_op.isEmpty()){
            return null;
        }
        return Flux.fromIterable(c_op.get().getMerchandises());
    }

    @GetMapping("/list")
    Flux<Item> listCurrentCart(){
        return Flux.fromIterable(cartService.getCart().getMerchandises());
    }

    @PostMapping("/add/{productId}/{quantity}")
    void addItemByProductId(@PathVariable String productId,@PathVariable Integer quantity){
        try {
            cartService.addItem(productId,quantity);
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/item/{productId}/{quantity}")
    void delItemByProductId(@PathVariable String productId,@PathVariable Integer quantity){
        try {
            cartService.delItem(productId,quantity);
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/item/{productId}")
    void delItemByProductId(@PathVariable String productId){
        try {
            cartService.delItem(productId);
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/cart")
    void delCart(){
        try {
            cartService.finish();
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/checkout")
    boolean checkoutCart(){
        try {
            cartService.checkout();
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @PostMapping("/logout")
    void logout(){
        try {
            cartService.logout();
        }
        catch (CartNotRegisteredException e){
            System.out.println(e.getMessage());
        }
    }


}
