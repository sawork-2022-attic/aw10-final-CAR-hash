package com.micropos.cart.utilities;

public class CartDuplicateException extends RuntimeException{
    public CartDuplicateException(String usrId,String cartId){
        super(usrId+" already has a cart "+cartId);
    }
}
