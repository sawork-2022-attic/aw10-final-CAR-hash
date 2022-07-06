package com.micropos.cart.utilities;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(){
        super("cart not found.");
    }
}
