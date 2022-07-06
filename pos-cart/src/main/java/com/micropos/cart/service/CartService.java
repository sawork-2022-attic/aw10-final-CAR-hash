package com.micropos.cart.service;

import com.micropos.cart.client.CartWebClient;
import com.micropos.cart.repository.CartRepository;
import com.micropos.cart.utilities.CartDuplicateException;
import com.micropos.cart.utilities.CartNotRegisteredException;
import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import com.micropos.datatype.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    CartWebClient client;

    @Autowired
    CartRepository cartRepository;
    private Cart cart;

    public CartService(){
        cart=null;
    }

    @Override
    public void registerCart(Cart cart) {
        this.cart=cart;
    }

    @Override
    public String createAndRegisterCart(String usrId) {
        Cart c=cartRepository.findCartByUsrId(usrId);
        if(c!=null){
            throw new CartDuplicateException(usrId,c.getId());
        }
        cart=new Cart();
        cart.setUsrId(usrId);
        registerCart(cart);
        cartRepository.save(cart);
        return cart.getId();
    }

    @Override
    public boolean addItem(Item item) {
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        List<Item> items=cart.getMerchandises();
        for (Item i:items
             ) {
            if(i.getProduct().getId().equals(item.getProduct().getId())){
                i.setQuantity(i.getQuantity()+item.getQuantity());
                return true;
            }
        }
        items.add(item);
        return true;
    }

    @Override
    public boolean addItem(String productId, Integer quantity) {
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        client.getProduct(productId)
                .subscribe(product->{
                    Item item=new Item();
                    item.setProduct(product);
                    item.setQuantity(quantity);
                    List<Item> items=cart.getMerchandises();
                    boolean added=false;
                    for (Item i:items
                    ) {
                        if(i.getProduct().getId().equals(item.getProduct().getId())){
                            i.setQuantity(i.getQuantity()+item.getQuantity());
                            added=true;
                            break;
                        }
                    }
                    if(!added){
                        items.add(item);
                    }
                }
        );
        return true;
    }

    @Override
    public boolean delItem(Item item) {
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        cart.getMerchandises().remove(item);
        return true;
    }

    @Override
    public boolean delItem(String productId, Integer quantity) {
        if (cart == null) {
            throw new CartNotRegisteredException();
        }
        List<Item> items = cart.getMerchandises();
        Item toRemove = null;
        for (Item i : items
        ) {
            if (i.getProduct().getId().equals(productId)) {
                if (i.getQuantity() > quantity) {
                    i.setQuantity(i.getQuantity() - quantity);
                } else {
                    toRemove = i;
                }
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
        }

        return true;
    }

    public boolean delItem(String productId) {
        if (cart == null) {
            throw new CartNotRegisteredException();
        }
        List<Item> items = cart.getMerchandises();
        Item toRemove = null;
        for (Item i : items
        ) {
            if (i.getProduct().getId().equals(productId)) {
                toRemove = i;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
        }
        return true;
    }

    @Override
    public boolean clear() {
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        cart.getMerchandises().clear();
        return true;
    }

    public boolean logout(){
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        cartRepository.save(cart);
        return true;
    }

    @Override
    public boolean checkout() {
        System.out.println(1);
        if (cart == null) {
            throw new CartNotRegisteredException();
        }
        cartRepository.save(cart);
        client.checkOut(cart).subscribe();
        return true;
    }

    @Override
    public boolean finish() {
        if (cart==null){
            throw new CartNotRegisteredException();
        }
        cartRepository.delete(cart);
        cart=null;
        return true;
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}
