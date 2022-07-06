package com.micropos.product.utility;

import com.micropos.datatype.product.Product;

import java.beans.ExceptionListener;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
