package com.micropos.cart.utilities;

public class CartNotRegisteredException extends RuntimeException {
    public CartNotRegisteredException() {
        super("Register a cart before doing any operation.");
    }
}
